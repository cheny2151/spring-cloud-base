package com.cheney.client;

import com.cheney.dto.TestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("eureka-client")
public interface TestFeignClient {

    @GetMapping("/feign/test1")
    String test1(@RequestParam("arg") String arg);

    @PostMapping("/feign/test2")
    Map<String, Object> test2(Map<String, Object> arg);

    @PostMapping("/feign/test2")
    Map<String, Object> test3(TestDto testDto);

    @GetMapping("/feign/test3")
    TestDto test4(@RequestParam("feign") String feign);

}
