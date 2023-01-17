package Model.Produto;

import Model.Fabricante.Fabricante;
import java.io.Serializable;
import java.time.LocalDate;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Eletrodomesticos extends Produto implements Serializable {

    public Eletrodomesticos(int codigo, String nome, String descricao, LocalDate dataFabricacao, double valor, Fabricante fabricante, boolean disponivel) {
        super(codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel);
    }

    public double calcularValor() {
        return (valor * 1.035);
    }

}
