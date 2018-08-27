package com.dzl.foodpojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author DZL
 * @desc 商品表
 */
@Entity
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Meal implements Serializable{
    @Id
    private Long id;
    private String name;
    private Float price;
    private String imgUrl;
    private Long entryId;
    private Boolean isDel;
    private String description;
    private Integer page;

}