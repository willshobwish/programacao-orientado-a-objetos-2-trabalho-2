package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Transportadora.Transportadora;
import Model.Venda.Venda;
import java.time.LocalDate;
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
public class ControladorTransportadora {

    public void cadastrarTransportadora(int codigo, String cnpj, String nome, String email, String telefone,
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

    public String topTransportadoras() {
        Iterator transportadoras = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
        HashMap<Transportadora, Integer> mapa = new HashMap<>();
        String info = "";
        while (transportadoras.hasNext()) {
            int contagem = 0;
            Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
            Transportadora transportadora = (Transportadora) transportadoras.next();
            while (vendas.hasNext()) {
                Venda venda = (Venda) vendas.next();
                if (venda.getTransportadora().getNome().equals(transportadora.getNome())) {
                    contagem++;
                }
            }
            mapa.put(transportadora, contagem);
        }
        Map<Transportadora, Integer> topTransportadorasMap = mapa.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<Transportadora, Integer> entry : topTransportadorasMap.entrySet()) {
            info += entry.getKey().toString() + "Quantidade de transporte: " + entry.getValue().toString() + "\n\n";
        }
        return info;
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
