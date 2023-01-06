package Model.Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Cliente extends Usuario implements Serializable {

    protected LocalDate dataCadastro;

    public Cliente(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        super(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email);
        this.dataCadastro = dataCadastro;
    }

    public String toString() {
        return super.toString() + """
                               Data do cadastro: %s
                               """.formatted(dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());

    }

}
