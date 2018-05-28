package com.cheney.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${profile}")
    private String profile;

    @RequestMapping("/test")
    public String test() throws InterruptedException {
        logger.info(profile);
//        throw new RuntimeException();
        Thread.sleep(3000);
        return discoveryClient.getServices() + "2";
    }

}
