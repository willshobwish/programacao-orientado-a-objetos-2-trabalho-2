package Model.SortStrategy;

import Model.Produto.Produto;
import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class StrategyOrdenacaoA implements OrdenacaoStrategy {

    public ArrayList<Produto> executarOrdenacao(ArrayList<Produto> VetorOrdenar) {
        for (int i = 1; i < VetorOrdenar.size() - 1; i++) {
            Produto temporario = VetorOrdenar.get(i);
            int j = i - 1;
            while (j >= 0 && temporario.getValor() <= VetorOrdenar.get(i).getValor()) {
                VetorOrdenar.add(i + 1, VetorOrdenar.get(i));
                i = i - 1;
            }
            VetorOrdenar.add(i + 1, temporario);
        }
        return VetorOrdenar;
    }
}
