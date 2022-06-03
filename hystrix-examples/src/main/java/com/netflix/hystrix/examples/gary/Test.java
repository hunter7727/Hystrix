package com.netflix.hystrix.examples.gary;

import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws InterruptedException, IOException {
        RestTemplate restTemplate = new RestTemplate();
//        String throwExceptionUrl = "http://118.195.174.15:28802/provider/throwException";
//        String slowUrl = "http://118.195.174.15:28802/provider/slowRequest";
        String normalUrl = "http://118.195.174.15:28802/provider/normalRequest";
        HelloWordCommand command = new HelloWordCommand(HystrixCommandGroupKey.Factory.asKey("default"),
                restTemplate,normalUrl);
        String result = command.execute();
        System.out.println("======="+result);
        System.in.read();
    }


}
