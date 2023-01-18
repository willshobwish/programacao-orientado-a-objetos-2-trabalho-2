package Model.SortStrategy;

import Model.Produto.Produto;
import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public interface SortStrategy {

    public ArrayList<Produto> executarOrdenacao(ArrayList<Produto> VetorOrdenar);
}
