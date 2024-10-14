/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

import java.util.ArrayList;
import java.util.List;
import pi.cliente;


public class listaClientes {
    
    private static final List<cliente> lista = new ArrayList<>();

    public static List<cliente> listar() {
        return lista;
    }

     public static void Add(cliente regist) {
          lista.add(regist);
      }
    public static cliente getId(int id){
        
        return lista.get(id);
    }
    
    
    
    
    
    
    
    
    
    
    
}
