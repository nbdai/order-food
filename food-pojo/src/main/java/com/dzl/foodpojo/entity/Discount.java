package com.dzl.foodpojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * @desc 折扣
 */
@Component
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Data
public class Discount implements Serializable {
	@Id
    private Long id;
    private Integer fulls;//满的
    private Integer reduce;//减少
    private Long sid;
}