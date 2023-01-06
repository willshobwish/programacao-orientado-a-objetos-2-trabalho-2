package Model.Usuario;

import java.time.LocalDate;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ClienteOuro extends Cliente {

    public ClienteOuro(int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email, LocalDate dataCadastro) {
        super(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email, dataCadastro);
    }

    public String toString() {
        return super.toString()
                + """
                Cliente: ouro
                """;
    }
}
