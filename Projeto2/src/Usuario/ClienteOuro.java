/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.time.LocalDate;

/**
 *
 * @author Willian Murayama
 */
public class ClienteOuro extends Cliente {

    public ClienteOuro(LocalDate dataCadastro, int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email) {
        super(dataCadastro, codigo, nome, cpf, rg, dataNascimento, endereco, cep, email);
    }

}
