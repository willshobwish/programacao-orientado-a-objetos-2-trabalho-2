package Controller;

import Model.Fabricante.Fabricante;
import Model.Produto.Produto;
import Model.Transportadora.Transportadora;
import Model.Usuario.Cliente;
import Model.Usuario.ClienteOuro;
import Model.Usuario.Gerente;
import Model.Venda.Venda;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class ControladorSerializable {

    public static void salvarVendas(ArrayList<Venda> Vendas) {
        try {
            FileOutputStream arquivoStream = new FileOutputStream(Model.Configuracao.Configuracao.getArquivoVendas());
            ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
            arquivoObjeto.writeObject(Vendas);
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarProdutos(ArrayList<Produto> Produtos) {
        try {
            FileOutputStream arquivoStream = new FileOutputStream(Model.Configuracao.Configuracao.getArquivoProdutos());
            ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
            arquivoObjeto.writeObject(Produtos);
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarFabricantes(ArrayList<Fabricante> Fabricantes) {
        try {
            FileOutputStream arquivoStream = new FileOutputStream(Model.Configuracao.Configuracao.getArquivoFabricantes());
            ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
            arquivoObjeto.writeObject(Fabricantes);
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarTransportadoras(ArrayList<Transportadora> Transportadoras) {
        try {
            FileOutputStream arquivoStream = new FileOutputStream(Model.Configuracao.Configuracao.getArquivoTransportadoras());
            ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
            arquivoObjeto.writeObject(Transportadoras);
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarClientes(ArrayList<Cliente> Clientes) {
        try {
            FileOutputStream arquivoStream = new FileOutputStream(Model.Configuracao.Configuracao.getArquivoClientes());
            ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
            arquivoObjeto.writeObject(Clientes);
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarClientesOuro(ArrayList<ClienteOuro> ClientesOuro) {
        try {
            FileOutputStream arquivoStream = new FileOutputStream(Model.Configuracao.Configuracao.getArquivoClientesOuro());
            ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
            arquivoObjeto.writeObject(ClientesOuro);
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarGerentes(ArrayList<Gerente> Gerentes) {
        try {
            FileOutputStream arquivoStream = new FileOutputStream(Model.Configuracao.Configuracao.getArquivoGerentes());
            ObjectOutputStream arquivoObjeto = new ObjectOutputStream(arquivoStream);
            arquivoObjeto.writeObject(Gerentes);
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Venda> carregarVendas() {
        ArrayList<Venda> Venda = new ArrayList<>();
        try {
            FileInputStream arquivoStream = new FileInputStream(Model.Configuracao.Configuracao.getArquivoVendas());
            ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
            Venda = (ArrayList<Venda>) arquivoObjeto.readObject();
            if (Venda == null) {
                Venda = new ArrayList<Venda>();
            } else {
                System.out.println("Vendas carregados com sucesso");
            }
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Venda;
    }

    public static ArrayList<Produto> carregarProdutos() {
        ArrayList<Produto> Produto = new ArrayList<>();
        try {
            FileInputStream arquivoStream = new FileInputStream(Model.Configuracao.Configuracao.getArquivoProdutos());
            ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
            Produto = (ArrayList<Produto>) arquivoObjeto.readObject();
            if (Produto == null) {
                Produto = new ArrayList<Produto>();
            } else {
                System.out.println("Produtos carregados com sucesso");
            }
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Produto;
    }

    public static ArrayList<Fabricante> carregarFabricantes() {
        ArrayList<Fabricante> Fabricante = new ArrayList<>();
        try {
            FileInputStream arquivoStream = new FileInputStream(Model.Configuracao.Configuracao.getArquivoFabricantes());
            ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
            Fabricante = (ArrayList<Fabricante>) arquivoObjeto.readObject();
            if (Fabricante == null) {
                Fabricante = new ArrayList<Fabricante>();
            } else {
                System.out.println("Fabricantes carregados com sucesso");
            }
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Fabricante;
    }

    public static ArrayList<Transportadora> carregarTransportadoras() {
        ArrayList<Transportadora> Transportadora = new ArrayList<>();
        try {
            FileInputStream arquivoStream = new FileInputStream(Model.Configuracao.Configuracao.getArquivoTransportadoras());
            ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
            Transportadora = (ArrayList<Transportadora>) arquivoObjeto.readObject();
            if (Transportadora == null) {
                Transportadora = new ArrayList<Transportadora>();
            } else {
                System.out.println("Transportadoras carregados com sucesso");
            }
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Transportadora;
    }

    public static ArrayList<Cliente> carregarClientes() {
        ArrayList<Cliente> Cliente = new ArrayList<>();
        try {
            FileInputStream arquivoStream = new FileInputStream(Model.Configuracao.Configuracao.getArquivoClientes());
            ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
            Cliente = (ArrayList<Cliente>) arquivoObjeto.readObject();
            if (Cliente == null) {
                Cliente = new ArrayList<>();
            } else {
                System.out.println("Clientes carregados com sucesso");
            }
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Cliente;
    }

    public static ArrayList<ClienteOuro> carregarClientesOuro() {
        ArrayList<ClienteOuro> ClienteOuro = new ArrayList<>();
        try {
            FileInputStream arquivoStream = new FileInputStream(Model.Configuracao.Configuracao.getArquivoClientesOuro());
            ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
            ClienteOuro = (ArrayList<ClienteOuro>) arquivoObjeto.readObject();
            if (ClienteOuro == null) {
                ClienteOuro = new ArrayList<>();
            } else {
                System.out.println("Clientes ouro carregados com sucesso");
            }
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ClienteOuro;
    }

    public static ArrayList<Gerente> carregarGerentes() {
        ArrayList<Gerente> Gerente = new ArrayList<>();
        try {
            FileInputStream arquivoStream = new FileInputStream(Model.Configuracao.Configuracao.getArquivoGerentes());
            ObjectInputStream arquivoObjeto = new ObjectInputStream(arquivoStream);
            Gerente = (ArrayList<Gerente>) arquivoObjeto.readObject();
            if (Gerente == null) {
                Gerente = new ArrayList<Gerente>();
            } else {
                System.out.println("Gerentes carregados com sucesso");
            }
            arquivoObjeto.close();
            arquivoStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Gerente;
    }

}
