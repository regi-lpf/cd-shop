package br.com.devstoblu.cdshop.model;


import java.util.List;

import br.com.devstoblu.cdshop.dto.ClientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientDTO client;
    @OneToMany(mappedBy = "order")
    private List<Product> products;

    public Order() {
    	}

	public Order(Long id, ClientDTO client, List<Product> products) {
		super();
		this.id = id;
		this.client = client;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO clientDTO) {
		this.client = clientDTO;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", client=" + client + ", products=" + products + "]";
	}
    
    
}
