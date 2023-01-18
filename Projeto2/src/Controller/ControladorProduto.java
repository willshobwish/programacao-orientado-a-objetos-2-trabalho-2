package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Fabricante.Fabricante;
import static Model.Produto.FactoryProduto.factoryProduto;
import java.time.LocalDate;

public class ControladorProduto {

    public ControladorProduto() {

    }

    public static int getCodigoProduto() {
        return ComercioEletronico.getProdutos().size();
    }

    public static void cadastrarProduto(String tipoDeProduto, int codigo, String nome, String descricao, LocalDate dataFabricacao, double valor, Fabricante fabricante, boolean disponivel) {
        ComercioEletronico.cadastrarProduto(factoryProduto(tipoDeProduto, codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel));
    }
}
