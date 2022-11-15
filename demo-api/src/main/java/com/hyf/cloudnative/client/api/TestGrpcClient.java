package com.hyf.cloudnative.client.api;

import com.hyf.cloudnative.client.entity.User;
import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.remoting.mesh.K8SClient;

@K8SClient("${k8s.service.demo.name}")
public interface TestGrpcClient {

    Result<User> getUserByIdByGrpc(Integer id);

}
