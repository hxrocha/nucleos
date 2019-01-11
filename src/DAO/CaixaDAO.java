/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Caixa;
import Classe.Pedido;
import Classe.RetornoDoDAO;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author hugo
 */
public class CaixaDAO extends AcessoMySQL {

    public CaixaDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
        this.getConnection();
        
    }
    public RetornoDoDAO insereNovoCaixa(Caixa caixa){
        RetornoDoDAO retornoDoDAO;
        try {
            caixa.setCodigoDoCaixa(this.GetNextId("caixa","codcaixa"));
            String sql = "insert into caixa(codcaixa,valorinicial) values(?,?)";
            this.executeCommand(sql,caixa.getCodigoDoCaixa(),caixa.getValorInicialDoCaixa());
            retornoDoDAO = new RetornoDoDAO(true,"Caixa Inserido com sucesso!");
        } catch (SQLException ex) {
            retornoDoDAO = new RetornoDoDAO(false,"Erro ao inserir novo caixa : "+ex.getMessage());
        }
        return(retornoDoDAO);
    }
    
    public RetornoDoDAO numeroDoNovoCaixa(){
        RetornoDoDAO retornoDoDAO;
        try {
            int numeroDoNovoCaixa = this.GetNextId("caixa","codcaixa");
            retornoDoDAO = new RetornoDoDAO(true,"Numero do novo caixa pego com sucesso!",numeroDoNovoCaixa);
        } catch (SQLException ex) {
            retornoDoDAO = new RetornoDoDAO(false,"Erro ao pegar o número do novo caixa : "+ex.getMessage());
        }
         return(retornoDoDAO);
    }
    
    public RetornoDoDAO temCaixaAberto()  {
        RetornoDoDAO retornoDoDAO;
        try {
            String sql = "SELECT COUNT(codcaixa) as caixasabertos from caixa where aberto = true";
            ResultSet rs;
            rs = this.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt("caixasabertos") >= 1 ){
                        retornoDoDAO = new RetornoDoDAO(true,"verificado com sucesso!",true);
                        return(retornoDoDAO);
                }             
                else{
                        retornoDoDAO = new RetornoDoDAO(true,"verificado com sucesso!",false);
                        return(retornoDoDAO);
                }
        }else{
            retornoDoDAO = new RetornoDoDAO(false,"Ao verificar se tem caisa aberto \n Nenhum registro foi encontrado!");
            return(retornoDoDAO);
        }
        } catch (SQLException ex) {
           retornoDoDAO = new RetornoDoDAO(false,"Erro: "+ex.getMessage());
          
        }
        return(retornoDoDAO);
    }
    
     public RetornoDoDAO numeroDoCaixaAberto()  {
        RetornoDoDAO retornoDoDAO;
        String sql = "select codcaixa from caixa where aberto = true";
        ResultSet rs;
        try {
            rs = this.executeQuery(sql);
              if(rs.next()){
                int numeroDoCaixaAberto = rs.getInt("codcaixa");  
                retornoDoDAO = new RetornoDoDAO(true,"Numero do caixa recuperado!",numeroDoCaixaAberto);
                return(retornoDoDAO);
              }
              else{
                retornoDoDAO = new RetornoDoDAO(false,"Não tem caixa aberto!");
                return(retornoDoDAO);
              }
        } catch (SQLException ex) {
            retornoDoDAO = new RetornoDoDAO(false,"Erro : "+ex.getMessage());
           
        }
    return(retornoDoDAO);
    }
    
    
    public RetornoDoDAO atualizaAVenda(Pedido pedido){
    RetornoDoDAO retornoDoDAO;
    String sql = "update caixa set vendas = (vendas + ?) "
            + "where codcaixa = ?";
        try {
            this.executeCommand(sql,pedido.getValorTotalDoPedido(),pedido.getCodigoDoCaixaVinculadoAoPedido());
             retornoDoDAO = new RetornoDoDAO(true,"Venda atualizada com sucesso!");
             return(retornoDoDAO);
        } catch (SQLException ex) {
            retornoDoDAO = new RetornoDoDAO(false,"Erro ao atualizar a venda : "+ex.getMessage());
        }
        return(retornoDoDAO);
    } 
    
}
