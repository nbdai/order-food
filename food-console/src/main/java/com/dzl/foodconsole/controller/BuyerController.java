package com.dzl.foodconsole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BuyerController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/gets")
    public String gets(){
        return restTemplate.getForObject("http://backservice-server/getBuyer",String.class);
    }
}
