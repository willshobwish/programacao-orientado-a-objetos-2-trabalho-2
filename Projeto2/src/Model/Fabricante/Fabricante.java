package Model.Fabricante;

import java.io.Serializable;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Fabricante implements Serializable {

    private int codigo;
    private String cnpj;
    private String nome;
    private String descricao;
    private String email;
    private String telefone;
    private String endereco;

    public Fabricante(int codigo, String cnpj, String nome, String descricao, String email, String telefone, String endereco) {
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String toString() {
        return """
               Código: %d
               Nome: %s
               CNPJ: %s
               Descrição: %s
               E-mail: %s
               Telefone: %s
               Endereço: %s""".formatted(codigo, nome, cnpj, descricao, email, telefone, endereco);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
