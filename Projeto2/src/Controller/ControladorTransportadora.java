package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Transportadora.Transportadora;
import Model.Venda.Venda;
import java.time.LocalDate;
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
public class ControladorTransportadora {

    public static void cadastrarTransportadora(int codigo, String cnpj, String nome, String email, String telefone,
            String endereco, int tempoDeEntrega) {
        ComercioEletronico.cadastrarTransportadora(codigo, cnpj, nome, email, telefone, endereco, tempoDeEntrega);
    }

    public static int getCodigoTransportadora() {
        return Model.Comercio.ComercioEletronico.getTransportadoras().size();
    }

    public static String listarTransportadoras() {
        String transportadoras = Model.Comercio.ComercioEletronico.getTransportadoras().toString();
        return transportadoras;
    }

    public static Transportadora getTransportadoraNome(String nome) {
        Iterator transportadoras = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
        while (transportadoras.hasNext()) {
            Transportadora transportadora = (Transportadora) transportadoras.next();
            if (transportadora.getNome().equals(nome)) {
                return transportadora;
            }
        }
        return null;
    }

    public ArrayList<Model.Transportadora.Transportadora> topTransportadoras() {
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

    public <Transportadora, Integer extends Comparable<Integer>> Map<Transportadora, Integer> ordenarValor(
            final Map<Transportadora, Integer> map) {
        Comparator<Transportadora> valueComparator = new Comparator<Transportadora>() {
            public int compare(Transportadora k1, Transportadora k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0) {
                    return 1;
                } else {
                    return compare;
                }
            }
        };
        Map<Transportadora, Integer> sortedByValues = new TreeMap<Transportadora, Integer>(valueComparator);
        sortedByValues.putAll(map);

        return sortedByValues;
    }

    public static String[] getNomesTransportadoras() {
        Iterator transportadoras = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
        ArrayList<String> nomesTransportadoras = new ArrayList<>();
        while (transportadoras.hasNext()) {
            nomesTransportadoras.add(((Transportadora) transportadoras.next()).getNome());
        }
        return nomesTransportadoras.toArray(new String[0]);
    }

    public static String getInfoTodasTransportadoras() {
        Iterator transportadoras = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
        String info = "";
        while (transportadoras.hasNext()) {
            info += ((Transportadora) transportadoras.next()).toString() + '\n';
        }
        return info;
    }

    public String getInfoTopTransportadoras() {
        Iterator transportadoras = topTransportadoras().iterator();
        String info = "";
        while (transportadoras.hasNext()) {
            info += ((Transportadora) transportadoras.next()).toString() + '\n';
        }
        return info;
    }

    public static LocalDate getTempoEntrega(String nome) {
        Iterator transportadoras = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
        Transportadora transportadora = null;
        LocalDate agora = LocalDate.now();
        while (transportadoras.hasNext()) {
            Transportadora transportadoraTemp = (Transportadora) transportadoras.next();
            if (transportadoraTemp.getNome().equals(nome)) {
                transportadora = transportadoraTemp;
            }
        }
        return agora.plusDays(transportadora.getTempoDeEntrega());
    }
}
