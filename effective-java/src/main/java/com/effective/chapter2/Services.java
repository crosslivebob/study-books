package com.effective.chapter2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//服务接口
interface Service {

}

//提供服务接口
interface Provider {
    Service newService();
}

/**
 * P7 一个服务者提供接口和一个默认提供者
 */
public class Services {
    private Services(){};

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // 提供者注册API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    //服务访问API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    private static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }
}
