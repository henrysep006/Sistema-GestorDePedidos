/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI.GestorDePedidos.services;

import com.PI.GestorDePedidos.data.Cliente;
import com.PI.GestorDePedidos.data.Pedidos;
import com.PI.GestorDePedidos.data.Produto;
import com.PI.GestorDePedidos.data.clientesRepository;
import com.PI.GestorDePedidos.data.pedidosRepository;
import com.PI.GestorDePedidos.data.produtosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
    
    @Autowired
    clientesRepository clieRepo;
    
    @Autowired
    produtosRepository prodRepo;
    
    @Autowired
    pedidosRepository pedRepo;
    
    
    
    
    //PRODUTOS//
    
    public Produto criarProduto(Produto prod){
     if(prod!=null){
        prodRepo.save(prod);
     }
     else{
         System.out.println("PRODUTO NULO");
     }
        return prod;
        
    }
    
    public Produto getProdById(Integer id){
        
        return prodRepo.findById(id).orElse(null);
        
    }
    public Produto atualizarProduto(Integer id, Produto request){
        
        Produto prod= getProdById(id);
        
        prod.setCor(request.getCor());
        prod.setCustoun(request.getCustoun());
        prod.setLogotipo(request.getLogotipo());
        prod.setMaterial(request.getMaterial());
        prod.setNome(request.getNome());
        
        prodRepo.save(prod);
        
        return prod;
        
        
    }
    public void deletarProd(Integer id){
        Produto prod = getProdById(id);
        prodRepo.deleteById(prod.getId());
        
    }
    
    public List<Produto> getTodosProd(){
        return prodRepo.findAll();
    }

    
    
    
    //CLIENTES//
    
    public Cliente criarCliente(Cliente clie){
     
        clieRepo.save(clie);
        
        return clie;
        
    }
    
    public Cliente getClieById(Integer id){
        
        return clieRepo.findById(id).orElse(null);
        
    }
    public Cliente atualizarCliente(Integer id, Cliente request){
        
        Cliente clie= getClieById(id);
        
  clie.setEmail(request.getEmail());
  clie.setEndereco(request.getEndereco());
  clie.setNome(request.getNome());
  clie.setTelefone(request.getTelefone());
  
     clieRepo.save(clie);
        
        return clie;
        
    }
    public void deletarClie(Integer id){
       Cliente clie = getClieById(id);
     clieRepo.deleteById(clie.getId());
        
    }
    
    public List<Cliente> getTodosClie(){
        return clieRepo.findAll();
    }

    
    
    //PEDIDOS//
    
      public Pedidos criarPedido(Pedidos pedido){
     
        pedRepo.save(pedido);
        
        return pedido;
        
    }
    
    public Pedidos getPedById(Integer id){
        
        return pedRepo.findById(id).orElse(null);
        
    }
    public Pedidos atualizarCliente(Integer id, Pedidos request){
        
        Pedidos ped= getPedById(id);
        
 ped.setCliente(request.getCliente());
 ped.setData_entrega(request.getData_entrega());
 ped.setData_pedido(request.getData_pedido());
 ped.setNpedido(request.getNpedido());
 ped.setProduto(request.getProduto());
 ped.setQtd(request.getQtd());
 ped.setStatus(request.getStatus());
 
 
  
  pedRepo.save(ped);
        
        return ped;
        
    }
    public void deletarPed(Integer id){
       Pedidos ped = getPedById(id);
     pedRepo.deleteById(ped.getId());
        
    }
    
    public List<Pedidos> getTodosPed(){
        return pedRepo.findAll();
    }

    
    
    
    
    
    
    
}
