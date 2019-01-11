/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author hugo
 */
public class ItensDoPedido {
    private int codigoDoItenDoPedido;
    private int codigoDoPedido;
    private int codigoDoProduto;
    private double valorUnitarioDoProduto;
    private int quantidadeDeProdutos;

    public ItensDoPedido() {
    }

    public int getCodigoDoItenDoPedido() {
        return codigoDoItenDoPedido;
    }

    public void setCodigoDoItenDoPedido(int codigoDoItenDoPedido) {
        this.codigoDoItenDoPedido = codigoDoItenDoPedido;
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
        return "ItensDoPedido{" + "codigoDoItenDoPedido=" + codigoDoItenDoPedido + ", codigoDoPedido=" + codigoDoPedido + ", codigoDoProduto=" + codigoDoProduto + ", valorUnitarioDoProduto=" + valorUnitarioDoProduto + ", quantidadeDeProdutos=" + quantidadeDeProdutos + '}';
    }

    
}
