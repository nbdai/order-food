package com.dzl.foodbackservice.meal;

import com.dzl.fooddao.mapper.MealMapper;
import com.dzl.fooddao.meal.MealReposity;
import com.dzl.fooddao.sku.SkuReposity;
import com.dzl.foodpojo.entity.Meal;
import com.dzl.foodpojo.entity.Sku;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;


@Service("mealService")
public class MealService {
    @Autowired
    private MealReposity mealReposity;
    @Autowired
    private MealMapper mealMapper;
    @Autowired
    private SkuReposity skuReposity;
    @Autowired
    private JedisPool jedisPool;
    public PageInfo<Meal> findAll(String name ,String entryId,Integer page){
        Meal meal = new Meal();
        if(page==null||"".equals(page)||"null".equals(page)){
             meal.setPage(1);
        }else {
            meal.setPage(page);
        }

        if(name!=null&&!"".equals(name)&&!"null".equals(name)){
             meal.setName(name);
        }
        if(entryId!=null&&!"".equals(entryId)&&!"null".equals(entryId)){
            Long entryId1 = Long.parseLong(entryId);
            meal.setEntryId(entryId1);
        }

        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(meal.getPage(),4);
        List<Meal> mealList = mealMapper.selectLimit(meal);
        PageInfo<Meal> pageInfo = new PageInfo<>(mealList);
        return pageInfo;
    }
    public void addMeal(Meal meal){
        Jedis jedis = jedisPool.getResource();
        Jedis jedis1 = jedisPool.getResource();
        Long mealId = jedis.incr("mealId");
        meal.setId(mealId);
        meal.setIsDel(true);
        mealReposity.save(meal);
        jedis.close();
        //添加商品时 价格默认为最低 ，并且要触发 库存自动添加.
        List<Sku> skuList = new ArrayList<>();
        for(int i = 0;i<3;i++){
             Sku sku = new Sku();
             Long skuId = jedis1.incr("skuId");
             sku.setId(skuId);
             sku.setDeliveFee(2F);
             if(i==0){
                 sku.setInprice(meal.getPrice());
                 sku.setMealId(meal.getId());
                 sku.setSize("小");
             }else if(i==1){
                 sku.setInprice(meal.getPrice()*1.2F);
                 sku.setMealId(meal.getId());
                 sku.setSize("中");
             }else {
                 sku.setInprice(meal.getPrice()*1.5F);
                 sku.setMealId(meal.getId());
                 sku.setSize("大");
             }
                skuList.add(sku);
        }
                skuReposity.saveAll(skuList);
                jedis1.close();
    }
    public Meal upLoadMeal(Long id){
       if(id==null){
           return null;
       }
           return mealReposity.getOne(id);
    }
    public  void  saveMeal(Meal meal){
         mealReposity.save(meal);
    }
    @Transactional
    public void delMeal(Long id){
        mealReposity.updateById(id);
    }
    public List<Meal> findByEntryId(Long entryId){
        return mealReposity.findByEntryId(entryId);
    }
}
