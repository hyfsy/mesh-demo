package com.hyf.cloudnative.consumer;

import com.hyf.cloudnative.client.api.TestGrpcClient;
import com.hyf.cloudnative.client.api.TestHttpClient;
import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.client.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("demo")
public class DemoConsumerController {

    @Resource
    private TestHttpClient testHttpClient;
    @Resource
    private TestGrpcClient testGrpcClient;

    @Resource
    private DemoConsumerProperties properties;

    @GetMapping("http/{id}")
    public Result<User> getByHttp(@PathVariable Integer id) {
        return testHttpClient.getUserByIdByHttp(id);
    }

    @GetMapping("grpc/{id}")
    public Result<User> getByGrpc(@PathVariable Integer id) {
        return testGrpcClient.getUserByIdByGrpc(id);
    }

    @GetMapping("config")
    public String getProperties() {
        return properties.toString();
    }
}
