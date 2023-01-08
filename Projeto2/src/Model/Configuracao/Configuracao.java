package Model.Configuracao;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class Configuracao {

    final static private String diretorio = "src\\Arquivos\\";
    final static private String arquivoVendas = diretorio + "arquivoVendas.ser";
    final static private String arquivoProdutos = diretorio + "arquivoProdutos.ser";
    final static private String arquivoFabricantes = diretorio + "arquivoFabricantes.ser";
    final static private String arquivoTransportadoras = diretorio + "arquivoTransportadoras.ser";
    final static private String arquivoClientes = diretorio + "arquivoClientes.ser";
    final static private String arquivoClientesOuro = diretorio + "arquivoClientesOuro.ser";
    final static private String arquivoGerentes = diretorio + "arquivoGerentes.ser";

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
