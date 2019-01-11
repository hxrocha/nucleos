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
import Classe.Vendedor;

/**
 *
 * @author hugo
 */
public class VendedorDAO extends AcessoMySQL  {

    public VendedorDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
        this.getConnection();
    }
    
    public void insere(Vendedor vendedor){
        try {
            vendedor.setCodigoDoVendedor(this.GetNextId("vendedor","cod"));
            String sql = "insert into vendedor(cod,nome) values(?,?)";
            this.executeCommand(sql,vendedor.getCodigoDoVendedor(),vendedor.getNomeDoVendedor());
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
    }
    
    public void atualiza(Vendedor vendedor){
    String sql = "update vendedor set nome = ? "
            + "where cod = ?";
        try {
            this.executeCommand(sql,vendedor.getCodigoDoVendedor());
            
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
            
        }
    }
    
    public void apagar(int codigoDoVendedor){
    String sql = "delete from vendedor where cod = ?";
        try {
            this.executeCommand(sql,codigoDoVendedor);
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    
    }
    
    public List <Vendedor> buscarTodosVendedores() throws SQLException{
       List <Vendedor> retorno = new LinkedList<Vendedor>();
       String sql = "select * from vendedor";
       ResultSet rs = executeQuery(sql);
       while(rs.next()){
           retorno.add(populateVendedor(rs));
       }
       return retorno;
   }
    
     public Vendedor buscarVendedorPorCodigo(int codigoDoVendedor) throws SQLException{
       Vendedor retorno = new Vendedor();
       String sql = "select * from vendedor where cod = ?";
       ResultSet rs = executeQuery(sql,codigoDoVendedor);
       if(rs.next())
           retorno = populateVendedor(rs);
       return retorno;
   }

   
    private Vendedor populateVendedor(ResultSet rs) throws SQLException {
        Vendedor retorno = new Vendedor();
        retorno.setCodigoDoVendedor(rs.getInt("cod"));
        retorno.setNomeDoVendedor(rs.getString("nome"));
        return(retorno);
    }
    
}