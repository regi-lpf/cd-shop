package br.com.devstoblu.cdshop.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private String name;
    private String email;
    
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

    
}