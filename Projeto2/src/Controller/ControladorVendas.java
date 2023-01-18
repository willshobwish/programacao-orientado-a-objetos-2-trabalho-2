package Controller;

import java.time.LocalDate;
import java.util.Iterator;

import Model.Pagamento.Pagamento;
import Model.Transportadora.Transportadora;
import Model.Usuario.Cliente;
import Model.Usuario.Gerente;
import Model.Venda.ItemVenda;
import Model.Venda.Venda;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorVendas {

    public static void cadastrarVenda(int codigo, Cliente cliente, Gerente gerente, LocalDate dataVenda,
            LocalDate dataDaEntrega, float valorTotal, float valorComDesconto,
            Pagamento formaPagamento, Transportadora transportadora) {

        Venda venda = new Venda();
        venda.cadastrarVenda(codigo, cliente, gerente, dataVenda, dataDaEntrega, valorTotal, valorComDesconto,
                formaPagamento, transportadora);
    }

    public static void cadastrarItemVenda(int codigoProduto, float valor, int quantidade) {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.cadastrarItemVenda(codigoProduto, valor, quantidade);
    }

    public static String listarVendas() {
        String vendas = Model.Comercio.ComercioEletronico.getVendas().toString();
        return vendas;
    }

    public static String listarVendasPorCliente(Cliente cliente) {
        Iterator vendasCliente = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendas = "";
        while (vendasCliente.hasNext()) {
            Venda venda = (Venda) vendasCliente.next();
            if (venda.getCliente().equals(cliente)) {
                vendas += venda.toString();
            }
        }
        return vendas;
    }

    public static String listarVendaDosMes(LocalDate mes) {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasMes = "";
        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (venda.getDataVenda().getMonthValue() == mes.getMonthValue()) {
                vendasMes += venda.toString();
            }
        }
        return vendasMes;
    }

    public static String getLucroDoMes(LocalDate mes) {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasMes = "";
        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (venda.getDataVenda().getMonthValue() == mes.getMonthValue()) {
                vendasMes += venda.calcularValorTotal();
            }
        }
        return vendasMes;
    }

    public static String listarVendasDinheiro() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasDinheiro = "";

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (venda.getFormaPagamento().equals("Dinheiro")) {
                vendasDinheiro += venda.toString();
            }
        }
        return vendasDinheiro;
    }

    public static String listarVendasCredito() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasCredito = "";

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (venda.getFormaPagamento().equals("Credito")) {
                vendasCredito += venda.toString();
            }
        }
        return vendasCredito;
    }

    public static String listarVendasPix() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasPix = "";

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (venda.getFormaPagamento().equals("Pix")) {
                vendasPix += venda.toString();
            }
        }
        return vendasPix;
    }
}
