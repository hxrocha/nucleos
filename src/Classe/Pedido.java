/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.Date;

/**
 *
 * @author hugo
 */
public class Pedido {
    private int codigoDoPedido;
    private String dataDoPedido;
    private int codigoDoCliente;
    private double valorTotalDoPedido;
    private boolean pedidoAberto;
    private int codigoDoCaixaVinculadoAoPedido;

    public Pedido() {
    }

    public int getCodigoDoPedido() {
        return codigoDoPedido;
    }

    public void setCodigoDoPedido(int codigoDoPedido) {
        this.codigoDoPedido = codigoDoPedido;
    }

    public String getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(String dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public int getCodigoDoCliente() {
        return codigoDoCliente;
    }

    public void setCodigoDoCliente(int codigoDoCliente) {
        this.codigoDoCliente = codigoDoCliente;
    }

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    public boolean isPedidoAberto() {
        return pedidoAberto;
    }

    public void setPedidoAberto(boolean pedidoAberto) {
        this.pedidoAberto = pedidoAberto;
    }

    public int getCodigoDoCaixaVinculadoAoPedido() {
        return codigoDoCaixaVinculadoAoPedido;
    }

    public void setCodigoDoCaixaVinculadoAoPedido(int codigoDoCaixaVinculadoAoPedido) {
        this.codigoDoCaixaVinculadoAoPedido = codigoDoCaixaVinculadoAoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigoDoPedido=" + codigoDoPedido + ", dataDoPedido=" + dataDoPedido + ", codigoDoCliente=" + codigoDoCliente + ", valorTotalDoPedido=" + valorTotalDoPedido + ", pedidoAberto=" + pedidoAberto + ", codigoDoCaixaVinculadoAoPedido=" + codigoDoCaixaVinculadoAoPedido + '}';
    }

}
