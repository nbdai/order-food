package com.dzl.foodpojo.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Orders implements Serializable{
	@Id
    private Long oid;
    private String oname;
    private String oaddress;//地址
    private Integer buystate = BuyerEnum.YPM.getCode();//支付状态
    private Integer ostate = OrderEnum.NEW.getCode();//订单状态
    private Date ocreatetime;
    private Date oupdatetime;
    private String note;//备注
    private String phone;
    private Long mealId;//商品id 去meal 查。
	private Long skuId; //库存id  去sku 查
	private Long disId;//折扣。
	public Long getDisId() {
		return disId;
	}
	public void setDisId(Long disId) {
		this.disId = disId;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Date getOcreatetime() {
		return ocreatetime;
	}
	public void setOcreatetime(Date ocreatetime) {
		this.ocreatetime = ocreatetime;
	}
	public Date getOupdatetime() {
		return oupdatetime;
	}
	public void setOupdatetime(Date oupdatetime) {
		this.oupdatetime = oupdatetime;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public Integer getBuystate() {
		return buystate;
	}
	public void setBuystate(Integer buystate) {
		this.buystate = buystate;
	}
	public Integer getOstate() {
		return ostate;
	}
	public void setOstate(Integer ostate) {
		this.ostate = ostate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public OrderEnum getOrderEnum(){
    	return OrderEnum.getOrderEnum(ostate);
    }
     public BuyerEnum getBuyerEnum(){
    	return BuyerEnum.getBuyerEnum(buystate);
    }
     public String getTime(){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = sd.format(ocreatetime);
			return str;
    }
	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
}