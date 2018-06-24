package com.cheney;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.cheney"})
public class Client2Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Client2Application.class).web(WebApplicationType.SERVLET).run(args);
    }

}
