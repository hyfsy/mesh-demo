

此项目为Java微服务接入K8S+Istio的Demo项目，同时展示了 [`cloudnative-remoting-mesh`](https://github.com/hyfsy/cloudnative-remoting-mesh) 项目的使用方式

> 快速开始仅需启动 demo-consumer 和 demo-provider



Demo接口：

```bash
curl http://localhost:8081/demo/http/1
curl http://localhost:8081/demo/grpc/2
curl http://localhost:8081/demo/config
curl http://localhost:8081/demo/fallback
```



本地测试注意事项：

1. 本地启动请将 `DemoConsumerApplication` 类的注释代码放开
2. hosts文件添加：`127.0.0.1 service-demo-provider.default.svc.cluster.local`





