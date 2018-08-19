package com.dzl.fooddao.sku;
import com.dzl.foodpojo.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SkuReposity extends JpaRepository<Sku,Long>{
    List<Sku> findByMealId(Long mealId);
    @Modifying
    @Query("update Sku s set s.stock = ?1 where s.id = ?2")
    void updateSku(Long stock,Long id);
}
