/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Comercio.ComercioEletronico;
import Model.Usuario.Cliente;
import Model.Usuario.ClienteOuro;
import Model.Usuario.Gerente;
import java.time.LocalDate;
import java.util.Iterator;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorUsuario {

    public static void cadastrarCliente(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        Model.Comercio.ComercioEletronico.cadastrarCliente(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

    public static void cadastrarClienteOuro(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        Model.Comercio.ComercioEletronico.cadastrarClienteOuro(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

    public static Iterator<Cliente> iteratorTodosClientes() {
        return Model.Comercio.ComercioEletronico.getClientes().iterator();
    }

    public static int codigoCliente() {
        return Model.Comercio.ComercioEletronico.getClientes().size();
    }

    public static Cliente buscarClienteNome(String nome) {
        Iterator clientes = iteratorTodosClientes();
        while (clientes.hasNext()) {
            Cliente cliente = (Cliente) clientes.next();
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public static Iterator<ClienteOuro> iteratorTodosClienteOuro() {
        return Model.Comercio.ComercioEletronico.getClientesOuro().iterator();
    }

    public static void cadastrarGerente(float salario, String pis, LocalDate dataAdmissao, int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email) {
        Model.Comercio.ComercioEletronico.cadastrarGerente(salario, pis, dataAdmissao, codigo, nome, cpf, rg, dataNascimento, endereco, cep, email);
    }

    public static int codigoGerente() {
        return Model.Comercio.ComercioEletronico.getGerentes().size();
    }

    public static Iterator<Gerente> iteratorTodosGerentes() {
        return ComercioEletronico.getGerentes().iterator();
    }

    public static Gerente buscarGerenteNome(String nome) {
        Iterator gerentes = iteratorTodosGerentes();
        while (gerentes.hasNext()) {
            Gerente gerente = (Gerente) gerentes.next();
            if (gerente.getNome().equals(nome)) {
                return gerente;
            }
        }
        return null;
    }
}
