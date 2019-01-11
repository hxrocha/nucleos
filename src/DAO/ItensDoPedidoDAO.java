/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.ItensDoPedido;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hugo
 */
public class ItensDoPedidoDAO  extends AcessoMySQL  {
    
     public ItensDoPedidoDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
        this.getConnection();
    }
    
    public void insere(ItensDoPedido i,int codPedido){
        try {
            i.setCodigoDoItenDoPedido(this.pegaProximoItem("itensdopedido","cod",codPedido));
            String sql = "insert into itensdopedido(cod,codpedido,codproduto,valorvendaproduto,quantidade) values(?,?,?,?,?)";
            this.executeCommand(sql,i.getCodigoDoItenDoPedido(),i.getCodigoDoPedido(),i.getCodigoDoProduto(),i.getValorUnitarioDoProduto(),i.getQuantidadeDeProdutos());
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
    }
    
    
    public void apagar(int cod,int codped){
    String sql = "delete from itensdopedido where cod = ? and codpedido = ?";
        try {
            this.executeCommand(sql,cod,codped);
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    
    }  
    public void apagarTodosItensDeUmPedido(int codped){
    String sql = "delete from itensdopedido where codpedido = ?";
        try {
            this.executeCommand(sql,codped);
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    
    }

    private int pegaProximoItem(String tableName, String ID,int numPedido) throws SQLException {
    ResultSet rs = executeQuery("select MAX("+ID+") as inc from "+tableName + " where codpedido="+numPedido);
    rs.next();
    Object result = rs.getObject(1);
    if(result == null)
    {
    rs.close();
    return 1;
    }
    else
        return((Integer)rs.getInt("inc"))+1;
    }
    
     public void atualiza(ItensDoPedido itemDoPedido){
    String sql = "update itensdopedido set codproduto = ?,valorvendaproduto = ?, quantidade = ?"
            + " where cod = ? and codpedido = ?";
        try {
            this.executeCommand(sql,itemDoPedido.getCodigoDoProduto(),itemDoPedido.getValorUnitarioDoProduto(),
                    itemDoPedido.getQuantidadeDeProdutos(),itemDoPedido.getCodigoDoItenDoPedido(),itemDoPedido.getCodigoDoPedido());
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
    }
    
    
    
}
