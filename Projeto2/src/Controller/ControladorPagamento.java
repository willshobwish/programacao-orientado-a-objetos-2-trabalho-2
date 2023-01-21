package Controller;

import Model.Pagamento.CartaoCredito;
import Model.Pagamento.Dinheiro;
import Model.Pagamento.Pix;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorPagamento {

    public Dinheiro cadastrarPagamentoDinheiro(int codigoNota) {
        return new Dinheiro(codigoNota);
    }

    public CartaoCredito cadastrarPagamentoCartao(String nome, String bandeira, String numero, int codigoNota) {
        return new CartaoCredito(nome, bandeira, numero, codigoNota);
    }

    public Pix cadastrarPagamentoPix(String codigoPix, int codigoNota) {
        return new Pix(codigoPix, codigoNota);
    }
}
