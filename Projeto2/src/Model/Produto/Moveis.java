package Model.Produto;

import Model.Fabricante.Fabricante;
import java.time.LocalDate;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Moveis extends Produto {

    public Moveis(int codigo, String nome, String descricao, LocalDate dataFabricacao, float valor, Fabricante fabricante, boolean disponivel) {
        super(codigo, nome, descricao, dataFabricacao, valor, fabricante, disponivel);
    }
    
    public double calcularValor(){
        return (valor * 1.0075);
    }
}
