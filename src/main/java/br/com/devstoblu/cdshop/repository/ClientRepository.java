package br.com.devstoblu.cdshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devstoblu.cdshop.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
