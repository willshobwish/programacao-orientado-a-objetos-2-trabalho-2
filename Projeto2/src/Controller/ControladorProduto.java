package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Fabricante.Fabricante;
import Model.Produto.Eletrodomesticos;
import Model.Produto.Eletronicos;
import Model.Produto.Moveis;
import Model.Produto.Produto;
import Model.Produto.Vestuario;

import static Model.Produto.FactoryProduto.factoryProduto;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Iterator;

public class ControladorProduto {

    public ControladorProduto() {

    }

    public static int getCodigoProduto() {
        return ComercioEletronico.getProdutos().size();
    }

    public static void cadastrarProduto(String tipoDeProduto, int codigo, String nome, String descricao,
            LocalDate dataFabricacao, double valor, Fabricante fabricante, boolean disponivel) {
        ComercioEletronico.cadastrarProduto(
                factoryProduto(tipoDeProduto, codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel));
    }

    public static ArrayList<Moveis> getMoveis() {
        ArrayList<Moveis> moveis = new ArrayList<Moveis>();
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();

        while (produtos.hasNext()) {
            Produto produto = (Produto) produtos.next();
            if (produto instanceof Moveis) {
                moveis.add((Moveis) produto);
            }
        }
        return moveis;
    }

    public static ArrayList<Eletronicos> getEletronicos() {
        ArrayList<Eletronicos> eletronicos = new ArrayList<Eletronicos>();
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();

        while (produtos.hasNext()) {
            Produto produto = (Produto) produtos.next();
            if (produto instanceof Eletronicos) {
                eletronicos.add((Eletronicos) produto);
            }
        }
        return eletronicos;
    }

    public static ArrayList<Eletrodomesticos> getEletrodomesticos() {
        ArrayList<Eletrodomesticos> eletrodomesticos = new ArrayList<Eletrodomesticos>();

        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();

        while (produtos.hasNext()) {
            Produto produto = (Produto) produtos.next();
            if (produto instanceof Eletrodomesticos) {
                eletrodomesticos.add((Eletrodomesticos) produto);
            }
        }

        return eletrodomesticos;
    }

    public static ArrayList<Vestuario> getVestuario() {
        ArrayList<Vestuario> vestuario = new ArrayList<Vestuario>();
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();

        while (produtos.hasNext()) {
            Produto produto = (Produto) produtos.next();
            if (produto instanceof Vestuario) {
                vestuario.add((Vestuario) produto);
            }
        }
        return vestuario;
    }
}
