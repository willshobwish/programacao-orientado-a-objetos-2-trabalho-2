package Model.SortStrategy;

import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Contexto {

    private OrdenacaoStrategy ordenacao;

    public ArrayList executarEstrategia(ArrayList VetorOrdenar) {
        return ordenacao.executarOrdenacao(VetorOrdenar);
    }

    public void selecionarEstrategia(String metodo) {
        switch (metodo) {
            case "quick sort":
                ordenacao = new StrategyOrdenacaoA();
                break;
            case "merge sort":
                ordenacao = new StrategyOrdenacaoB();
                break;
            default:
                throw new AssertionError();
        }
    }
}
