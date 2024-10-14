
package pi;


public class produto {
    private int id;
        private String nome;
    private Double custo_un;
     private String descricao;

    public produto(String nome) {
        this.nome = nome;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCusto_un() {
        return custo_un;
    }

    public void setCusto_un(Double custo_un) {
        this.custo_un = custo_un;
    }

    public produto(String nome, Double custo_un) {
        this.nome = nome;
        this.custo_un = custo_un;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
