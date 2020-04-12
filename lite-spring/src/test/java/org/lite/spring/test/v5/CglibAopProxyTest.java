package org.lite.spring.test.v5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lite.spring.aop.aspectj.AspectJAfterReturningAdvice;
import org.lite.spring.aop.aspectj.AspectJBeforeAdvice;
import org.lite.spring.aop.aspectj.AspectJExpressionPointcut;
import org.lite.spring.aop.config.AspectInstanceFactory;
import org.lite.spring.aop.framework.AopConfig;
import org.lite.spring.aop.framework.AopConfigSupport;
import org.lite.spring.aop.framework.CglibProxyFactory;
import org.lite.spring.beans.factory.BeanFactory;
import org.lite.spring.service.v5.PetStoreService;
import org.lite.spring.tx.TransactionManager;
import org.lite.spring.util.MessageTracker;

import java.util.List;

/**
 * Created by bfq on 2020/4/5
 */
public class CglibAopProxyTest extends AbstractV5Test {
    private static AspectJBeforeAdvice beforeAdvice = null;
    private static AspectJAfterReturningAdvice afterAdvice = null;
    private static AspectJExpressionPointcut pc = null;

    private TransactionManager tx = null;

    private BeanFactory beanFactory = null;
    private AspectInstanceFactory aspectInstanceFactory = null;

    @Before
    public void setUp() throws Exception {
        tx = new TransactionManager();
        String expression = "execution(* org.lite.spring.service.v5.*.placeOrder(..))";
        pc = new AspectJExpressionPointcut();
        pc.setExpression(expression);

        beanFactory = this.getBeanFactory("petstore-v5.xml");
        aspectInstanceFactory = this.getAspectInstanceFactory("tx");
        aspectInstanceFactory.setBeanFactory(beanFactory);

        beforeAdvice = new AspectJBeforeAdvice(TransactionManager.class.getMethod("start"), pc, aspectInstanceFactory);
        afterAdvice = new AspectJAfterReturningAdvice(TransactionManager.class.getMethod("commit"), pc, aspectInstanceFactory);
        MessageTracker.clearMsgs();
    }

    @Test
    public void testGetProxy() {
        AopConfig config = new AopConfigSupport();
        config.addAdvice(beforeAdvice);
        config.addAdvice(afterAdvice);
        config.setTargetObject(new PetStoreService());

        CglibProxyFactory proxyFactory = new CglibProxyFactory(config);
        PetStoreService proxy = (PetStoreService) proxyFactory.getProxy();

        proxy.placeOrder();

        List<String> msgs = MessageTracker.getMsgs();
        Assert.assertEquals(3, msgs.size());
        Assert.assertEquals("start tx", msgs.get(0));
        Assert.assertEquals("place order", msgs.get(1));
        Assert.assertEquals("commit tx", msgs.get(2));

        proxy.toString();
    }
}
