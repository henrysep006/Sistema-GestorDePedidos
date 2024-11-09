/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI.GestorDePedidos.controller;

import com.PI.GestorDePedidos.data.Produto;
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
 */
@RestController
@RequestMapping("/produto")
public class produtosRestController {
    
    @Autowired
    Services Serv;
    
    
   
    @GetMapping("/listar")
public ResponseEntity<List> getProduto(){
        
        List<Produto> prod = Serv.getTodosProd();
        
        return new ResponseEntity<>(prod, HttpStatus.OK);
}
        
        @PostMapping("/adicionar")
public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto prod) {
   

 Serv.criarProduto(prod);
    return new ResponseEntity<>(prod, HttpStatus.CREATED);
}
     @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Produto> pesquisarPorId(@PathVariable Integer id){
        
Produto prod = Serv.getProdById(id);
 
 return new ResponseEntity<>(prod, HttpStatus.OK);
        
        
    }
    @DeleteMapping("/excluir/{id}")
public ResponseEntity<Void> excluirProduto(@PathVariable Integer id) {
    Serv.deletarProd(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}