package Model.SortStrategy;

import Model.Produto.Produto;
import java.util.ArrayList;
import java.util.Iterator;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Contexto {

    private SortStrategy ordenacao;

    public ArrayList<Produto> executarEstrategia() {
        return ordenacao.executarOrdenacao(Model.Comercio.ComercioEletronico.getProdutos());
    }

    public void selecionarEstrategia(String metodo) {
        switch (metodo) {
            case "insertion":
                System.out.println("insertion selecionado");
                ordenacao = new InsertionSort();
                break;
            case "selection":
                ordenacao = new SelectionSort();
                break;
            default:
                throw new AssertionError();
        }
    }

    public String exibirOrdenacao() {
        String info = "";
        Iterator produtosOrdenados = executarEstrategia().iterator();
        while (produtosOrdenados.hasNext()) {
            info += produtosOrdenados.next().toString() + "\n";
        }
        return info;
    }
}
