package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Fabricante.Fabricante;
import Model.Produto.Eletrodomesticos;
import Model.Produto.Eletronicos;
import static Model.Produto.FactoryProduto.factoryProduto;
import Model.Produto.Moveis;
import Model.Produto.Produto;
import Model.Produto.Vestuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class ControladorProduto {

    public ControladorProduto() {

    }

    public static int getCodigoProduto() {
        return ComercioEletronico.getProdutos().size();
    }

    public static Produto getProdutoString(String nome) {
        Iterator produtos = ComercioEletronico.getProdutos().iterator();
        while (produtos.hasNext()) {
            Produto produtoTemp = (Produto) produtos.next();
            if (produtoTemp.getNome().equals(nome)) {
                return produtoTemp;
            }
        }
        return null;
    }

    public static double getValorProdutoNome(String nome) {
        Iterator produtos = ComercioEletronico.getProdutos().iterator();
        while (produtos.hasNext()) {
            Produto produtoTemp = (Produto) produtos.next();
            if (produtoTemp.getNome().equals(nome)) {
                return produtoTemp.getValor();
            }
        }
        return 0;
    }

    public static void cadastrarProduto(String tipoDeProduto, int codigo, String nome, String descricao,
            LocalDate dataFabricacao, double valor, Fabricante fabricante, boolean disponivel) {
        ComercioEletronico.cadastrarProduto(
                factoryProduto(tipoDeProduto, codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel));
    }

    public static void cadastrarItemVenda(int codigoProduto, float valor, int quantidade) {

    }

    public static String[] getProdutosNomesArray() {
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();
        ArrayList<String> nomesProdutos = new ArrayList<>();
        while (produtos.hasNext()) {
            nomesProdutos.add(((Produto) produtos.next()).getNome());
        }
        return nomesProdutos.toArray(new String[0]);
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

    public static String getInfoMoveis() {
        String info = "";
        Iterator moveisIterator = getMoveis().iterator();
        while (moveisIterator.hasNext()) {
            info += moveisIterator.next().toString();
            info += "\n";
        }
        return info;
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

    public static String getInfoEletronicos() {
        String info = "";
        Iterator eletronicosIterator = getEletronicos().iterator();
        while (eletronicosIterator.hasNext()) {
            info += eletronicosIterator.next().toString();
            info += "\n";
        }
        return info;
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

    public static String getInfoEletrodomesticos() {
        String info = "";
        Iterator eletrodomesticosIterator = getEletrodomesticos().iterator();
        while (eletrodomesticosIterator.hasNext()) {
            info += eletrodomesticosIterator.next().toString();
            info += "\n";
        }
        return info;
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

    public static String getInfoVestuario() {
        String info = "";
        Iterator vestuariosInfo = getVestuario().iterator();
        while (vestuariosInfo.hasNext()) {
            info += vestuariosInfo.next().toString();
            info += "\n";
        }
        return info;
    }

    public static String getInfoProdutos() {
        String info = "";
        Iterator produtosInfo = ComercioEletronico.getProdutos().iterator();
        while (produtosInfo.hasNext()) {
            info += produtosInfo.next().toString();
            info += "\n";
        }
        return info;
    }
}
