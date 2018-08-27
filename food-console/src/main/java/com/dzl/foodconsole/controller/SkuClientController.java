package com.dzl.foodconsole.controller;
import com.dzl.foodpojo.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author DZL
 * @deac 库存
 */
@Controller
public class SkuClientController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("skuList")
    public String skuList(Long mealId,Model model){
          List<Sku> slist  = restTemplate.getForObject("http://backservice-server/selectAllSku?mealId={mealId}",List.class,mealId);
          model.addAttribute("slist",slist);
         return "repertory";
    }
}
