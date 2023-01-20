package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Usuario.Cliente;
import Model.Usuario.ClienteNormal;
import Model.Usuario.ClienteOuro;
import Model.Usuario.Gerente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorUsuario {

    public static int getCodigoCliente() {
        return Model.Comercio.ComercioEletronico.getClientes().size();
    }

    public static int codigoGerente() {
        return Model.Comercio.ComercioEletronico.getGerentes().size();
    }

    public static void cadastrarClienteNormal(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        Model.Comercio.ComercioEletronico.cadastrarClienteNormal(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

    public static void cadastrarClienteOuro(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        Model.Comercio.ComercioEletronico.cadastrarClienteOuro(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

    public static void cadastrarGerente(float salario, String pis, LocalDate dataAdmissao, int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email) {
        Model.Comercio.ComercioEletronico.cadastrarGerente(salario, pis, dataAdmissao, codigo, nome, cpf, rg, dataNascimento, endereco, cep, email);
    }

    public static String getInfoTodosGerentes() {
        String info = "";
        Iterator gerentes = iteratorTodosGerentes();
        while (gerentes.hasNext()) {
            info += ((Gerente) gerentes.next()).toString() + '\n';
        }
        return info;
    }

    public static String getInfoTodosClientesNormal() {
        String info = "";
        Iterator clientes = iteratorTodosClientes();
        while (clientes.hasNext()) {
            Object clienteObjeto = clientes.next();
            if (clienteObjeto instanceof ClienteNormal) {
                info += ((ClienteNormal) clienteObjeto).toString() + '\n';
            }
        }
        return info;
    }

    public static String getInfoTodosClientesOuro() {
        String info = "";
        Iterator clientes = iteratorTodosClientes();
        while (clientes.hasNext()) {
            Object clienteObjeto = clientes.next();
            if (clienteObjeto instanceof ClienteOuro) {
                info += ((ClienteOuro) clienteObjeto).toString() + '\n';
            }
        }
        return info;
    }

    public static String[] getGerentesNomesArray() {
        Iterator gerentes = Model.Comercio.ComercioEletronico.getGerentes().iterator();
        ArrayList<String> nomesGerentes = new ArrayList<>();
        while (gerentes.hasNext()) {
            nomesGerentes.add(((Gerente) gerentes.next()).getNome());
        }
        return nomesGerentes.toArray(new String[0]);
    }

    public static String[] getClientesNomesArray() {
        Iterator clientes = Model.Comercio.ComercioEletronico.getClientes().iterator();
        ArrayList<String> nomesClientes = new ArrayList<>();
        while (clientes.hasNext()) {
            nomesClientes.add(((Cliente) clientes.next()).getNome());
        }
        return nomesClientes.toArray(new String[0]);
    }

    public static boolean isOuro(String nome) {
        Iterator clientes = Model.Comercio.ComercioEletronico.getClientes().iterator();
        while (clientes.hasNext()) {
            Cliente cliente = (Cliente) clientes.next();
            System.out.println(cliente.getNome());
            if (cliente.getNome().equals(nome)) {
                if (cliente instanceof ClienteOuro) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String buscarInfoClienteNome(String nome) {
        Iterator clientes = iteratorTodosClientes();
        while (clientes.hasNext()) {
            Cliente cliente = (Cliente) clientes.next();
            System.out.println(cliente.getNome());
            if (cliente.getNome().equals(nome)) {
                return cliente.toString();
            }
        }
        return "Informções do cliente não encontrado";
    }

    public static String buscarInfoGerenteNome(String nome) {
        Iterator gerentes = iteratorTodosGerentes();
        while (gerentes.hasNext()) {
            Gerente gerente = (Gerente) gerentes.next();
            if (gerente.getNome().equals(nome)) {
                return gerente.toString();
            }
        }
        return "Informções do gerente não encontrado";
    }

    public static Iterator<Cliente> iteratorTodosClientes() {
        return Model.Comercio.ComercioEletronico.getClientes().iterator();
    }

    public static Iterator<Gerente> iteratorTodosGerentes() {
        return ComercioEletronico.getGerentes().iterator();
    }
}
