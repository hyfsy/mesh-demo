package com.hyf.cloudnative.client.api;

import com.hyf.cloudnative.client.entity.User;
import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.remoting.mesh.K8SClient;
import com.hyf.cloudnative.remoting.mesh.RequestWay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@K8SClient(name = "${k8s.service.demo.name}", requestWay = RequestWay.HTTP)
@RequestMapping("user")
public interface TestHttpClient {

    @GetMapping("{id}")
    Result<User> getUserByIdByHttp(@PathVariable("id") Integer id);

}
