package com.cheney.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient discoveryClient;
//    @Value("${profile}")
//    private String profile;

    @RequestMapping("/test")
    public String test() {
        logger.info("success");
        return discoveryClient.getServices() + "2";
    }

}
