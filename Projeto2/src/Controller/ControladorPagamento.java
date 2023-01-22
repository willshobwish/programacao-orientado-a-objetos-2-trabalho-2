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

    public static Dinheiro cadastrarPagamentoDinheiro(int codigoNota) {
        return new Dinheiro(codigoNota);
    }

    public static CartaoCredito cadastrarPagamentoCartao(String nome, String bandeira, String numero, int codigoNota) {
        return new CartaoCredito(nome, bandeira, numero, codigoNota);
    }

    public static Pix cadastrarPagamentoPix(String codigoPix, int codigoNota) {
        return new Pix(codigoPix, codigoNota);
    }
}
