package br.com.devstoblu.cdshop.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
    private Long clientId;
    private List<Long> productIds;
    
	public Long getClientId() {
		return clientId;
	}
	public List<Long> getProductIds() {
		return productIds;
	}

    
}