package br.com.devstoblu.cdshop.model;


import br.com.devstoblu.cdshop.dto.OrderDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDTO order;

    public Product() {
    	
    }

	public Product(Long id, String title, double price, OrderDTO order) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO orderDTO) {
		this.order = orderDTO;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", order=" + order + "]";
	}
    
    
}
