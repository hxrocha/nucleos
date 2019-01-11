/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import classesBase.SwingColumn;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewItensDoPedido {
    @SwingColumn(description="Iten",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int codigoDosItensDoPedido;
    @SwingColumn(description="Cod Pedido.",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int codigoDoPedido;
    @SwingColumn(description="Cod prod",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int codigoDoProduto;
    @SwingColumn(description="Nome",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String nomeDoProduto;
    @SwingColumn(description="Vlr unit",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private double valorUnitarioDoProduto;
    @SwingColumn(description="Quantidade",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int quantidadeDeProdutos;

    public ViewItensDoPedido() {
    }

    public int getCodigoDosItensDoPedido() {
        return codigoDosItensDoPedido;
    }

    public void setCodigoDosItensDoPedido(int codigoDosItensDoPedido) {
        this.codigoDosItensDoPedido = codigoDosItensDoPedido;
    }

    public int getCodigoDoPedido() {
        return codigoDoPedido;
    }

    public void setCodigoDoPedido(int codigoDoPedido) {
        this.codigoDoPedido = codigoDoPedido;
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

    public double getValorUnitarioDoProduto() {
        return valorUnitarioDoProduto;
    }

    public void setValorUnitarioDoProduto(double valorUnitarioDoProduto) {
        this.valorUnitarioDoProduto = valorUnitarioDoProduto;
    }

    public int getQuantidadeDeProdutos() {
        return quantidadeDeProdutos;
    }

    public void setQuantidadeDeProdutos(int quantidadeDeProdutos) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
    }

    @Override
    public String toString() {
        return "ViewItensDoPedido{" + "codigoDosItensDoPedido=" + codigoDosItensDoPedido + ", codigoDoPedido=" + codigoDoPedido + ", codigoDoProduto=" + codigoDoProduto + ", nomeDoProduto=" + nomeDoProduto + ", valorUnitarioDoProduto=" + valorUnitarioDoProduto + ", quantidadeDeProdutos=" + quantidadeDeProdutos + '}';
    }

    
}
