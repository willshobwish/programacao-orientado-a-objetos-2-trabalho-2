package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Pagamento.Pagamento;
import Model.Produto.Produto;
import Model.Usuario.Cliente;
import Model.Venda.ItemVenda;
import Model.Venda.Venda;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorVendas {

    private static ArrayList<ItemVenda> itensVenda;

    public ControladorVendas() {
        itensVenda = new ArrayList<ItemVenda>();
    }

    public static void cadastrarVenda(int codigo, String nomeCliente, String nomeGerente, LocalDate dataVenda, LocalDate dataDaEntrega, double valorTotal, double valorComDesconto, Pagamento formaPagamento, String nomeTransportadora) {
        ComercioEletronico comercio = new ComercioEletronico();
        comercio.cadastrarVenda(codigo, nomeCliente, nomeGerente, dataVenda, dataDaEntrega, itensVenda, valorTotal, valorComDesconto, formaPagamento, nomeTransportadora);
        itensVenda = new ArrayList<ItemVenda>();
    }

    public void cadastrarItemVenda(Produto produto, int quantidade) {
        itensVenda.add(new ItemVenda(produto, quantidade));
    }

    public double calcularValorTotal() {
        Iterator itensVendaIterator = itensVenda.iterator();
        double valor = 0;
        while (itensVendaIterator.hasNext()) {
            ItemVenda itemVenda = (ItemVenda) itensVendaIterator.next();
            valor += itemVenda.getQuantidade() * itemVenda.getValor();
        }
        return valor;
    }

    public double calcularValorTotalDesconto(String nome) {
        if (ControladorUsuario.isOuro(nome)) {
            return calcularValorTotal() * 0.97;
        } else {
            return calcularValorTotal();
        }
    }

    public static String getInfoVendas() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String info = "";
        while (vendas.hasNext()) {
            info += ((Venda) vendas.next()).toString() + "-------------------------------------------------------------------------------\n";
        }
        return info;
    }

    public static int getCodigoVenda() {
        return ComercioEletronico.getVendas().size();
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

    public String getVendasMes(LocalDate mes) {
        String info = "";
        double lucro = 0;
        Iterator vendas = iteratorVendas();
        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (venda.getDataVenda().getMonthValue() == mes.getMonthValue()) {
                info += venda.toString() + "\n";
                lucro += venda.getValorComDesconto();
            }
        }
        return """
               %sLucro total do mês: R$ %.2f
               """.formatted(info, lucro);
    }

    public static String listarVendasDinheiro() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasDinheiro = "";

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (Venda.getFormaPagamento(venda) == "Dinheiro") {
                vendasDinheiro += venda.toString() + "\n";
            }
        }
        return vendasDinheiro;
    }

    public static String listarVendasCredito() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasCredito = "";

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (Venda.getFormaPagamento(venda) == "Credito") {
                vendasCredito += venda.toString() + "\n";
            }
        }
        return vendasCredito;
    }

    public static String listarVendasPix() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        String vendasPix = "";

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            if (Venda.getFormaPagamento(venda) == "Pix") {
                vendasPix += venda.toString() + "\n";
            }
        }
        return vendasPix;
    }

    public Iterator iteratorVendas() {
        return ComercioEletronico.getVendas().iterator();
    }
}
