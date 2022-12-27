/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Willian Murayama
 */
public class Gerente extends Usuario implements Serializable {

    protected float salario;
    protected String pis;
    protected Calendar dataAdmissao;

    public Gerente(float salario, String pis, Calendar dataAdmissao, int codigo, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String cep, String email) {
        super(codigo, nome, cpf, rg, dataNascimento, endereco, cep, email);
        this.salario = salario;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
    }

    public String toString() {
        return super.toString() + """
               Salario: %.2f
               PIS: %s
               Data de admissao: %s
               """.formatted(salario, pis, dataAdmissao.toString());
    }

}
