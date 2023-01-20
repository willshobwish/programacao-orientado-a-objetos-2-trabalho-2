package Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import Model.Transportadora.Transportadora;
import Model.Venda.Venda;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorTransportadora {
    public static void cadastrarTransportadora(int codigo, String cnpj, String nome, String email, String telefone,
            String endereco, int tempoDeEntrega) {
        Transportadora transportadora = new Transportadora();
        transportadora.cadastrarTransportadora(codigo, cnpj, nome, email, telefone, endereco, tempoDeEntrega);
    }

    public static String listarTransportadoras() {
        String transportadoras = Model.Comercio.ComercioEletronico.getTransportadoras().toString();
        return transportadoras;
    }

    public static ArrayList<Model.Transportadora.Transportadora> topTransportadoras() {
        Map<Transportadora, Integer> map = new TreeMap<>();
        ArrayList<Transportadora> result = new ArrayList<>();
        ArrayList<Transportadora> aux = new ArrayList<>();
        Iterator transportadorasCadastradas = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            Transportadora transportadora = (Transportadora) transportadorasCadastradas.next();
            map.put(transportadora, venda.vendasTransportadoras(transportadora));
        }

        map = ordenarValor(map);
        map.forEach((k, v) -> aux.add(k));
        int count = 0;

        for (Transportadora t : aux) {
            result.add(t);
            count++;
            if (count == 3) {
                break;
            }
        }

        return result;

    }

    public static <Transportadora, Integer extends Comparable<Integer>> Map<Transportadora, Integer> ordenarValor(
            final Map<Transportadora, Integer> map) {
        Comparator<Transportadora> valueComparator = new Comparator<Transportadora>() {
            public int compare(Transportadora k1, Transportadora k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };
        Map<Transportadora, Integer> sortedByValues = new TreeMap<Transportadora, Integer>(valueComparator);
        sortedByValues.putAll(map);

        return sortedByValues;
    }

    // public static ArrayList<Transportadora> topTransportadoras() {

    // Transportadora transportadora1 = new Transportadora();
    // Transportadora transportadora2 = new Transportadora();
    // Transportadora transportadora3 = new Transportadora();
    // ArrayList<Transportadora> topTransportadoras = new
    // ArrayList<Transportadora>();

    // Iterator transportadorasCadastradas =
    // Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
    // Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();

    // while (vendas.hasNext()) {
    // Venda venda = (Venda) vendas.next();
    // Transportadora transportadora = (Transportadora)
    // transportadorasCadastradas.next();

    // if (venda.vendasTransportadoras(transportadora) >
    // venda.vendasTransportadoras(transportadora1)) {
    // transportadora3 = transportadora2;
    // transportadora2 = transportadora1;
    // transportadora1 = transportadora;
    // } else if (venda.vendasTransportadoras(transportadora) >
    // venda.vendasTransportadoras(transportadora2)) {
    // transportadora3 = transportadora2;
    // transportadora2 = transportadora;
    // } else if (venda.vendasTransportadoras(transportadora) >
    // venda.vendasTransportadoras(transportadora3)) {
    // transportadora3 = transportadora;
    // }
    // }

    // topTransportadoras.add(transportadora1);
    // topTransportadoras.add(transportadora2);
    // topTransportadoras.add(transportadora3);

    // return topTransportadoras;
    // }
}
