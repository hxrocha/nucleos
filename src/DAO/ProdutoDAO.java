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
import Classe.Produto;

/**
 *
 * @author hugo
 */
public class ProdutoDAO extends AcessoMySQL  {

    public ProdutoDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
        this.getConnection();
    }
    
    public void insere(Produto produto){
        try {
            produto.setCodigoDoProduto(this.GetNextId("produto","codproduto"));
            String sql = "insert into produto(codproduto,nome,preco,quantidade,codigobarra) values(?,?,?,?,?)";
            this.executeCommand(sql,produto.getCodigoDoProduto(),produto.getNomeDoProduto(),
                    produto.getPrecoDoProduto(),produto.getQuantidadeDeProdutos(),
                    produto.getCodigoDeBarraDoProduto());
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
    }
    
    public void atualiza(Produto produto){
    String sql = "update produto set nome = ?, preco = ?, quantidade =  ? , codigobarra = ? "
            + "where codproduto = ?";
        try {
            this.executeCommand(sql,produto.getNomeDoProduto(),produto.getPrecoDoProduto(),produto.getQuantidadeDeProdutos(),produto.getCodigoDoProduto(),produto.getCodigoDeBarraDoProduto());
            
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
            
        }
    }
    
    public void apagar(int codigoDoProduto){
    String sql = "delete from produto where codproduto = ?";
        try {
            this.executeCommand(sql,codigoDoProduto);
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    
    }
    public void apagar(String codigoDeBarraDoProduto){
    String sql = "delete from produto where codbarra = ?";
        try {
            this.executeCommand(sql,codigoDeBarraDoProduto);
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    
    }
    
    public List <Produto> buscarTodosProdutos() throws SQLException{
       List <Produto> retorno = new LinkedList<Produto>();
       String sql = "select * from produto";
       ResultSet rs = executeQuery(sql);
       while(rs.next()){
           retorno.add(populateProduto(rs));
       }
       return retorno;
   }
    
     public Produto buscarProdutoPorCodigo(int codigoDoProduto) throws SQLException{
       Produto retorno = new Produto();
       String sql = "select * from produto where codproduto = ?";
       ResultSet rs = executeQuery(sql,codigoDoProduto);
       if(rs.next())
           retorno = populateProduto(rs);
       return retorno;
   }
      public Produto buscarProdutoPorCodigoDeBarra(String codigoDeBarraDoProduto) throws SQLException{
       Produto retorno = new Produto();
       String sql = "select * from produto where codigobarra = ?";
       ResultSet rs = executeQuery(sql,codigoDeBarraDoProduto);
       if(rs.next())
           retorno = populateProduto(rs);
       return retorno;
   }
     
      public Produto buscarProdutoPorCodigo(String codigoDeBarraDoProduto) throws SQLException{
       Produto retorno = new Produto();
       String sql = "select * from produto where codigobarra = ?";
       ResultSet rs = executeQuery(sql,codigoDeBarraDoProduto);
       if(rs.next())
           retorno = populateProduto(rs);
       return retorno;
   }

    private Produto populateProduto(ResultSet rs) throws SQLException {
        Produto retorno = new Produto();
        retorno.setCodigoDoProduto(rs.getInt("codproduto"));
        retorno.setNomeDoProduto(rs.getString("nome"));
        retorno.setPrecoDoProduto(rs.getDouble("preco"));
        retorno.setQuantidadeDeProdutos(rs.getInt("quantidade"));
        retorno.setCodigoDeBarraDoProduto(rs.getString("codigobarra"));
        return(retorno);
    }
    
       public List <Produto> pegaTodosProdutosPorNome(String nome) throws SQLException{
         List <Produto> retorno = new LinkedList<Produto>();
        String sql = "select * from produto where nome like '%"+nome+"%' order by codProduto desc";
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            retorno.add(populateProduto(rs));
        }
        return retorno;
    }

   
    
    
    
}
