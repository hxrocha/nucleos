/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Cliente;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classe.Produto;
import Classe.RetornoDoDAO;

/**
 *
 * @author hugo
 */
public class ClienteDAO extends AcessoMySQL {

    public ClienteDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
        this.getConnection();
        
    }
    public RetornoDoDAO insereNovoCliente(Cliente cliente){
        RetornoDoDAO retornoDoDAO;
        try {
            cliente.setCodigoDoCliente(this.GetNextId("cliente","codcliente"));
            String sql = "insert into cliente(codcliente,nome,telefone) values(?,?,?)";
            this.executeCommand(sql,cliente.getCodigoDoCliente(),cliente.getNomeDoCliente(),cliente.getTelefoneDoCliente());
            retornoDoDAO = new RetornoDoDAO(true,"Cliente inserido com sucesso!");
            return(retornoDoDAO);
        } catch (SQLException ex) {
            retornoDoDAO = new RetornoDoDAO(false,"Ao inserir novo cliente \n Erro: "+ex.getMessage());
        }
        return(retornoDoDAO);
    }
    
    public RetornoDoDAO atualizaCliente(Cliente cliente){
    RetornoDoDAO retornoDoDAO;
    String sql = "update cliente set nome = ?, telefone = ? "
            + "where codcliente = ?";
    try {
            this.executeCommand(sql,cliente.getNomeDoCliente(),cliente.getTelefoneDoCliente()
            ,cliente.getCodigoDoCliente());
            retornoDoDAO = new RetornoDoDAO(true,"Cliente atualizado com sucesso!");
            return(retornoDoDAO);
        } catch (SQLException ex) {
            retornoDoDAO = new RetornoDoDAO(false,"Ao atualizar o cliente \n Erro: "+ex.getMessage());
        }
        return(retornoDoDAO);
    }
    
    public RetornoDoDAO apagarCliente(int codigoDoCliente){
        RetornoDoDAO retornoDoDAO;
        String sql = "delete from cliente where codcliente = ?";
        try {
            this.executeCommand(sql,codigoDoCliente);
            retornoDoDAO = new RetornoDoDAO(true,"Cliente apagado com sucesso!");
            return(retornoDoDAO);
        } catch (SQLException ex) {
            retornoDoDAO = new RetornoDoDAO(false,"Ao apagar o cliente \n Erro: "+ex.getMessage());
        }
        return(retornoDoDAO);
    }
    
    public List <Cliente> pegaTodosClientes() throws SQLException{
        List <Cliente> retorno = new LinkedList<Cliente>();
        String sql = "select * from cliente order by codcliente desc";
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            retorno.add(populateCliente(rs));
        }
        return retorno;
    }
    
     public List <Cliente> pegaTodosClientesPorNome(String nomeDoCliente) throws SQLException{
         List <Cliente> retorno = new LinkedList<Cliente>();
        String sql = "select * from cliente where nome like '%"+nomeDoCliente+"%' order by codcliente desc";
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            retorno.add(populateCliente(rs));
        }
        return retorno;
    }

    private Cliente populateCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCodigoDoCliente(rs.getInt("codcliente"));
        cliente.setNomeDoCliente(rs.getString("nome"));
        cliente.setTelefoneDoCliente(rs.getString("telefone"));
        return cliente;  
    }
    
}
