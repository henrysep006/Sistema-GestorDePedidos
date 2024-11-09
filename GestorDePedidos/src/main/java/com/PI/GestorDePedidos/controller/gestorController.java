/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI.GestorDePedidos.controller;
import com.PI.GestorDePedidos.data.Cliente;
import com.PI.GestorDePedidos.data.Pedidos;
import com.PI.GestorDePedidos.data.Produto;
import com.PI.GestorDePedidos.services.Services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Henry
 */
@Controller
public class gestorController {

@Autowired
Services Serv;




 @GetMapping("/")
public String mostraPedidos(Model model){
      Pedidos ped=new Pedidos();
      
      model.addAttribute("pedido", ped);
    
    
    return "verPedidos";
} 

//produtos
 @GetMapping("/produtos")
public String mostraProdutos(Model model){
    Produto prod = new Produto();  
    model.addAttribute("produto", prod);
    return "verProdutos";
} 



@PostMapping("/novo-prod")
public String novoProd(@ModelAttribute Produto prod) {
    
      Serv.criarProduto(prod);
     
     
    
    if (prod.getId() != null){
        for(Produto f : Serv.getTodosProd()){
            if(f.getId()==prod.getId()){
               
                       prod.setCor(f.getCor());
        prod.setCustoun(f.getCustoun());
        prod.setLogotipo(f.getLogotipo());
        prod.setMaterial(f.getMaterial());
        prod.setNome(f.getNome());
                
                
              break;
            }
            
        }
    }else{
        prod.setId(Serv.getTodosProd().size()+1);
        Serv.criarProduto(prod);
        
    }
      
      
        return "redirect:/produtos";
    
    
}

@PostMapping("/att-prod")
public String attProd(Model model, @ModelAttribute Produto prod){
    
    int i = prod.getId();
    
    Serv.atualizarProduto(i, prod);
    
  
  
         return "redirect:/produtos";
    
    
 
    
}


   //clientes
 @GetMapping("/clientes")
public String mostraClientes(Model model){
   Cliente clie = new Cliente();  
    model.addAttribute("cliente", clie);
    return "verClientes";
} 



@PostMapping("/novo-clie")
public String novoProd(@ModelAttribute Cliente clie) {
    
      Serv.criarCliente(clie);
     
     
    
    if (clie.getId() != null){
        for(Cliente f : Serv.getTodosClie()){
            if(f.getId()==clie.getId()){
               
  clie.setEmail(f.getEmail());
  clie.setEndereco(f.getEndereco());
  clie.setNome(f.getNome());
  clie.setTelefone(f.getTelefone());
  
                
              break;
            }
            
        }
    }else{
        clie.setId(Serv.getTodosClie().size()+1);
        Serv.criarCliente(clie);
        
    }
      
      
        return "redirect:/clientes";
    
    
}

@PostMapping("/att-clie")
public String attClie(Model model, @ModelAttribute Cliente clie){
    
    int i = clie.getId();
    
    Serv.atualizarCliente(i, clie);
    
  
  
         return "redirect:/clientes";
    
    
 
    
}



//pedidos

@PostMapping("/novo-ped")
    public String novoPed(@ModelAttribute Pedidos ped) {
    
      
     
      
     
     int idProd = ped.getProduto().getId();
     int idClie = ped.getCliente().getId();
     
     
     
    
    if (ped.getId() != null){
        for(Pedidos f : Serv.getTodosPed()){
            if(f.getId()==ped.getId()){
               
  ped.setCliente(f.getCliente());
 ped.setData_entrega(f.getData_entrega());

 ped.setNpedido(f.getNpedido());
 ped.setProduto(f.getProduto());
 ped.setQtd(f.getQtd());
 ped.setStatus(f.getStatus());
 
 
                
              break;
            }
            
        }
    }else{
        ped.setId(Serv.getTodosPed().size()+1);
        Serv.criarPedido(idProd, idClie, ped);
        
    }
      
      
        return "redirect:/";
    
    
}

@PostMapping("/att-ped")
public String attClie(Model model, @ModelAttribute Pedidos ped){
    
    int i = ped.getId();
    
    Serv.atualizarPedido(i, ped);
    
  
  
         return "redirect:/";
    
    
}




}
