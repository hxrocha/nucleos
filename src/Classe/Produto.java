/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import classesBase.SwingColumn;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author hugo
 */
public class Produto {
    @SwingColumn(description="Código",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int codigoDoProduto;
    @SwingColumn(description="Nome do Produto",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String nomeDoProduto;
    @SwingColumn(description="Preço",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private double precoDoProduto;
    @SwingColumn(description="Quantidade",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int quantidadeDeProdutos;
    @SwingColumn(description="Código de Barras",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String codigoDeBarraDoProduto;
    public Produto() {
        this.codigoDoProduto = 0;
    }

    public int getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public void setCodigoDoProduto(int codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public double getPrecoDoProduto() {
        return precoDoProduto;
    }

    public void setPrecoDoProduto(double precoDoProduto) {
        this.precoDoProduto = precoDoProduto;
    }

    public int getQuantidadeDeProdutos() {
        return quantidadeDeProdutos;
    }

    public void setQuantidadeDeProdutos(int quantidadeDeProdutos) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
    }

    public String getCodigoDeBarraDoProduto() {
        return codigoDeBarraDoProduto;
    }

    public void setCodigoDeBarraDoProduto(String codigoBarraDoProduto) {
        this.codigoDeBarraDoProduto = codigoBarraDoProduto;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigoDoProduto=" + codigoDoProduto + ", nomeDoProduto=" + nomeDoProduto + ", precoDoProduto=" + precoDoProduto + ", quantidadeDeProdutos=" + quantidadeDeProdutos + ", codigoDeBarraDoProduto=" + codigoDeBarraDoProduto + '}';
    }
}
