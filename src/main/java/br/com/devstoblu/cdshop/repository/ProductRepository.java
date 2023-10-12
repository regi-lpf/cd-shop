package br.com.devstoblu.cdshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devstoblu.cdshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
