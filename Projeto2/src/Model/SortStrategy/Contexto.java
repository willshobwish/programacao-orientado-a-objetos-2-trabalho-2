package Model.SortStrategy;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Contexto {

    private OrdenacaoStrategy ordenacao;

    public void selecionarEstrategia(String metodo) {
        switch (metodo) {
            case "":

                break;
            default:
                throw new AssertionError();
        }
    }
}
