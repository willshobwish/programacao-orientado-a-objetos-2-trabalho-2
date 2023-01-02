/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comercio;

import Fabricante.Fabricante;
import Produto.Produto;
import Transportadora.Transportadora;
import Usuario.Cliente;
import Usuario.ClienteOuro;
import Usuario.Gerente;
import Venda.Venda;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class ComercioEletronico {

    private static ArrayList<Venda> vendas = Controller.ControladorSerializable.carregarVendas();
    private static ArrayList<Produto> produtos = Controller.ControladorSerializable.carregarProdutos();
    private static ArrayList<Fabricante> fabricantes = Controller.ControladorSerializable.carregarFabricantes();
    private static ArrayList<Transportadora> transportadoras = Controller.ControladorSerializable.carregarTransportadoras();
    private static ArrayList<Cliente> clientes = Controller.ControladorSerializable.carregarClientes();
    private static ArrayList<ClienteOuro> clientesOuro = Controller.ControladorSerializable.carregarClientesOuro();
    private static ArrayList<Gerente> gerentes = Controller.ControladorSerializable.carregarGerentes();

    public ComercioEletronico() {
    }

    public static void cadastrarCliente(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        Cliente clienteCadastro = new Cliente(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
        clientes.add(clienteCadastro);
        Controller.ControladorSerializable.salvarClientes(clientes);
    }

    public static void cadastrarClienteOuro(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        ClienteOuro clienteCadastro = new ClienteOuro(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
        clientesOuro.add(clienteCadastro);
        Controller.ControladorSerializable.salvarClientesOuro(clientesOuro);
    }

    public static void cadastrarGerente(float salario, String pis, LocalDate dataAdmissao, int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email) {
        Gerente gerenteCadastro = new Gerente(salario, pis, dataAdmissao, codigo, nome, cpf, rg, dataNascimento, endereco, cep, email);
        gerentes.add(gerenteCadastro);
        Controller.ControladorSerializable.salvarGerentes(gerentes);
    }

    public static ArrayList<Venda> getVendas() {
        return vendas;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public static ArrayList<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public static ArrayList<Transportadora> getTransportadoras() {
        return transportadoras;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<ClienteOuro> getClientesOuro() {
        return clientesOuro;
    }

    public static ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

}
