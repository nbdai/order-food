package com.dzl.foodbackservice.buyer;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {
    @RequestMapping("getBuyer")
    public String  getBuyer(){
        return "dai";
    }
}
