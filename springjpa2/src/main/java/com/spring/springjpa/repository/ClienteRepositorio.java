package com.spring.springjpa.repository;

import com.spring.springjpa.entity.Cliente;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	  List<Cliente> findByName(String nome);

	  List<Cliente> findByEmail(String email);
	}