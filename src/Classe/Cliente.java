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
public class Cliente {
     @SwingColumn(description="Código",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int codigoDoCliente;
    @SwingColumn(description="Nome",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String nomeDoCliente;
    @SwingColumn(description="Telefone",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String telefoneDoCliente;

    public Cliente() {
    }

    public int getCodigoDoCliente() {
        return codigoDoCliente;
    }

    public void setCodigoDoCliente(int codigoDoCliente) {
        this.codigoDoCliente = codigoDoCliente;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getTelefoneDoCliente() {
        return telefoneDoCliente;
    }

    public void setTelefoneDoCliente(String telefoneDoCliente) {
        this.telefoneDoCliente = telefoneDoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigoDoCliente=" + codigoDoCliente + ", nomeDoCliente=" + nomeDoCliente + ", telefoneDoCliente=" + telefoneDoCliente + '}';
    }
}
