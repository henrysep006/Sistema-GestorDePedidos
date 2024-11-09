/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI.GestorDePedidos.controller;

import com.PI.GestorDePedidos.data.Cliente;

import com.PI.GestorDePedidos.services.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Henry
 */@RestController
@RequestMapping("/cliente")
public class clientesRestController {
    
    @Autowired
    Services Serv;
    
    
   
    @GetMapping("/listar")
public ResponseEntity<List> getCliente(){
        
        List<Cliente> prod = Serv.getTodosClie();
        
        return new ResponseEntity<>(prod, HttpStatus.OK);
}
        
        @PostMapping("/adicionar")
public ResponseEntity<Cliente> adicionarProduto(@RequestBody Cliente clie) {
   

 Serv.criarCliente(clie);
    return new ResponseEntity<>(clie, HttpStatus.CREATED);
}
     @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Cliente> pesquisarPorId(@PathVariable Integer id){
        
Cliente clie = Serv.getClieById(id);
 
 return new ResponseEntity<>(clie, HttpStatus.OK);
        
        
    }
    @DeleteMapping("/excluir/{id}")
public ResponseEntity<Void> excluirCliente(@PathVariable Integer id) {
    Serv.deletarClie(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
