/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

import java.util.ArrayList;
import java.util.List;
import pi.produto;


public class listaProdutos {
    
    private static final List<produto> lista = new ArrayList<>();

    public static List<produto> listar() {
        return lista;
    }

     public static void Add(produto regist) {
          lista.add(regist);
      }
    public static produto getId(int id){
        
        return lista.get(id);
    }
    
    
    
    
    
    
}
