package com.cheney.controller;

import com.cheney.dto.TestDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/feign")
public class TestForFeignController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1(HttpServletRequest request, String arg) throws IOException {
        System.out.println(request.getRequestURL());
        System.out.println("arg:" + arg);
        return "success";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public Map<String, Object> test2(HttpServletRequest request, @RequestBody TestDto param) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(param);
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public TestDto test3(TestDto testDto) throws IOException {
        System.out.println("arg:" + testDto);
        return testDto;
    }

}
