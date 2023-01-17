package Model.Venda;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ItemVenda {
    private int coddigoProduto;
    private float valor;
    private int quantidade;

    public void cadastrarItemVenda(int coddigoProduto, float valor, int quantidade) {
        this.coddigoProduto = coddigoProduto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getCoddigoProduto() {
        return coddigoProduto;
    }

    public void setCoddigoProduto(int coddigoProduto) {
        this.coddigoProduto = coddigoProduto;
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
