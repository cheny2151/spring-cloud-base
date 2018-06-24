package com.cheney.controller;

import com.cheney.client.TestFeignClient;
import com.cheney.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestFeignClient testFeignClient;

    @RequestMapping(value = "/test1")
    public String test() {
        String success = testFeignClient.test1("success");
        System.out.println("result:" + success);
        return "success";
    }

    @RequestMapping(value = "/test2")
    public String test2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("feign", "param");
        Map<String, Object> result = testFeignClient.test2(map);
        System.out.println(result);
        return "success";
    }

    @RequestMapping(value = "/test3")
    public String test3() {
        TestDto testDto = new TestDto();
        testDto.setFeign("param2");
        Map<String, Object> result = testFeignClient.test3(testDto);
        System.out.println(result);
        return "success";
    }

    @RequestMapping(value = "/test4")
    public TestDto test4() {
        TestDto testDto = testFeignClient.test4("param3");
        System.out.println(testDto);
        return testDto;
    }

}
