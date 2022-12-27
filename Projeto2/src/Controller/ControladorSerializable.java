/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Fabricante.Fabricante;
import Produto.Produto;
import Transportadora.Transportadora;
import Usuario.Cliente;
import Usuario.Gerente;
import Venda.Venda;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class ControladorSerializable {

    private static boolean ativar = false;

    public static void ativarRegistro() {
        ativar = true;
    }

    private static boolean statusAtivacao() {
        if (ativar) {
            System.out.println("Salvamento de arquivos ativado");
            return true;
        } else {
            System.out.println("Salvamento de arquivos desativado");
            return false;
        }
    }

    public static void salvarVendas(ArrayList<Venda> Vendas) {
        if (statusAtivacao()) {
            try {
                FileOutputStream arquivoStream = new FileOutputStream(Configuracao.Configuracao.getArquivoVendas());
                ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
                arquivoObjeto.writeObject(Vendas);
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void salvarProdutos(ArrayList<Produto> Produtos) {
        if (statusAtivacao()) {
            try {
                FileOutputStream arquivoStream = new FileOutputStream(Configuracao.Configuracao.getArquivoProdutos());
                ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
                arquivoObjeto.writeObject(Produtos);
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void salvarFabricantes(ArrayList<Fabricante> Fabricantes) {
        if (statusAtivacao()) {
            try {
                FileOutputStream arquivoStream = new FileOutputStream(Configuracao.Configuracao.getArquivoFabricantes());
                ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
                arquivoObjeto.writeObject(Fabricantes);
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void salvarTransportadoras(ArrayList<Transportadora> Transportadoras) {
        if (statusAtivacao()) {
            try {
                FileOutputStream arquivoStream = new FileOutputStream(Configuracao.Configuracao.getArquivoVendas());
                ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
                arquivoObjeto.writeObject(Transportadoras);
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void salvarClientes(ArrayList<Cliente> Clientes) {
        if (statusAtivacao()) {
            try {
                FileOutputStream arquivoStream = new FileOutputStream(Configuracao.Configuracao.getArquivoVendas());
                ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
                arquivoObjeto.writeObject(Clientes);
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void salvarGerentes(ArrayList<Gerente> Gerentes) {
        if (statusAtivacao()) {
            try {
                FileOutputStream arquivoStream = new FileOutputStream(Configuracao.Configuracao.getArquivoVendas());
                ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
                arquivoObjeto.writeObject(Gerentes);
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Venda> carregarVendas() {
        ArrayList<Venda> Venda = null;
        if (statusAtivacao()) {
            try {
                FileInputStream arquivoStream = new FileInputStream(Configuracao.Configuracao.getArquivoVendas());
                ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
                Venda = (ArrayList<Venda>) arquivoObjeto.readObject();
                if (Venda == null) {
                    Venda = new ArrayList<Venda>();
                }
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return Venda;
    }

    public static ArrayList<Produto> carregarProdutos() {
        ArrayList<Produto> Produto = null;
        if (statusAtivacao()) {
            try {
                FileInputStream arquivoStream = new FileInputStream(Configuracao.Configuracao.getArquivoProdutos());
                ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
                Produto = (ArrayList<Produto>) arquivoObjeto.readObject();
                if (Produto == null) {
                    Produto = new ArrayList<Produto>();
                }
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return Produto;
    }

    public static ArrayList<Fabricante> carregarFabricantes() {
        ArrayList<Fabricante> Fabricante = null;
        if (statusAtivacao()) {
            try {
                FileInputStream arquivoStream = new FileInputStream(Configuracao.Configuracao.getArquivoFabricantes());
                ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
                Fabricante = (ArrayList<Fabricante>) arquivoObjeto.readObject();
                if (Fabricante == null) {
                    Fabricante = new ArrayList<Fabricante>();
                }
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return Fabricante;
    }

    public static ArrayList<Transportadora> carregarTransportadoras() {
        ArrayList<Transportadora> Transportadora = null;
        if (statusAtivacao()) {
            try {
                FileInputStream arquivoStream = new FileInputStream(Configuracao.Configuracao.getArquivoTransportadoras());
                ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
                Transportadora = (ArrayList<Transportadora>) arquivoObjeto.readObject();
                if (Transportadora == null) {
                    Transportadora = new ArrayList<Transportadora>();
                }
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return Transportadora;
    }

    public static ArrayList<Cliente> carregarClientes() {
        ArrayList<Cliente> Cliente = null;
        if (statusAtivacao()) {
            try {
                FileInputStream arquivoStream = new FileInputStream(Configuracao.Configuracao.getArquivoClientes());
                ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
                Cliente = (ArrayList<Cliente>) arquivoObjeto.readObject();
                if (Cliente == null) {
                    Cliente = new ArrayList<Cliente>();
                }
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return Cliente;
    }

    public static ArrayList<Gerente> carregarGerentes() {
        ArrayList<Gerente> Gerente = null;
        if (statusAtivacao()) {
            try {
                FileInputStream arquivoStream = new FileInputStream(Configuracao.Configuracao.getArquivoGerentes());
                ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
                Gerente = (ArrayList<Gerente>) arquivoObjeto.readObject();
                if (Gerente == null) {
                    Gerente = new ArrayList<Gerente>();
                }
                arquivoObjeto.close();
                arquivoStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return Gerente;
    }

}