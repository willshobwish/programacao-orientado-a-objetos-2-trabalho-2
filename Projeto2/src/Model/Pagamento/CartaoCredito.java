package Model.Pagamento;

import java.io.Serializable;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class CartaoCredito extends Pagamento implements Serializable {

    private String nome;
    private String bandeira;
    private String numero;

    public CartaoCredito(String nome, String bandeira, String numero, int codigoNota) {
        super(codigoNota);
        this.nome = nome;
        this.bandeira = bandeira;
        this.numero = numero;
    }

    public String toString() {
        return """
                Código da nota: %d
                Nome: %s
                Bandeira: %s
                Número %s
                """.formatted(codigoNota, nome, bandeira, numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == "Credito") {
            this.nome = nome;
        }
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
