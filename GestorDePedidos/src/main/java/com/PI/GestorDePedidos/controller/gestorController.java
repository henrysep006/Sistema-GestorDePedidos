/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI.GestorDePedidos.controller;
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
public String mostraPedidos(){
      
    return "verPedidos";
} 
 @GetMapping("/produtos")
public String mostraProdutos(Model model, @ModelAttribute Produto prod){
    
      
      model.addAttribute("produto", prod);
    return "verProdutos";
} 

 @GetMapping("/clientes")
public String mostraClientes(){
      
    return "verClientes";
} 

@PostMapping("/novo-filme")
public String novoProd(Model model, @ModelAttribute Produto prod){
    
    Serv.criarProduto(prod);
    
  
  
         return "redirect:/";
    
    
    
}    


}
