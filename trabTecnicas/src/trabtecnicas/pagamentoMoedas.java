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
        valorInserido = 0;
    }
    
    public void adicionarMoeda(int tipo){
        switch (tipo) {
            case 1 :    valorInserido += 0.5;
                        break;
            case 2 :    valorInserido += 0.10;
                        break;
            case 3 :    valorInserido += 0.25;
                        break;
            case 4 :    valorInserido += 0.50;
                        break;
            case 5 :    valorInserido += 1.00;
                        break;
            default : System.err.println("moeda nao suportada");
        }
    }
    
    @Override
    public double saldo() {
        return valorInserido; 
    }

    @Override
    public void pagar(int valor) {
        custoEstacionamento -= valor;
        if (custoEstacionamento < 0){
            troco = Math.abs(custoEstacionamento);
        }
    }

    @Override
    public double troco() {
        return troco;
    }
    
}
