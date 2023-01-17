package Controller;

import Model.Fabricante.Fabricante;
import java.time.LocalDate;
import Model.Comercio.ComercioEletronico;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
import static Model.Produto.FactoryProduto.factoryProduto;

public class ControladorProduto {

    public ControladorProduto() {

    }

    public void fabricarProduto(String tipoDeProduto, int codigo, String nome, String descricao, LocalDate dataFabricacao, float valor, Fabricante fabricante, boolean disponivel) {
        ComercioEletronico.cadastrarProduto(factoryProduto(tipoDeProduto, codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel));
    }
}
