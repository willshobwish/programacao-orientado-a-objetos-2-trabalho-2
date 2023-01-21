package Model.Venda;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Pagamento.Pagamento;
import Model.Transportadora.Transportadora;
import Model.Usuario.Cliente;
import Model.Usuario.Gerente;
import java.util.Iterator;
import Model.Venda.Venda;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Venda implements Serializable {
    private int codigo;
    private Cliente cliente;
    private Gerente gerente;
    private LocalDate dataVenda;
    private LocalDate dataDaEntrega;
    private ArrayList itensVenda = new ArrayList<ItemVenda>();
    private float valorTotal;
    private float valorComDesconto;
    private Pagamento formaPagamento;
    private Transportadora transportadora;

    public void cadastrarVenda(int codigo, Cliente cliente, Gerente gerente, LocalDate dataVenda,
            LocalDate dataDaEntrega, float valorTotal, float valorComDesconto,
            Pagamento formaPagamento, Transportadora transportadora) {

        this.codigo = codigo;
        this.cliente = cliente;
        this.gerente = gerente;
        this.dataVenda = dataVenda;
        this.dataDaEntrega = dataDaEntrega;
        this.valorTotal = valorTotal;
        this.valorComDesconto = valorComDesconto;
        this.formaPagamento = formaPagamento;
        this.transportadora = transportadora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(float valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }

    public Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Pagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public static String getFormaPagamento(Venda venda) {
        if (venda.getFormaPagamento() instanceof Model.Pagamento.Dinheiro) {

            return "Dinheiro";

        } else if (venda.getFormaPagamento() instanceof Model.Pagamento.CartaoCredito) {
            return "Credito";

        } else if (venda.getFormaPagamento() instanceof Model.Pagamento.Pix) {
            return "Pix";
        }
        return null;
    }

    public Transportadora getTransportadora() {
        return transportadora;

    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public ArrayList getItensVenda() {
        return itensVenda;
    }

    public void adicionarItemVenda(ItemVenda itemVenda) {
        this.itensVenda.add(itemVenda);
    }

    public float calcularValorTotal() {
        float valorTotal = 0;
        for (int i = 0; i < itensVenda.size(); i++) {
            valorTotal += ((ItemVenda) itensVenda.get(i)).calcularTotal();
        }
        return valorTotal;
    }

    public void calcularDataEntrega() {
        dataDaEntrega = dataVenda.plusDays(transportadora.getTempoDeEntrega());
    }

    public int vendasTransportadoras(Transportadora transportadora) {
        int cont = 0;
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (venda.getTransportadora().equals(transportadora)) {
                cont++;
            }
        }
        return cont;
    }
}
