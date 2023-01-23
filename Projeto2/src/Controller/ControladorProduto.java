package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Produto.Eletrodomesticos;
import Model.Produto.Eletronicos;
import Model.Produto.Moveis;
import Model.Produto.Produto;
import Model.Produto.Vestuario;
import Model.Venda.ItemVenda;
import Model.Venda.Venda;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    public String getInfoTopProdutos() {
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();
        HashMap<Produto, Integer> mapa = new HashMap<>();
        String info = "";
        while (produtos.hasNext()) {
            int contagem = 0;
            Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
            Produto produto = (Produto) produtos.next();
            while (vendas.hasNext()) {
                Venda venda = (Venda) vendas.next();
                Iterator itensVenda = venda.getItensVenda().iterator();
                while (itensVenda.hasNext()) {
                    ItemVenda produtoIteracao = (ItemVenda) itensVenda.next();
                    if (produto.getNome().equals(produtoIteracao.getProduto().getNome())) {
                        contagem += produtoIteracao.getQuantidade();
                    }
                }
            }
            mapa.put(produto, contagem);
        }
//        Cria um outro Hashmap com os valores ordenados de forma decrescente 
        Map<Produto, Integer> topProdutosMap = mapa.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<Produto, Integer> entry : topProdutosMap.entrySet()) {
            info += entry.getKey().toString() + "Quantidade de vendas de produto: " + entry.getValue().toString() + "\n\n";
        }
        return info;
    }

    public static void cadastrarProduto(String tipoDeProduto, int codigo, String nome, String descricao,
            LocalDate dataFabricacao, double valor, String nomeFabricante, boolean disponivel) {
        ComercioEletronico.cadastrarProduto(tipoDeProduto, codigo, nome, descricao, dataFabricacao, valor,
                nomeFabricante, disponivel);
    }

    public static String[] getProdutosNomesArray() {
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();
        ArrayList<String> nomesProdutos = new ArrayList<>();
        while (produtos.hasNext()) {
            Produto produtoTemp = (Produto) produtos.next();
            if (produtoTemp.isDisponiel()) {
                nomesProdutos.add(produtoTemp.getNome());
            }
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

    public static ArrayList<Produto> getTopDezProdutos() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        ArrayList<Produto> produtosVendidos = new ArrayList<Produto>();

        Map<Produto, Integer> map = new TreeMap<>();
        ArrayList<Produto> result = new ArrayList<>();
        ArrayList<Produto> aux = new ArrayList<>();

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            Iterator itensVenda = venda.getItensVenda().iterator();
            while (itensVenda.hasNext()) {
                ItemVenda itemVenda = (ItemVenda) itensVenda.next();
                produtosVendidos.add(itemVenda.getProduto());
            }
        }

        int cont = 0;
        for (Produto produto : produtosVendidos) {
            map.put(produto, cont);
            cont++;
        }

        map = ordenarValor(map);
        map.forEach((k, v) -> aux.add(k));

        cont = 0;
        for (Produto p : aux) {
            result.add(p);
            cont++;
            if (cont == 10) {
                break;
            }
        }

        return result;
    }

    public static <Produto, Integer extends Comparable<Integer>> Map<Produto, Integer> ordenarValor(
            final Map<Produto, Integer> map) {

        Comparator<Produto> valueComparator = new Comparator<Produto>() {
            public int compare(Produto k1, Produto k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0) {
                    return 1;
                } else {
                    return compare;
                }
            }
        };

        Map<Produto, Integer> sortedByValues = new TreeMap<Produto, Integer>(valueComparator);
        sortedByValues.putAll(map);

        return sortedByValues;
    }
}
