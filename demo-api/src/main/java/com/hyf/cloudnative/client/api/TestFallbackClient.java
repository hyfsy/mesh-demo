package com.hyf.cloudnative.client.api;

import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.client.entity.User;
import com.hyf.cloudnative.remoting.mesh.K8SClient;
import com.hyf.cloudnative.remoting.mesh.RequestWay;
import com.hyf.cloudnative.remoting.mesh.proxy.FallbackFactory;
import org.springframework.stereotype.Component;

@K8SClient(value = "${k8s.service.demo.name}",
        requestWay = RequestWay.GRPC,
        fallbackFactory = TestFallbackFactoryClientImpl.class // fallbackFactory 和 fallback 同时指定时，fallback 优先
//        fallback = TestFallbackClientImpl.class
)
public interface TestFallbackClient {

    Result<User> getUserByFallback();

}

@Component
class TestFallbackClientImpl implements TestFallbackClient {

    @Override
    public Result<User> getUserByFallback() {
        return Result.of(new User(-1, "fallback"));
    }
}

@Component
class TestFallbackFactoryClientImpl implements FallbackFactory<TestFallbackClient> {

    @Override
    public TestFallbackClient create(Throwable cause) {
        return new TestFallbackClient() {
            @Override
            public Result<User> getUserByFallback() {
                cause.printStackTrace();
                return Result.of(new User(-1, "fallbackFactory"));
            }
        };
    }
}
