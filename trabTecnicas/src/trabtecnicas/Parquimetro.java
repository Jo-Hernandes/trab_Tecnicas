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
    
    enum pagamentos {moedas, cartao, residente};

    private Date inicioTarifacao = new Date(0, 0, 0, 8, 30);
    private Date finalTarifacao = new Date(0, 0, 0, 18, 30);
    private int minTime = 30;
    private int maxTime = 120;
    private int incremento = 10;
    private double valorBase = 0.75;
    private double valorIncremento = 0.25;
    private int idParquimetro;
    private String endereco;

    public Parquimetro(int idParquimetro, String endereco) {
        this.idParquimetro = idParquimetro;
        this.endereco = endereco;
    }
    
    public void incrementarValidade(TicketEstacionamento ticket){
        ticket.setValidade(new Date (ticket.getValidade().getTime()+ 600000));
    }
    
    
    public void decrementarValidade(TicketEstacionamento ticket){
        ticket.setValidade(new Date (ticket.getValidade().getTime() - 600000));
    }
    
    
    public TicketEstacionamento iniciarOperacao(TicketEstacionamento.pagamentos tipo){
        Date horaInicial = new Date();
        TicketEstacionamento aux = new TicketEstacionamento(randomInteger(10000, 99999), this.idParquimetro, this.endereco, horaInicial, new Date(horaInicial.getTime() + 1800000), tipo);
        boolean emOperacao = true;
        //create the Scanner
        Scanner terminalInput = new Scanner(System.in);

        do {
            System.out.println("Digite + para incrementar, - para decrementar, 0 para terminar a operacao e 1 para cancelar");
            String s = terminalInput.nextLine();
            
            switch (s){
            case "+" : incrementarValidade(aux);
                        break;
            case "-" : decrementarValidade(aux);
                        break;
            case "0" : emOperacao = false;
                        break;
            case "1" : System.out.println("Operacao cancelada");
                       return null;

            default : System.out.println("Comando invalido");
            }
            
        }while(emOperacao);
        
           
        return aux;
        
       
    }
    
    
    // operacao random de apoio
    
    public int randomInteger(int min, int max) {

    Random rand = new Random();

    // nextInt excludes the top value so we have to add 1 to include the top value
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}

      
}
