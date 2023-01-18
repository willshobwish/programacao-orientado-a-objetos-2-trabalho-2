package Model.Pagamento;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Pix extends Pagamento {

    private String codigoPix;
    private String nome;

    public Pix(int codigoNota) {
        super(codigoNota);
    }

    public Pix(String codigoPix, int codigoNota) {
        super(codigoNota);
        this.codigoPix = codigoPix;
    }

    public String toString() {
        return """
                Código da nota: %d
                Código do PIX: %s
                """.formatted(codigoNota, codigoPix);
    }

    public String getCodigoPix() {
        return codigoPix;
    }

    public void setCodigoPix(String codigoPix) {
        this.codigoPix = codigoPix;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == "Pix") {
            this.nome = nome;
        }
    }

}
