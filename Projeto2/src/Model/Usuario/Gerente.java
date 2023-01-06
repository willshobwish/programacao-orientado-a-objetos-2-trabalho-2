package Model.Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Gerente extends Usuario implements Serializable {

    protected float salario;
    protected String pis;
    protected LocalDate dataAdmissao;

    public Gerente(float salario, String pis, LocalDate dataAdmissao, int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email) {
        super(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email);
        this.salario = salario;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
    }

    public String toString() {
        return super.toString() + """
               Salario: R$ %.2f
               PIS: %s
               Data de admissao: %s
               """.formatted(salario, pis, dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
    }

}
