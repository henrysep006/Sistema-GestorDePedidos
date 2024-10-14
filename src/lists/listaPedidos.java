/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

import java.util.ArrayList;
import java.util.List;
import pi.pedidos;


public class listaPedidos {
    private static final List<pedidos> lista = new ArrayList<>();

    public static List<pedidos> listar() {
        return lista;
    }

     public static void Add(pedidos regist) {
          lista.add(regist);
      }
    public static pedidos getId(int id){
        
        return lista.get(id);
    }
    
    
    
    
    
    
}
