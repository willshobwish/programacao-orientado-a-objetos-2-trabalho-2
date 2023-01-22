package Model.Comercio;

import Model.Fabricante.Fabricante;
import Model.Pagamento.Pagamento;
import static Model.Produto.FactoryProduto.factoryProduto;
import Model.Produto.Produto;
import Model.Transportadora.Transportadora;
import Model.Usuario.Cliente;
import Model.Usuario.ClienteNormal;
import Model.Usuario.ClienteOuro;
import Model.Usuario.Gerente;
import Model.Venda.ItemVenda;
import Model.Venda.Venda;
import java.time.LocalDate;
import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ComercioEletronico {

    private static ArrayList<Venda> vendas = Controller.ControladorSerializable.carregarVendas();
    private static ArrayList<Produto> produtos = Controller.ControladorSerializable.carregarProdutos();
    private static ArrayList<Fabricante> fabricantes = Controller.ControladorSerializable.carregarFabricantes();
    private static ArrayList<Transportadora> transportadoras = Controller.ControladorSerializable
            .carregarTransportadoras();
    private static ArrayList<Cliente> clientes = Controller.ControladorSerializable.carregarClientes();
    private static ArrayList<Gerente> gerentes = Controller.ControladorSerializable.carregarGerentes();

    public ComercioEletronico() {
    }

    public static void cadastrarClienteNormal(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento,
            String endereco, String cep, String email, LocalDate dataCadastro) {
        Cliente clienteCadastro = new ClienteNormal(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email,
                dataCadastro);
        clientes.add(clienteCadastro);
        Controller.ControladorSerializable.salvarClientes(clientes);
    }

    public static void cadastrarClienteOuro(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento,
            String endereco, String cep, String email, LocalDate dataCadastro) {
        ClienteOuro clienteCadastro = new ClienteOuro(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email,
                dataCadastro);
        clientes.add(clienteCadastro);
        Controller.ControladorSerializable.salvarClientes(clientes);
    }

    public static void cadastrarGerente(float salario, String pis, LocalDate dataAdmissao, int codigo, String nome,
            String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email) {
        Gerente gerenteCadastro = new Gerente(salario, pis, dataAdmissao, codigo, nome, cpf, rg, dataNascimento,
                endereco, cep, email);
        gerentes.add(gerenteCadastro);
        Controller.ControladorSerializable.salvarGerentes(gerentes);
    }

    public static void cadastrarProduto(String tipoDeProduto, int codigo, String nome, String descricao,
            LocalDate dataFabricacao, double valor, String nomeFabricante, boolean disponivel) {
        produtos.add(factoryProduto(tipoDeProduto, codigo, nome, descricao, dataFabricacao, valor,
                Controller.ControladorFabricante.getFabricanteString(nomeFabricante), disponivel));
        Controller.ControladorSerializable.salvarProdutos(produtos);
    }

    public static void cadastrarTransportadora(int codigo, String cnpj, String nome, String email, String telefone,
            String endereco, int tempoDeEntrega) {
        transportadoras.add(new Transportadora(codigo, cnpj, nome, email, telefone, endereco, tempoDeEntrega));
        Controller.ControladorSerializable.salvarTransportadoras(transportadoras);

    }

    public void cadastrarVenda(int codigo, String nomeCliente, String nomeGerente, LocalDate dataVenda, LocalDate dataDaEntrega, ArrayList<ItemVenda> itensVenda, double valorTotal, double valorComDesconto, Pagamento formaPagamento, String nomeTransportadora) {
        Cliente cliente = Controller.ControladorUsuario.getClienteNome(nomeCliente);
        Gerente gerente = Controller.ControladorUsuario.getGerenteNome(nomeGerente);
        Transportadora transportadora = Controller.ControladorTransportadora.getTransportadoraNome(nomeTransportadora);
        Venda venda = new Venda(codigo, cliente, gerente, dataVenda, dataDaEntrega, itensVenda, valorTotal, valorComDesconto, formaPagamento, transportadora);
        System.out.println(venda.toString());
        vendas.add(venda);

        Controller.ControladorSerializable.salvarVendas(vendas);
    }

    public static void cadastrarFabricante(int codigo, String cnpj, String nome, String descricao, String email,
            String telefone, String endereco) {
        fabricantes.add(new Fabricante(codigo, cnpj, nome, descricao, email, telefone, endereco));
        Controller.ControladorSerializable.salvarFabricantes(fabricantes);
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

    // public static ArrayList<ClienteOuro> getClientesOuro() {
    // return clientesOuro;
    // }
    public static ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

}
