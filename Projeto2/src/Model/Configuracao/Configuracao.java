package Model.Configuracao;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Configuracao {

    final static private String arquivoVendas = "src\\Arquivos\\arquivoVendas.ser";
    final static private String arquivoProdutos = "src\\Arquivos\\arquivoProdutos.ser";
    final static private String arquivoFabricantes = "src\\Arquivos\\arquivoFabricantes.ser";
    final static private String arquivoTransportadoras = "src\\Arquivos\\arquivoTransportadoras.ser";
    final static private String arquivoClientes = "src\\Arquivos\\arquivoClientes.ser";
    final static private String arquivoClientesOuro = "src\\Arquivos\\arquivoClientesOuro.ser";
    final static private String arquivoGerentes = "src\\Arquivos\\arquivoGerentes.ser";

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

    public static String getArquivoClientesOuro() {
        return arquivoClientesOuro;
    }

    public static String getArquivoGerentes() {
        return arquivoGerentes;
    }

}
