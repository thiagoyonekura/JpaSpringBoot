package com.spring.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import com.spring.springjpa.entity.Cliente;
import com.spring.springjpa.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

	private ClienteService clienteService;

	@Autowired
	public ClienteController(@RequestBody ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping(path = "/add")
	public @ResponseBody String add(@RequestParam String name, @RequestParam String email) {
		clienteService.cadastrar(name, email);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody List<Cliente> listar() {
	    // Implementação do método para listar todos os clientes
	    List<Cliente> clientes = clienteService.listar();
	    return clientes;
	}

	@GetMapping(path = "/name/{name}")
	public @ResponseBody List<Cliente> buscarPorNome(@PathVariable String name) {
		return clienteService.buscarPorNome(name);
	}

	@GetMapping(path = "/email/{email}")
	public @ResponseBody List<Cliente> buscarPorEmail(@PathVariable String email) {
		return clienteService.buscarPorEmail(email);
	}

	
	@PutMapping("/{id}")
    public @ResponseBody Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        return clienteService.atualizar(cliente, id);
    }

	@DeleteMapping(path = "/{id}")
	public @ResponseBody String deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return "User deleted";
	}

}
