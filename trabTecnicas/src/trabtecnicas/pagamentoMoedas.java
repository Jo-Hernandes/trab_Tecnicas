/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabtecnicas;

/**
 *
 * @author 13280025
 */
public class pagamentoMoedas implements MeioPagamento{

    private double valorInserido;
    private double custoEstacionamento;
    private double troco;
    
    public pagamentoMoedas(){
    }

    
    @Override
    public double saldo() {
        return valorInserido; 
    }

    @Override
    public void pagar(double valor) {
        if (valorInserido - valor <= 0){
            valorInserido -= valor;
            troco = Math.abs(valorInserido);
        }
        else {
            System.out.println("valor insuficiente");
        }
    }

    @Override
    public double troco() {
        return troco;
    }
    
    public void setValorInserido(double valor){
        valorInserido = valor;
    }

    @Override
    public Parquimetro.pagamentos getTipo() {
        return Parquimetro.pagamentos.moedas;
    }
}
