package com.netflix.hystrix.examples.gary;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class HelloWordCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;
    private String url;



    protected HelloWordCommand(HystrixCommandGroupKey group,RestTemplate restTemplate,String url) {
        super(group);
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject(url,String.class);
    }

    @Override
    protected String getFallback() {
        return "降级了";
    }
}
