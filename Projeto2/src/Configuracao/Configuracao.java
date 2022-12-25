/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracao;

/**
 *
 * @author Willian Murayama
 */
public class Configuracao {

    final static private String arquivoVendas = "src\\Arquivos\\arquivoVendas.ser";
    final static private String arquivoProdutos= "src\\Arquivos\\arquivoProdutos.ser";
    final static private String arquivoFabricantes= "src\\Arquivos\\arquivoFabricantes.ser";
    final static private String arquivoTransportadoras= "src\\Arquivos\\arquivoTransportadoras.ser";
    final static private String arquivoClientes= "src\\Arquivos\\arquivoClientes.ser";
    final static private String arquivoGerentes= "src\\Arquivos\\arquivoGerentes.ser";

    public static String getArquivoVendas() {
        return arquivoVendas;
    }

    public static String getArquivoProdutos() {
        return arquivoProdutos;
    }

    public static String getArquivoFabricantes() {
        return arquivoFabricantes;
    }

    public static String getArquivoTransportadoras() {
        return arquivoTransportadoras;
    }

    public static String getArquivoClientes() {
        return arquivoClientes;
    }

    public static String getArquivoGerentes() {
        return arquivoGerentes;
    }

}
