/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Usuario.Cliente;
import java.time.LocalDate;
import java.util.Iterator;

/**
 *
 * @author Willian Murayama
 */
public class ControladorUsuario {

    public static void cadastrarCliente(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        Comercio.ComercioEletronico.cadastrarCliente(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

    public static void cadastrarClienteOuro(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        Comercio.ComercioEletronico.cadastrarClienteOuro(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

    public static Iterator<Cliente> iteratorTodosClientes() {
        return Comercio.ComercioEletronico.getClientes().iterator();
    }

    public static int codigoCliente() {
        return Comercio.ComercioEletronico.getClientes().size();
    }
}
