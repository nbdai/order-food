package com.dzl.foodpojo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * desc 库存表
 */
@Entity
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Sku implements Serializable{
    @Id
    private Long id;
    private Long mealId;
    private Long stock;
    private String  size;
    private Float deliveFee;
    private Float inprice;
}
