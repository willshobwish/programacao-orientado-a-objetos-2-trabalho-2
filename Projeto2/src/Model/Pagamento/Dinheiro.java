package Model.Pagamento;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Dinheiro extends Pagamento {

    private String nome;

    public Dinheiro(int codigoNota) {
        super(codigoNota);
    }

    public String toString() {
        return """
                Código da nota: %d
                """.formatted(codigoNota);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == "Dinheiro") {
            this.nome = nome;
        }
    }

}
