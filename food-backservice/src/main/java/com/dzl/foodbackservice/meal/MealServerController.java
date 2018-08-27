package com.dzl.foodbackservice.meal;

import com.dzl.foodpojo.entity.Entry;
import com.dzl.foodpojo.entity.Meal;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealServerController {
    @Autowired
    private MealService mealService;
    @RequestMapping("selectAllMeal")
    public PageInfo<Meal> selectAll(String name,String entryId,Integer page){
        return mealService.findAll(name,entryId,page);
    }
    @RequestMapping("saveMeal")
    public void saveMeal(@RequestBody Meal meal){
       mealService.addMeal(meal);
    }
    @RequestMapping("uploadMeal")
    public Meal uploadMeal(Long id){
       return mealService.upLoadMeal(id);
    }
    @RequestMapping("updateMeal")
    public void updateMeal(@RequestBody Meal meal){
        mealService.saveMeal(meal);
    }
    @RequestMapping("delMeal")
    public void delMeal(@RequestParam Long id){
      mealService.delMeal(id);
    }
    @RequestMapping("findByEntryId")
    List<Meal> findByEntryId(Long entryId){
        return mealService.findByEntryId(entryId);
    }
}
