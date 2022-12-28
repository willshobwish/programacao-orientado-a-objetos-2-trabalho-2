package Testes;

import Usuario.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Willian Murayama
 */
public class GeraArquivos {

    public static void main(String[] args) {
//        ArrayList<Venda> vendas = new ArrayList<>();
//        ArrayList<Produto> produtos = new ArrayList<>();
//        ArrayList<Fabricante> fabricantes = new ArrayList<>();
//        ArrayList<Transportadora> transportadoras = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(0, "", "", "", LocalDate.now(), "", "", "", LocalDate.now()));
        //        ArrayList<Gerente> gerentes = new ArrayList<>();
        Controller.ControladorSerializable.salvarClientes(clientes);
//        Controller.ControladorSerializable.salvarFabricantes(fabricantes);
//        Controller.ControladorSerializable.salvarGerentes(gerentes);
//        Controller.ControladorSerializable.salvarProdutos(produtos);
//        Controller.ControladorSerializable.salvarTransportadoras(transportadoras);
//        Controller.ControladorSerializable.salvarVendas(vendas);

        clientes = Controller.ControladorSerializable.carregarClientes();

    }
}
