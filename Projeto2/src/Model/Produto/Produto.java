package Model.Produto;

import Model.Fabricante.Fabricante;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public abstract class Produto implements Serializable {

    protected int codigo;
    protected String nome;
    protected String descricao;
    protected LocalDate dataFabricacao;
    protected double valor;
    protected Fabricante fabricante;
    protected boolean disponivel;

    public Produto(int codigo, String nome, String descricao, LocalDate dataFabricacao, double valor,
            Fabricante fabricante, boolean disponivel) {

        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.valor = valor;
        this.fabricante = fabricante;
        this.disponivel = disponivel;
    }

    public abstract double calcularValor();

    public String toString() {
        return """
                Codigo: %s
                Nome: %s
                Descrição: %s
                Data de fabricação: %s
                Valor: R$ %.2f
                Fabricante: %s
                Disponivel: %b
                """.formatted(codigo, nome, descricao,
                dataFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString(), valor, fabricante,
                disponivel);
    }

    public boolean estaDisponivel() {
        return this.estaDisponivel();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public boolean isDisponiel() {
        return disponivel;
    }

    public void setDisponiel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int produtosVendidosFabricantes(Fabricante fabricante) {
        int cont = 0;
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();
        Iterator vendas = Model.Comercio.ComercioEletronico.getVendas().iterator();
        ArrayList<Produto> produtosVendidos = new ArrayList<>();

        while (produtos.hasNext()) {
            Produto p = (Produto) produtos.next();
            if (p.getFabricante().equals(fabricante)) {
                cont++;
            }
        }
        return cont;
    }

    public float valorTotalFabricante(Fabricante fabricante) {
        float valor = 0;
        Iterator produtos = Model.Comercio.ComercioEletronico.getProdutos().iterator();
        while (produtos.hasNext()) {
            Produto p = (Produto) produtos.next();
            if (p.getFabricante().equals(fabricante)) {
                valor += p.getValor();
            }
        }
        return valor;
    }
}
