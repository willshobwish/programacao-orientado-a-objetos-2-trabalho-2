package Model.Pagamento;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public abstract class Pagamento {

    protected int codigoNota;

    public Pagamento(int codigoNota) {
        this.codigoNota = codigoNota;
    }

    public abstract String toString();

    public int getCodigoNota() {
        return codigoNota;
    }

    public void setCodigoNota(int codigoNota) {
        this.codigoNota = codigoNota;
    }

}
