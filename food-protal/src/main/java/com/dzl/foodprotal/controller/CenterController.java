package com.dzl.foodprotal.controller;

import com.dzl.foodpojo.entity.Entry;
import com.dzl.foodpojo.entity.Meal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Controller
public class CenterController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("index1")
    public String index1(){
        return "index";
    }
    @RequestMapping("todemo")
    public String demo(Model model){
        List<Entry> elist = restTemplate.getForObject("http://backservice-server/selectAll",List.class);
        model.addAttribute("elist",elist);
        ParameterizedTypeReference<List<Entry>> typeRef = new ParameterizedTypeReference<List<Entry>>() {
        };
        ResponseEntity<List<Entry>> responseEntity1 = restTemplate.exchange("http://backservice-server/selectAll", HttpMethod.POST, new HttpEntity<>(null), typeRef);
        List<Entry> entryList = responseEntity1.getBody();

        int count = 1;
        for(Entry entry :entryList){
            ResponseEntity responseEntity = restTemplate.getForEntity("http://backservice-server/findByEntryId?entryId={entryId}",List.class,entry.getId());
            List<Meal> mealList = (List<Meal>) responseEntity.getBody();
            model.addAttribute("c"+count+"Product",mealList);
            count++;
        }
        return "demo";
    }
}
