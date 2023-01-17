package Model.Produto;

import Model.Fabricante.Fabricante;
import java.time.LocalDate;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class FactoryProduto {

    public FactoryProduto() {

    }

    public static Produto factoryProduto(String tipoDeProduto, int codigo, String nome, String descricao, LocalDate dataFabricacao, double valor, Fabricante fabricante, boolean disponivel) {
        switch (tipoDeProduto) {
            case "eletrodomestico":
                return new Eletrodomesticos(codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel);

            case "eletronico":
                return new Eletronicos(codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel);

            case "movel":
                return new Moveis(codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel);

            case "vestuario":
                return new Vestuario(codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel);

            default:
                throw new AssertionError();
        }
    }
}
