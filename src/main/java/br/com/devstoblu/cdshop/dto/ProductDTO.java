package br.com.devstoblu.cdshop.dto;

import lombok.Data;

@Data
public class ProductDTO {
	private String title;
	private double price;
	private Long orderId;
	
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	public Long getOrderId() {
		return orderId;
	}
	
}
