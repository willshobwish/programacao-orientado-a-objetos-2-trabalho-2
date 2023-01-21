/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Usuario;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Willian Murayama
 */
public class ClienteNormal extends Cliente implements Serializable {

    public ClienteNormal(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        super(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

}
