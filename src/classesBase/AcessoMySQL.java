package classesBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugo
 */
import java.sql.*;

public class AcessoMySQL {
	
	Connection con;
        String nomeBanco;
        String usuario;

    public AcessoMySQL(String nomeBanco, String usuario) {
        this.nomeBanco = nomeBanco;
        this.usuario = usuario;
       
    }

	
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/"+this.nomeBanco+"?user="+this.usuario);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível encontrar o Driver!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível conectar ao banco!");
        }
        return con;
    }
    
    public void desconect(){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }	
    
     public Statement getStatement() throws SQLException
    {
     return getConnection().createStatement();   
    }
    
        
    public PreparedStatement getStatement(String st) throws SQLException 
    {
    return getConnection().prepareStatement(st);
    }
    
    public ResultSet executeQuery (String query, Object... params) throws SQLException
    {
        PreparedStatement ps = getStatement(query);
        for(int i=0; i < params.length; i++){
            ps.setObject(i+1,params[i]);
        }
        return ps.executeQuery();
     }
    
    public Object executeCommand (String query, Object... params) throws SQLException
    {
        PreparedStatement ps = getStatement(query);
        for(int i=0; i < params.length; i++){
            ps.setObject(i+1,params[i]);
        }
        int result = ps.executeUpdate();
        ps.close();
        return result;
     }
    public Integer GetNextId(String tableName, String ID) throws SQLException
    {
    ResultSet rs = executeQuery("select MAX("+ID+") as inc from "+tableName);
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
}