package br.com.devstoblu.cdshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devstoblu.cdshop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
