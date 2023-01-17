package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Transportadora.Transportadora;

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

    public static ArrayList<Transportadora> listarTransportadorasComMaiorTransportesRealizado() {

        Transportadora Transportadora1 = new Transportadora();
        Transportadora Transportadora2 = new Transportadora();
        Transportadora Transportadora3 = new Transportadora();
        ArrayList<Transportadora> topTransportadoras = new ArrayList<Transportadora>();

        Iterator transportadorasCadastradas = Model.Comercio.ComercioEletronico.getTransportadoras().iterator();

        while (transportadorasCadastradas.hasNext()) {
            Transportadora transportadora = (Transportadora) transportadorasCadastradas.next();
            if (transportadora.getQtdTransportes() > Transportadora1.getQtdTransportes()) {
                Transportadora3 = Transportadora2;
                Transportadora2 = Transportadora1;
                Transportadora1 = transportadora;
            } else if (transportadora.getQtdTransportes() > Transportadora2.getQtdTransportes()) {
                Transportadora3 = Transportadora2;
                Transportadora2 = transportadora;
            } else if (transportadora.getQtdTransportes() > Transportadora3.getQtdTransportes()) {
                Transportadora3 = transportadora;
            }
        }

        topTransportadoras.add(Transportadora1);
        topTransportadoras.add(Transportadora2);
        topTransportadoras.add(Transportadora3);

        return topTransportadoras;
    }
}
