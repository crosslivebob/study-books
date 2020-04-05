package org.lite.spring.test.v5;

import net.sf.cglib.proxy.*;
import org.junit.Test;
import org.lite.spring.service.v5.PetStoreService;
import org.lite.spring.tx.TransactionManager;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/4/5
 */
public class CGLibTest {
    @Test
    public void testCallBack() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PetStoreService.class);

        enhancer.setCallback(new TransactionInterceptor());
        PetStoreService petStore = (PetStoreService) enhancer.create();
        petStore.placeOrder();
    }

    public static class TransactionInterceptor implements MethodInterceptor {
        TransactionManager txManager = new TransactionManager();
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            txManager.start();
            // 切记此处不能调用invoke，会陷入死循环（一直无限调用自身）
            Object result = proxy.invokeSuper(obj, args);
            txManager.commit();
            return result;
        }
    }

    @Test
    public void testFilter() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PetStoreService.class);

        enhancer.setInterceptDuringConstruction(false);

        Callback[] callbacks = new Callback[] {new TransactionInterceptor(), NoOp.INSTANCE};
        Class<?>[] types = new Class<?>[callbacks.length];

        for (int x = 0; x < types.length; x++) {
            types[x] = callbacks[x].getClass();
        }

        enhancer.setCallbackFilter(new ProxyCallBackFilter());
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackTypes(types);

        PetStoreService petStore = (PetStoreService) enhancer.create();
        petStore.placeOrder();
        System.out.println(petStore.toString());
    }

    private static class ProxyCallBackFilter implements CallbackFilter {

        @Override
        public int accept(Method method) {
            if (method.getName().startsWith("place")) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
