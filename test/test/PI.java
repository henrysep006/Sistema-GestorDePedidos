
package test;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import lists.listaClientes;
import lists.listaPedidos;
import lists.listaProdutos;
import pi.cliente;
import pi.pedidos;
import pi.produto;

public class PI {

  
    public static void main(String[] args) {
String a = null;
String wl="Valor valido";
List<pedidos> listapedidos = listaPedidos.listar();

List<produto> listaprodutos = listaProdutos.listar();

List<cliente> listaclientes = listaClientes.listar();


     do{
       try{
         wl="Valor valido";
         Scanner entrada = new Scanner(System.in);
        
         System.out.println("Cadastre um novo cliente. Insira nome, cnpj e telefone ");
         
         cliente cl1 = new cliente(entrada.nextLine(),entrada.nextLine(),entrada.nextLine());
         
         listaclientes.add(cl1);
         
         if(cl1.getCnpj().matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[/][0-9]{4}[-][0-9]{2}") && cl1.getTelefone().matches("[0-9]{0,11}")){
          System.out.println("Defina um novo produto. Insira nome e custo unitário");
          
          produto pr1=new produto(entrada.nextLine(),entrada.nextDouble());
        
        listaprodutos.add(pr1);
 
        
        System.out.println("Crie um novo pedido com o cliente e o produto já criados. Insira Status, número do pedido, data de entrega e quantidade");
        
        
        pedidos ped = new pedidos(entrada.next(),cl1, pr1, entrada.nextInt(),entrada.next(),entrada.nextInt());
        
              if(ped.getData().matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")){
        
    System.out.println("NOVO PEDIDO CRIADO:\nStatus: "+ped.getStatus()+"\nCliente: "+ped.getCliente().getNome()+"\nProduto: "
            +ped.getProduto().getNome()+"\nNumero do pedido: "+ped.getN_pedido()+ "\nData: " + ped.getData()+"\nOrçamento: "+
            ped.orcamento()+"\nQuantidade: "+ped.getQtd()+"\n\n");
      listapedidos.add(ped);
    
      
       System.out.println("Lista de pedidos: ");
    for(int i=0 ; i<listapedidos.size(); i++){
        
        pedidos p = listapedidos.get(i);
        
         System.out.println(
         "\n\nPedido n°: " + p.getN_pedido()
+ "\nStatus: "+ p.getStatus()+ "\nCliente: "+p.getClienteNome()+"\nProduto: "+p.getProdutoNome()+
                 "\nData: "+p.getData()+"\nOrçamento: "+p.getOrcamento()+"\nQuantidade: "+p.getQtd()
         
         +"\n\n"
         );
        
        
        
        
        
        
        
        
    }
    
     System.out.println("Para criar outro pedido, digite 1, caso queira encerrar, digite 2");
    int ab;
     ab = entrada.nextInt();
   
     do{
      
    if(ab==1){
        
        a="a";
    }else if(ab==2){
        
        a="b";
        
    }else{
        
         System.out.println("insira uma opção válida");
        wl="valor invalido";
    }}while(wl=="valor invalido");
    
    
    
    
    
              }else{
                   System.out.println("Insira os dados corretamente. Digite um valor válido para a data de entrega (DD/MM/AAAA)");
                   a="a";
              }
    
         }else{
              System.out.println("Insira os dados corretamente. Digite um valor válido para o CNPJ e telefone");
                 a="a";
                 
         }
       }catch(NumberFormatException exc ){
           
           
            System.out.println("Insira os dados corretamente. Este campo deve ser preenchido com números");
            a="a";
           
       }catch(InputMismatchException ex){
           
           System.out.println("Insira os dados corretamente. Este campo deve ser preenchido com números");
            a="a";
       }
         
         
         
         
        }while(a=="a");
        
        
    }
    
}
