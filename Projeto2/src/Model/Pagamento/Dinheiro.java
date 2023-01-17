package Model.Pagamento;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Dinheiro extends Pagamento {
    
    public Dinheiro(int codigoNota) {
        super(codigoNota);
    }
    
    public String toString() {
        return """
               Código da nota: %d
               """.formatted(codigoNota);
    }
}
