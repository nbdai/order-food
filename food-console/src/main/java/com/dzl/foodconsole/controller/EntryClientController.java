package com.dzl.foodconsole.controller;

import com.dzl.foodpojo.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@Controller
public class EntryClientController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("entryList")
    public String entryList(Model model){
        List<Entry> clist = restTemplate.getForObject("http://backservice-server/selectAll", List.class);
        model.addAttribute("clist",clist);
        return "category";
    }
    @RequestMapping("AddEntry")
    public String addEntry( Entry entry){
          restTemplate.put("http://backservice-server/saveEntry",entry);
          return "category-add";
    }
    @RequestMapping("delEntry")
    public String delEntry(Long id){
          restTemplate.delete("http://backservice-server/delEntry?id={1}",id);
          return "redirect:entryList";
    }
    @RequestMapping("loadEntry")
    public String  loadEntry(Long id,Model model){
       ResponseEntity responseEntity= restTemplate.getForEntity("http://backservice-server/uploadEntry?id={id}",Entry.class,id);
       Entry entry =(Entry)responseEntity.getBody();
       model.addAttribute("entry",entry);
       return "category-update";
    }
    @RequestMapping("updateEntry")
    public String updateEntry(Entry entry){
        restTemplate.put("http://backservice-server/updateEntry",entry);
        return "redirect:entryList";
    }
}
