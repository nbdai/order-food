package com.dzl.foodbackservice.sku;

import com.dzl.foodpojo.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkuServerController {
    @Autowired
     private SkuService skuService;
    @RequestMapping("selectAllSku")
    public List<Sku> selectAllSku(Long mealId){
        return skuService.findAll(mealId);
    }
    @RequestMapping("updateSku")
    public void updateSku(@RequestBody Sku sku){
        skuService.updateSku(sku.getId(), sku.getStock());
    }
}
