/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI.GestorDePedidos.services;

import com.PI.GestorDePedidos.data.Cliente;
import com.PI.GestorDePedidos.data.Pedidos;
import com.PI.GestorDePedidos.data.PedidosDTO;
import com.PI.GestorDePedidos.data.Produto;
import com.PI.GestorDePedidos.data.clientesRepository;
import com.PI.GestorDePedidos.data.pedidosRepository;
import com.PI.GestorDePedidos.data.produtosRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
    
      public Pedidos criarPedido(int idProd, int idClie, Pedidos pedido){
     
         Produto prod= getProdById(idProd);
          pedido.setProduto(prod);
          
          Cliente clie= getClieById(idClie);
          pedido.setCliente(clie);
        pedRepo.save(pedido);
        
        return pedido;
        
    }
    
    public Pedidos getPedById(Integer id){
        
        return pedRepo.findById(id).orElse(null);
        
    }
    public Pedidos atualizarPedido(Integer id, Pedidos request){
        
        Pedidos ped= getPedById(id);
        
 ped.setCliente(request.getCliente());
 ped.setData_entrega(request.getData_entrega());

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

    public List<PedidosDTO> getTodosPedComNomes() {
    List<PedidosDTO> lista = new ArrayList<>();
    
    for (Pedidos p : getTodosPed()) {
        PedidosDTO dto = new PedidosDTO();
         dto.setId(p.getId());
        dto.setNpedido(p.getNpedido());
        dto.setProdutoNome(p.getProduto().getNome());  // Aqui está buscando o nome do produto
        dto.setClienteNome(p.getCliente().getNome());  // Aqui está buscando o nome do cliente
        dto.setStatus(p.getStatus());
        dto.setData_entrega(p.getData_entrega());
        dto.setQtd((int) p.getQtd());
        lista.add(dto);
    }

    return lista;
}

     public void atualizarStatus(int id, String novoStatus) {
        Pedidos pedido = pedRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Pedido não encontrado"));

        pedido.setStatus(novoStatus);
        pedRepo.save(pedido);
    }
  
    
}
