package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Fabricante.Fabricante;
import Model.Produto.Produto;
import Model.Venda.ItemVenda;
import Model.Venda.Venda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorFabricante {

    public static void cadastrarFabricante(int codigo, String cnpj, String nome, String descricao, String email,
            String telefone, String endereco) {
        ComercioEletronico.cadastrarFabricante(codigo, cnpj, nome, descricao, email, telefone, endereco);
    }

    public static int getCodigoFabricante() {
        return ComercioEletronico.getFabricantes().size();
    }

    public static String getInfoFabricante() {
        Iterator fabricante = Model.Comercio.ComercioEletronico.getFabricantes().iterator();
        String info = "";
        while (fabricante.hasNext()) {
            info += ((Fabricante) fabricante.next()).toString() + "\n";
        }
        return info;
    }

    public static Fabricante getFabricanteString(String nome) {
        Iterator fabricantes = ComercioEletronico.getFabricantes().iterator();
        while (fabricantes.hasNext()) {
            Fabricante fabricanteTemp = (Fabricante) fabricantes.next();
            if (fabricanteTemp.getNome().equals(nome)) {
                return fabricanteTemp;
            }
        }
        return null;
    }

    public static String[] getFabricantesNomesArray() {
        Iterator fabricantes = Model.Comercio.ComercioEletronico.getFabricantes().iterator();
        ArrayList<String> nomesFabricante = new ArrayList<>();
        while (fabricantes.hasNext()) {
            nomesFabricante.add(((Fabricante) fabricantes.next()).getNome());
        }
        return nomesFabricante.toArray(new String[0]);
    }

    public static ArrayList<Model.Fabricante.Fabricante> listarTopFabricantes() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        ArrayList<Produto> produtosVendidos = new ArrayList<Produto>();
        Map<Fabricante, Integer> map = new TreeMap<>();
        ArrayList<Fabricante> result = new ArrayList<>();
        ArrayList<Fabricante> aux = new ArrayList<>();

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            Iterator itensVenda = venda.getItensVenda().iterator();
            while (itensVenda.hasNext()) {
                ItemVenda itemVenda = (ItemVenda) itensVenda.next();
                produtosVendidos.add(itemVenda.getProduto());
            }
        }

        int count = 0;

        for (Produto p : produtosVendidos) {
            map.put(p.getFabricante(), count);
            count++;
        }

        map = ordenarValor(map);
        map.forEach((k, v) -> aux.add(k));

        count = 0;
        for (Fabricante t : aux) {
            result.add(t);
            count++;
            if (count == 3) {
                break;
            }
        }

        return result;
    }

    public static ArrayList<Model.Fabricante.Fabricante> listarFabricantesMaiorLucro() {
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        ArrayList<Produto> produtosVendidos = new ArrayList<Produto>();
        Map<Fabricante, Double> map = new TreeMap<>();
        ArrayList<Fabricante> result = new ArrayList<>();
        ArrayList<Fabricante> aux = new ArrayList<>();

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            Iterator itensVenda = venda.getItensVenda().iterator();
            while (itensVenda.hasNext()) {
                ItemVenda itemVenda = (ItemVenda) itensVenda.next();
                produtosVendidos.add(itemVenda.getProduto());
            }
        }

        int count = 0;

        for (Produto p : produtosVendidos) {
            map.put(p.getFabricante(), p.getValor());
            count++;
        }

        map = ordenarValor(map);
        map.forEach((k, v) -> aux.add(k));

        count = 0;
        for (Fabricante t : aux) {
            result.add(t);
            count++;
            if (count == 3) {
                break;
            }
        }

        return result;
    }

    public static <Fabricante, Float extends Comparable<Float>> Map<Fabricante, Float> ordenarValor(
            final Map<Fabricante, Float> map) {

        Comparator<Fabricante> valueComparator = new Comparator<Fabricante>() {
            public int compare(Fabricante k1, Fabricante k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0) {
                    return 1;
                } else {
                    return compare;
                }
            }
        };
        Map<Fabricante, Float> sortedByValues = new TreeMap<Fabricante, Float>(valueComparator);
        sortedByValues.putAll(map);

        return sortedByValues;

    }
}
