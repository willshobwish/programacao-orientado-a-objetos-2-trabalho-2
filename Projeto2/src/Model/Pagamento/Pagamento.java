package Model.Pagamento;

import java.io.Serializable;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public abstract class Pagamento implements Serializable {

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
