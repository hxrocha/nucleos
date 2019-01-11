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
public class Vendedor {
    private int codigoDoVendedor;
    private String nomeDoVendedor;

    public Vendedor() {
        this.codigoDoVendedor = 1;
        this.nomeDoVendedor = "Vendedor Padrão";
    }

    public Vendedor(int codigoDoVendedor, String nomeDoVendedor) {
        this.codigoDoVendedor = codigoDoVendedor;
        this.nomeDoVendedor = nomeDoVendedor;
    }

    public int getCodigoDoVendedor() {
        return codigoDoVendedor;
    }

    public void setCodigoDoVendedor(int codigoDoVendedor) {
        this.codigoDoVendedor = codigoDoVendedor;
    }

    public String getNomeDoVendedor() {
        return nomeDoVendedor;
    }

    public void setNomeDoVendedor(String nomeDoVendedor) {
        this.nomeDoVendedor = nomeDoVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "codigoDoVendedor=" + codigoDoVendedor + ", nomeDoVendedor=" + nomeDoVendedor + '}';
    }

   
}
