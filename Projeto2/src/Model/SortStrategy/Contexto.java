package Model.SortStrategy;

import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Contexto {

    private SortStrategy ordenacao;

    public ArrayList executarEstrategia(ArrayList VetorOrdenar) {
        return ordenacao.executarOrdenacao(VetorOrdenar);
    }

    public void selecionarEstrategia(String metodo) {
        switch (metodo) {
            case "insertion":
                ordenacao = new InsertionSort();
                break;
            case "selection":
                ordenacao = new SelectionSort();
                break;
            default:
                throw new AssertionError();
        }
    }
}
