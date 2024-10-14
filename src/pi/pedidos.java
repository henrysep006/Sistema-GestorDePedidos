
package pi;

import java.util.ArrayList;
import java.util.List;



public class pedidos {
    
    private String status;
    private cliente cliente;
   private produto produto;
    private int n_pedido;
    private String data;
    private double orcamento;
    private int qtd;

    public pedidos(int n_pedido) {
        this.n_pedido = n_pedido;
    }

   
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public cliente getCliente() {
        return cliente;
    }
 public String getClienteNome() {
        return cliente.getNome();
    }
 
    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }
 public void setClienteNome(String cl) {
       cliente.setNome(cl);
    }

    public produto getProduto() {
        return produto;
    }
    public String getProdutoNome() {
        return produto.getNome();
    }
    public void setProduto(produto produto) {
        this.produto = produto;
    }
public void setProdutoNome(String pd) {
        produto.setNome(pd);
    }
    public int getN_pedido() {
        return n_pedido;
    }

    public void setN_pedido(int n_pedido) {
        this.n_pedido = n_pedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
public double orcamento(){
    
    this.orcamento= this.qtd*this.produto.getCusto_un();
    return orcamento;
}
    
    public pedidos(String status, cliente cliente,produto produto, int n_pedido, String data, int qtd) {
        
        this.status = status;
       this.cliente=cliente;
   this.produto=produto;
        this.n_pedido = n_pedido;
        this.data = data;
    
        this.qtd = qtd;
    }

  

   
    
    
    
    
    
}
