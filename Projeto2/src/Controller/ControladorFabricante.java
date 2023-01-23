package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Fabricante.Fabricante;
import Model.Venda.ItemVenda;
import Model.Venda.Venda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public int getCodigoFabricante() {
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

    public String topValorFabricanteProduto() {
        Iterator fabricantes = Model.Comercio.ComercioEletronico.getFabricantes().iterator();
        HashMap<Fabricante, Double> mapa = new HashMap<>();
        String info = "";
        while (fabricantes.hasNext()) {
            double contagem = 0;
            Fabricante fabricante = (Fabricante) fabricantes.next();
            Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
            while (vendas.hasNext()) {
                Venda venda = (Venda) vendas.next();
                Iterator itensVenda = venda.getItensVenda().iterator();
                while (itensVenda.hasNext()) {
                    ItemVenda produtoIteracao = (ItemVenda) itensVenda.next();
                    if (fabricante.getNome().equals(produtoIteracao.getProduto().getFabricante().getNome())) {
                        contagem += produtoIteracao.getQuantidade() * produtoIteracao.getValor();
                    }
                }
            }
            mapa.put(fabricante, contagem);
        }
        Map<Fabricante, Double> topFabricantesMap = mapa.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<Fabricante, Double> entry : topFabricantesMap.entrySet()) {
            info += entry.getKey().toString() + "\n" + "Valor total em vendas de produtos: R$ " + String.format("%.2f", entry.getValue()) + "\n\n";
        }
        return info;
    }

    public String topFabricantes() {
        Iterator fabricantes = Model.Comercio.ComercioEletronico.getFabricantes().iterator();
        HashMap<Fabricante, Integer> mapa = new HashMap<>();
        String info = "";
        while (fabricantes.hasNext()) {
            int contagem = 0;
            Fabricante fabricante = (Fabricante) fabricantes.next();
            Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
            while (vendas.hasNext()) {
                Venda venda = (Venda) vendas.next();
                Iterator itensVenda = venda.getItensVenda().iterator();
                while (itensVenda.hasNext()) {
                    ItemVenda produtoIteracao = (ItemVenda) itensVenda.next();
                    if (fabricante.getNome().equals(produtoIteracao.getProduto().getFabricante().getNome())) {
                        contagem += produtoIteracao.getQuantidade();
                    }
                }
            }
            mapa.put(fabricante, contagem);
        }
        Map<Fabricante, Integer> topFabricantesMap = mapa.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<Fabricante, Integer> entry : topFabricantesMap.entrySet()) {
            info += entry.getKey().toString() + "\n" + "Quantidade de vendas de produto: " + entry.getValue().toString() + "\n\n";
        }
        return info;
    }

}
