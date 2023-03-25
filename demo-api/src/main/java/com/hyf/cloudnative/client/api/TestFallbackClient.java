package com.hyf.cloudnative.client.api;

import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.client.entity.User;
import com.hyf.cloudnative.client.fallback.TestFallbackFactoryClientImpl;
import com.hyf.cloudnative.remoting.mesh.K8SClient;
import com.hyf.cloudnative.remoting.mesh.RequestWay;

@K8SClient(value = "${k8s.service.demo.name}",
        requestWay = RequestWay.GRPC,
        fallbackFactory = TestFallbackFactoryClientImpl.class // fallbackFactory 和 fallback 同时指定时，fallback 优先
//        fallback = TestFallbackClientImpl.class
)
public interface TestFallbackClient {

    Result<User> getUserByFallback();

}

