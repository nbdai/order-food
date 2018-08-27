package com.dzl.foodconsole.controller;


import com.dzl.foodpojo.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class AjaxController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("ImgLoad")
    public String imgLoad(@RequestParam MultipartFile pic){
        String path = "F:/Project/ideaworkplace1/order-food/food-console/src/main/resources/static/load";
        try {
            pic.transferTo(new File(path+File.separator+pic.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
         return "http://127.0.0.1:8081/"+"load"+File.separator+pic.getOriginalFilename();
    }
    @RequestMapping("updateSkus")
    public void  updateSku(Long id,Long stock){

         Sku sku = new Sku();
         sku.setId(id);
         sku.setStock(stock);
         restTemplate.put("http://backservice-server/updateSku",sku);
    }
}
