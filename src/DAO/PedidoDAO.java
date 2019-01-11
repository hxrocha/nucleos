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
import Classe.Pedido;

/**
 *
 * @author hugo
 */
public class PedidoDAO extends AcessoMySQL{
    
     public PedidoDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
        this.getConnection();
        
    }
     /*
    public void insere(Pedido c){
        try {
            c.setCodPedido(this.GetNextId("pedido","codpedido"));
            String sql = "insert into pedido(codpedido,codcliente) values(?,?)";
            this.executeCommand(sql,c.getCodPedido(),c.getCodcliente());
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
    }
    */
        public int inicia(){
        int novoCodigoDoPedido = 0;
        try {
            novoCodigoDoPedido =(this.GetNextId("pedido","codpedido"));
            String sql = "insert into pedido(codpedido) values(?)";
            this.executeCommand(sql,novoCodigoDoPedido);
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
        return(novoCodigoDoPedido);
    }
    /*
    public void atualiza(Pedido c){
    String sql = "update pedido set valortotal = ?,aberto = ?"
            + "where codpedido = ?";
        try {
            this.executeCommand(sql,c.getValorTotalDoPedido(),c.getCodigoDoPedido(),c.isCaixaAberto);
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
    }
*/
    public boolean finaliza(Pedido pedido){
    String sql = "update pedido set codcliente = ?,data = ?,valortotal=?,aberto=?,codigodocaixa=? "
            + "where codpedido = ?";
        try {
            this.executeCommand(sql,pedido.getCodigoDoCliente(),pedido.getDataDoPedido(),
                    pedido.getValorTotalDoPedido(),pedido.isPedidoAberto(),
                    pedido.getCodigoDoCaixaVinculadoAoPedido(),pedido.getCodigoDoPedido());
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
            return false;
        }
    }
    
    
    
    public void apagar (int codigoDoPedido){
    String sql = "delete from pedido where codpedido = ?";
        try {
            this.executeCommand(sql,codigoDoPedido);
        } catch (SQLException ex) {
            System.out.println("Erro : "+ex.getMessage());
        }
    }
   
    public List <Pedido> pegaTodosPedido() throws SQLException{
         List <Pedido> retorno = new LinkedList<Pedido>();
        String sql = "select * from pedido order by codpedido desc";
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            retorno.add(populatePedido(rs));
        }
        return retorno;
    }
    
     public List <Pedido> pegaPedidoPorCod(int cod) throws SQLException{
         List <Pedido> retorno = new LinkedList<Pedido>();
        String sql = "select * from pedido where codpedido = ?";
        ResultSet rs = this.executeQuery(sql,cod);
        while(rs.next()){
            retorno.add(populatePedido(rs));
        }
        return retorno;
    }
     
      public int pedidosEmAberto() throws SQLException{
        String sql = "SELECT COUNT(codpedido) as pedidosabertos from pedido where aberto = true";
        ResultSet rs = this.executeQuery(sql);
        if(rs.next()){
            return(rs.getInt("pedidosabertos"));
        }
        return 0;
    }
      
      
     
    public Pedido pegaPedidoAberto() throws SQLException{
        Pedido retorno = new Pedido();
        String sql = "select * from pedido where aberto = true";
        ResultSet rs = this.executeQuery(sql);
        if(rs.next()){
            retorno = populatePedido(rs);
        }
        return retorno;
    }
     

    private Pedido populatePedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setCodigoDoPedido(rs.getInt("codpedido"));
        pedido.setCodigoDoCliente(rs.getInt("codcliente"));
        pedido.setDataDoPedido(String.valueOf(rs.getDate("data")));
        pedido.setValorTotalDoPedido(rs.getDouble("valortotal"));
        pedido.setPedidoAberto(rs.getBoolean("aberto"));
        pedido.setCodigoDoCaixaVinculadoAoPedido(rs.getInt("codigodocaixa"));
        return pedido;  
    }
    
    
}
