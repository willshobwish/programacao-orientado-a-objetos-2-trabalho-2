package Model.SortStrategy;

import Model.Produto.Produto;
import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class InsertionSort implements SortStrategy {

    public ArrayList<Produto> executarOrdenacao(ArrayList<Produto> VetorOrdenar) {
        int tamanhoVetor = VetorOrdenar.size();
        for (int i = 0; i < tamanhoVetor - 1; i++) {
            int indexMinimo = i;
            for (int j = i + 1; j < tamanhoVetor; j++) {
                if (VetorOrdenar.get(j).getValor() < VetorOrdenar.get(indexMinimo).getValor()) {
                    indexMinimo = j;
                }
            }
            Produto temp = VetorOrdenar.get(indexMinimo);
            VetorOrdenar.remove(indexMinimo);
            VetorOrdenar.add(indexMinimo, VetorOrdenar.get(i));
            VetorOrdenar.remove(i);
            VetorOrdenar.add(i, temp);
        }
        return VetorOrdenar;
    }
}
