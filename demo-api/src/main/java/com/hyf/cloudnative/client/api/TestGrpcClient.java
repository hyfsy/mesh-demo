package com.hyf.cloudnative.client.api;

import com.hyf.cloudnative.client.entity.User;
import com.hyf.cloudnative.client.entity.Result;
import com.hyf.cloudnative.remoting.mesh.K8SClient;
import com.hyf.cloudnative.remoting.mesh.RequestWay;

@K8SClient(value = "${k8s.service.demo.name}", requestWay = RequestWay.GRPC)
public interface TestGrpcClient {

    Result<User> getUserByIdByGrpc(Integer id);

}
