/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabtecnicas;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 13280025
 */
public class Parquimetro {

    

    private final Date inicioTarifacao = new Date(0, 0, 0, 8, 30);
    private final Date finalTarifacao = new Date(0, 0, 0, 18, 30);
    private final int minTime = 30;
    private final int maxTime = 120;
    private int incremento = 10;
    private final double valorBase = 0.75;
    private final double valorIncremento = 0.25;
    private int idParquimetro;
    private String endereco;
    private int quantIncrementos;
    private MeioPagamento pagamento;
    private double valorInserido = 0;

    public Parquimetro(int idParquimetro, String endereco) {
        this.idParquimetro = idParquimetro;
        this.endereco = endereco;
        incremento = 0;
    }
    
    
    public void definirPagamento(FactoryPagamento.pagamentos tipo){
        pagamento = FactoryPagamento.getInstance().tipoPagamento(tipo);
    }
    
    
    public void incrementarValidade(){
        quantIncrementos++;
    }
    
        
    public void decrementarValidade(){
        if (quantIncrementos > 0) quantIncrementos--;
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
    
    
    public TicketEstacionamento gerarTicket(){
        if (pagamento == null) {
            System.out.println("favor definir forma de pagamento");
            return null;
                    
        }
        
        pagamento.adicionarSaldo(valorInserido);
        double valorTotal = valorBase + (valorIncremento * quantIncrementos);
        if (pagamento instanceof pagamentoMoedas){
            valorTotal-= valorInserido;
        }
        pagamento.pagar(valorTotal);
        
        if (pagamento.saldo() > 0){
            System.out.println("valor de troco : " + pagamento.troco());
        }
        Date dataAtual = new Date();
        TicketEstacionamento aux = new TicketEstacionamento(geraTickedID(10000, 99999), this.idParquimetro, this.endereco, dataAtual, new Date(dataAtual.getTime() + (minTime * 60000) + ((quantIncrementos * quantIncrementos) * 60000)), pagamento.getTipo());
        FileWriterFacade.getInstance().saveTicket(this.idParquimetro, aux);
        
        resetParquimetroData();
        
        return aux;
    }
    
    
    // operacao random de apoio
    
    public int geraTickedID(int min, int max) {

    Random rand = new Random();

    // nextInt excludes the top value so we have to add 1 to include the top value
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
    
    private void resetParquimetroData() {
        valorInserido = 0;
        quantIncrementos = 0;
        pagamento = null;
        
    }

    public double getValorInserido(){
        return valorInserido;
    }
 
    public int getIncrementos(){
        return quantIncrementos;
    }
    
    public FactoryPagamento.pagamentos getTipoPagamento(){
        return pagamento.getTipo();
    }

    
}
