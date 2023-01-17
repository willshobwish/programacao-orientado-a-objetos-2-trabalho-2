/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.SortStrategy;

import Model.Produto.Produto;
import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class SelectionSort implements SortStrategy {

    public ArrayList<Produto> executarOrdenacao(ArrayList<Produto> VetorOrdenar) {
        for (int i = 0; i < VetorOrdenar.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < VetorOrdenar.size(); j++) {
                if (VetorOrdenar.get(j).getValor() < VetorOrdenar.get(index).getValor()) {
//                    Procura o produto de menor valor
                    index = j;
                }
            }
            Produto menorValor = VetorOrdenar.get(index);
            VetorOrdenar.add(index, VetorOrdenar.get(i));
            VetorOrdenar.add(i, menorValor);
        }

        return VetorOrdenar;
    }
}
