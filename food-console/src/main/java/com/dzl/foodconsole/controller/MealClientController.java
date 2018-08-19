package com.dzl.foodconsole.controller;
import com.dzl.foodpojo.entity.Entry;
import com.dzl.foodpojo.entity.Meal;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author DZL
 * @desc 商品
 */
@Controller
public class MealClientController {
    @Autowired
    private  RestTemplate restTemplate;
    @RequestMapping("mealList")
    public String mealList(Integer page,String name,String entryId,Model model){

         ResponseEntity responseEntity= restTemplate.getForEntity("http://backservice-server/selectAllMeal?name={name}&entryId={entryId}&page={page}",PageInfo.class,name,entryId,page);
         PageInfo<Meal> pageInfo =(PageInfo<Meal>)responseEntity.getBody();
         List<Entry> clist = restTemplate.getForObject("http://backservice-server/selectAll", List.class);
         model.addAttribute("pageInfo",pageInfo);
         model.addAttribute("name",name);
         model.addAttribute("entryId",entryId);
         model.addAttribute("page",page);
         model.addAttribute("clist",clist);
         return "product";
    }
    @RequestMapping("toAddMeal")
    public String toAddMeal(Model model){
        List<Entry> clist = restTemplate.getForObject("http://backservice-server/selectAll", List.class);
        model.addAttribute("clist",clist);
        return "product-add";
    }
    @RequestMapping("addMeal")
    public String addMeal(Meal meal,Model model){
        restTemplate.put("http://backservice-server/saveMeal",meal);
        List<Entry> clist = restTemplate.getForObject("http://backservice-server/selectAll", List.class);
        model.addAttribute("clist",clist);
        return "product-add";
    }
    @RequestMapping("loadMeal")
    public String  loadMeal(Long id,Model model){
        ResponseEntity responseEntity= restTemplate.getForEntity("http://backservice-server/uploadMeal?id={id}",Meal.class,id);
        Meal meal =(Meal) responseEntity.getBody();
        List<Entry> clist = restTemplate.getForObject("http://backservice-server/selectAll", List.class);
        model.addAttribute("clist",clist);
        model.addAttribute("meal",meal);
        return "product-update";
    }
    @RequestMapping("updateMeal")
    public String updateMeal(Meal meal){
        restTemplate.put("http://backservice-server/updateMeal",meal);
        return "redirect:mealList";
    }
    @RequestMapping("delMeal")
    private String delMeal(Long id){
        restTemplate.delete("http://backservice-server/delMeal?id={1}",id);
        return "redirect:mealList";
    }
}
