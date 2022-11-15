package com.hyf.cloudnative.provider;

import com.hyf.cloudnative.client.api.TestGrpcClient;
import com.hyf.cloudnative.client.api.TestHttpClient;
import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.client.entity.User;
import com.hyf.cloudnative.remoting.mesh.GrpcController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@GrpcController
@RestController
@RequestMapping("user")
public class DemoProviderV2Controller implements TestHttpClient, TestGrpcClient {

    @Override
    public Result<User> getUserByIdByHttp(Integer id) {
        return Result.of(new User(id, "v2: http_zhagnsan" + id));
    }

    @Override
    public Result<User> getUserByIdByGrpc(Integer id) {
        return Result.of(new User(id, "v2: grpc_zhagnsan" + id));
    }
}
