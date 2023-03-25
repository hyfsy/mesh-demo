package com.hyf.cloudnative.client.fallback;

import com.hyf.cloudnative.client.api.TestFallbackClient;
import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.client.entity.User;
import com.hyf.cloudnative.remoting.mesh.proxy.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2023/03/25
 */
@Component
public class TestFallbackFactoryClientImpl implements FallbackFactory<TestFallbackClient> {

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
