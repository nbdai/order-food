package com.dzl.fooddao.mapper;

import com.dzl.foodpojo.entity.Meal;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MealMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Meal record);
    int insertSelective(Meal record);
    List<Meal> selectLimit(Meal meal);
    Meal selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Meal record);
    int updateByPrimaryKey(Meal record);
}