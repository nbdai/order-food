package com.dzl.foodbackservice.sku;

import com.dzl.fooddao.sku.SkuReposity;
import com.dzl.foodpojo.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkuService {
    @Autowired
    private SkuReposity skuReposity;
    public List<Sku> findAll(Long mealId){
        return skuReposity.findByMealId(mealId);
    }
    @Transactional
    public  void  updateSku(Long id,Long stock){
        skuReposity.updateSku(stock,id);
    }
}
