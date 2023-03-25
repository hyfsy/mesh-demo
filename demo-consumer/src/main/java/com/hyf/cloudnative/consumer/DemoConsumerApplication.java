package com.hyf.cloudnative.consumer;

import com.hyf.cloudnative.remoting.mesh.EnableK8SClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableK8SClients("com.hyf.cloudnative.client.api")
@ComponentScan(basePackageClasses = DemoConsumerApplication.class, basePackages = "com.hyf.cloudnative.client.fallback")
@SpringBootApplication
public class DemoConsumerApplication {

    public static void main(String[] args) {
        // System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(DemoConsumerApplication.class, args);
    }
}
