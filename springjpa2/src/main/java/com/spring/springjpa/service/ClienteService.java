package com.spring.springjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.springjpa.entity.Cliente;
import com.spring.springjpa.repository.ClienteRepositorio;


@Service
public class ClienteService {
	
    @Autowired

	private ClienteRepositorio clienteRepositorio;

    public Cliente cadastrar(String name, String email) {
    	Cliente cliente = new Cliente();
    	cliente.setName(name);
    	cliente.setEmail(email);
        return clienteRepositorio.save(cliente);
    }

    public List<Cliente> listar() {
        // Implementação do método para listar todos os clientes
        return clienteRepositorio.findAll();
    }

    public List<Cliente> buscarPorNome(String name) {
        return clienteRepositorio.findByName(name);
    }

    public List<Cliente> buscarPorEmail(String email) {
        return clienteRepositorio.findByEmail(email);
    }

    public Cliente atualizar(Cliente cliente, Long id){
        if(!clienteRepositorio.existsById(id)){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        cliente.setId(id);
        Cliente updated = clienteRepositorio.save(cliente);

        return updated;
    }

    public void deletar(Long id) {
    	clienteRepositorio.deleteById(id);
    }}

	
		
	

