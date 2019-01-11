/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.Calendar;

/**
 *
 * @author hugo
 */
public class Caixa {
    private int codigoDoCaixa;
    private Calendar dataAberturaDoCaixa;
    private Calendar dataFechamentoDoCaixa;
    private double valorInicialDoCaixa;
    private double valorFinalDoCaixa;
    private double vendasTotaisDoCaixa;
    private double depositoTotalDoCaixa;
    private double diferencaTotalDoCaixa;
    private boolean caixaAberto;

    public Caixa() {
    }

    public int getCodigoDoCaixa() {
        return codigoDoCaixa;
    }

    public void setCodigoDoCaixa(int codigoDoCaixa) {
        this.codigoDoCaixa = codigoDoCaixa;
    }

    public Calendar getDataAberturaDoCaixa() {
        return dataAberturaDoCaixa;
    }

    public void setDataAberturaDoCaixa(Calendar dataAberturaDoCaixa) {
        this.dataAberturaDoCaixa = dataAberturaDoCaixa;
    }

    public Calendar getDataFechamentoDoCaixa() {
        return dataFechamentoDoCaixa;
    }

    public void setDataFechamentoDoCaixa(Calendar dataFechamentoDoCaixa) {
        this.dataFechamentoDoCaixa = dataFechamentoDoCaixa;
    }

    public double getValorInicialDoCaixa() {
        return valorInicialDoCaixa;
    }

    public void setValorInicialDoCaixa(double valorInicialDoCaixa) {
        this.valorInicialDoCaixa = valorInicialDoCaixa;
    }

    public double getValorFinalDoCaixa() {
        return valorFinalDoCaixa;
    }

    public void setValorFinalDoCaixa(double valorFinalDoCaixa) {
        this.valorFinalDoCaixa = valorFinalDoCaixa;
    }

    public double getVendasTotaisDoCaixa() {
        return vendasTotaisDoCaixa;
    }

    public void setVendasTotaisDoCaixa(double vendasTotaisDoCaixa) {
        this.vendasTotaisDoCaixa = vendasTotaisDoCaixa;
    }

    public double getDepositoTotalDoCaixa() {
        return depositoTotalDoCaixa;
    }

    public void setDepositoTotalDoCaixa(double depositoTotalDoCaixa) {
        this.depositoTotalDoCaixa = depositoTotalDoCaixa;
    }

    public double getDiferencaTotalDoCaixa() {
        return diferencaTotalDoCaixa;
    }

    public void setDiferencaTotalDoCaixa(double diferencaTotalDoCaixa) {
        this.diferencaTotalDoCaixa = diferencaTotalDoCaixa;
    }

    public boolean isCaixaAberto() {
        return caixaAberto;
    }

    public void setCaixaAberto(boolean caixaAberto) {
        this.caixaAberto = caixaAberto;
    }

    @Override
    public String toString() {
        return "Caixa{" + "codigoDoCaixa=" + codigoDoCaixa + ", dataAberturaDoCaixa=" + dataAberturaDoCaixa + ", dataFechamentoDoCaixa=" + dataFechamentoDoCaixa + ", valorInicialDoCaixa=" + valorInicialDoCaixa + ", valorFinalDoCaixa=" + valorFinalDoCaixa + ", vendasTotaisDoCaixa=" + vendasTotaisDoCaixa + ", depositoTotalDoCaixa=" + depositoTotalDoCaixa + ", diferencaTotalDoCaixa=" + diferencaTotalDoCaixa + ", caixaAberto=" + caixaAberto + '}';
    } 
}