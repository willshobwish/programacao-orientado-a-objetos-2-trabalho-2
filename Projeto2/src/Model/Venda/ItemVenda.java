package Model.Venda;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ItemVenda {
    private int codigoProduto;
    private float valor;
    private int quantidade;

    public void cadastrarItemVenda(int codigoProduto, float valor, int quantidade) {
        this.codigoProduto = codigoProduto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getcodigoProduto() {
        return codigoProduto;
    }

    public void setcodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public float getValor() {
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

    public float calcularTotal() {
        return valor * quantidade;
    }
}
