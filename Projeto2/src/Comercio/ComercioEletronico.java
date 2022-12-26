/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comercio;

import Fabricante.Fabricante;
import Produto.Produto;
import Transportadora.Transportadora;
import Usuario.Cliente;
import Venda.Venda;
import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class ComercioEletronico {

    private ArrayList<Venda> Vendas = Controller.ControladorSerializable.carregarVendas();
    private ArrayList<Produto> Produtos = Controller.ControladorSerializable.carregarProdutos();
    private ArrayList<Fabricante> Fabricantes = Controller.ControladorSerializable.carregarFabricantes();
    private ArrayList<Transportadora> Transportadoras = Controller.ControladorSerializable.carregarTransportadoras();
    private ArrayList<Cliente> Clientes = Controller.ControladorSerializable.carregarClientes();

}
