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
public class RetornoDoDAO {
    public boolean executadoComSucesso;
    public String mensagem;
    public double valorRetornadoDouble;
    public int valorRetornadoInteiro;
    public boolean valorDoRetornoBooleano;

    public RetornoDoDAO(boolean executadoComSucesso, String mensagem) {
        this.executadoComSucesso = executadoComSucesso;
        this.mensagem = mensagem;
    }

    public RetornoDoDAO(boolean executadoComSucesso, String mensagem, double valorRetornadoDouble) {
        this.executadoComSucesso = executadoComSucesso;
        this.mensagem = mensagem;
        this.valorRetornadoDouble = valorRetornadoDouble;
    }

    public RetornoDoDAO(boolean executadoComSucesso, String mensagem, int valorRetornadoInteiro) {
        this.executadoComSucesso = executadoComSucesso;
        this.mensagem = mensagem;
        this.valorRetornadoInteiro = valorRetornadoInteiro;
    }

    public RetornoDoDAO(boolean executadoComSucesso, String mensagem, boolean valorDoRetornoBooleano) {
        this.executadoComSucesso = executadoComSucesso;
        this.mensagem = mensagem;
        this.valorDoRetornoBooleano = valorDoRetornoBooleano;
    }
    
    
    
    
    
}
