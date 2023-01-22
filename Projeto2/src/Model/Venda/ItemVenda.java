package Model.Venda;

import Model.Produto.Produto;
import java.io.Serializable;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ItemVenda implements Serializable {

    private Produto produto;
    private double valor;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.valor = produto.calcularValor();
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        return valor * quantidade;
    }

    public String toString() {
        return """
               Produto:
               %s
               Valor: R$ %.2f
               Quantidade: %d""".formatted(produto.toString(), valor, quantidade);
    }
}
