/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import Classe.ViewItensDoPedido;

/**
 *
 * @author hugo
 */
public class ViewItensDoPedidoDAO extends AcessoMySQL {
    
     public ViewItensDoPedidoDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
        this.getConnection();
    }
     
     public List <ViewItensDoPedido> buscarViewItensDoPedidoPorPedido(int codped) throws SQLException{
       List <ViewItensDoPedido> retorno = new LinkedList<ViewItensDoPedido>();
       String sql = "select * from viewitensdopedido where codpedido = ?";
       ResultSet rs = executeQuery(sql,codped);
       while(rs.next()){
           //System.out.println(populateViewItensDoPedido(rs).toString());
           retorno.add(populateViewItensDoPedido(rs));
       }
       return retorno;
   }
    
        
    private ViewItensDoPedido populateViewItensDoPedido(ResultSet rs) throws SQLException {
        ViewItensDoPedido retorno = new ViewItensDoPedido();
        retorno.setCodigoDosItensDoPedido(rs.getInt("cod"));
        retorno.setCodigoDoPedido(rs.getInt("codpedido"));
        retorno.setCodigoDoProduto(rs.getInt("codproduto"));
        retorno.setNomeDoProduto(rs.getString("nome"));
        retorno.setQuantidadeDeProdutos(rs.getInt("quantidade"));
        retorno.setValorUnitarioDoProduto(rs.getDouble("valorvendaproduto")); 
        return(retorno);
    } 
     
     
     
     
     
     
    
    
    
    
    
}
