/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Venda;

import java.io.Serializable;

/**
 *
 * @author Willian Murayama
 */
public class Venda implements Serializable {

    private String nometeste;

    public Venda(String nometeste) {
        this.nometeste = nometeste;
    }

    public String getVenda() {
        return this.nometeste;
    }
}