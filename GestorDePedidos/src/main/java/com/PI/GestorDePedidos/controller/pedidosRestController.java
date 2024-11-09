/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI.GestorDePedidos.controller;


import com.PI.GestorDePedidos.data.Pedidos;
import com.PI.GestorDePedidos.data.PedidosDTO;
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
@RequestMapping("/pedido")
public class pedidosRestController {
    
    @Autowired
    Services Serv;
    
    
  @GetMapping("/listar")
public ResponseEntity<List<PedidosDTO>> getPedidosComNomes() {
    List<PedidosDTO> pedidosDTO = Serv.getTodosPedComNomes();
    return new ResponseEntity<>(pedidosDTO, HttpStatus.OK);
}
        
        @PostMapping("/adicionar")
public ResponseEntity<Pedidos> adicionarPedidos(@RequestBody Pedidos ped) {
    
     int idProd = ped.getProduto().getId();
     int idClie = ped.getCliente().getId();
     

 Serv.criarPedido(idProd, idClie, ped);
    return new ResponseEntity<>(ped, HttpStatus.CREATED);
}
     @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Pedidos> pesquisarPorId(@PathVariable Integer id){
        
Pedidos ped = Serv.getPedById(id);
 
 return new ResponseEntity<>(ped, HttpStatus.OK);
        
        
    }
    @DeleteMapping("/excluir/{id}")
public ResponseEntity<Void> excluirPedido(@PathVariable Integer id) {
    Serv.deletarPed(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
    
}
