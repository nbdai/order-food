package com.dzl.fooddao.meal;

import com.dzl.foodpojo.entity.Meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealReposity extends JpaRepository<Meal,Long>{
    @Modifying
    @Query("update Meal m set m.isDel= 0 where m.id = ?1")
    void updateById(Long id);
    List<Meal>  findByEntryId(Long entryId);
}
