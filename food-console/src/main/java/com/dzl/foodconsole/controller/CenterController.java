package com.dzl.foodconsole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CenterController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("toAddEntry")
    public String toAddEntry(){
        return "category-add";
    }

}
