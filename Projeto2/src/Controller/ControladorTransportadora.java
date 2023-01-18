package Controller;

import java.util.ArrayList;
import java.util.Iterator;

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

    public static ArrayList<Transportadora> topTransportadoras() {

        Transportadora transportadora1 = new Transportadora();
        Transportadora transportadora2 = new Transportadora();
        Transportadora transportadora3 = new Transportadora();
        ArrayList<Transportadora> topTransportadoras = new ArrayList<Transportadora>();

        Iterator transportadorasCadastradas = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();

        while (vendas.hasNext()) {
            Venda venda = (Venda) vendas.next();
            Transportadora transportadora = (Transportadora) transportadorasCadastradas.next();

            if (venda.vendasTransportadoras(transportadora) > venda.vendasTransportadoras(transportadora1)) {
                transportadora3 = transportadora2;
                transportadora2 = transportadora1;
                transportadora1 = transportadora;
            } else if (venda.vendasTransportadoras(transportadora) > venda.vendasTransportadoras(transportadora2)) {
                transportadora3 = transportadora2;
                transportadora2 = transportadora;
            } else if (venda.vendasTransportadoras(transportadora) > venda.vendasTransportadoras(transportadora3)) {
                transportadora3 = transportadora;
            }
        }

        topTransportadoras.add(transportadora1);
        topTransportadoras.add(transportadora2);
        topTransportadoras.add(transportadora3);

        return topTransportadoras;
    }
}
