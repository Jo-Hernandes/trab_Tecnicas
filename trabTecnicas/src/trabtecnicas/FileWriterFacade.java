/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabtecnicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author joohe
 */
public class FileWriterFacade {
    
    static FileWriterFacade instance;
    
    private void FileWriterFacare(){
    }
    
    static FileWriterFacade getInstance(){
        if (instance == null){
            instance = new FileWriterFacade(); 
        }
        return instance;
    }


    public void saveTicket(int parquimetroID, TicketEstacionamento ticket){
        String endereco = "C:/" + parquimetroID + ".txt";
        FileWriter w = null;
        try {
            w = new FileWriter(endereco);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);

        try {
            wr.write(ticket.toString());
            wr.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
       
    public ArrayList<TicketEstacionamento> lerLogTickets(String parquimetroID){
        String endereco = "C:/" + parquimetroID + ".txt";
        ArrayList<TicketEstacionamento> ticketsSessao = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(endereco);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        BufferedReader bf = new BufferedReader(fr);
        String file = "";
        try {
            while ((file = bf.readLine()) != null) {
                String[] aux = file.trim().split(",");
                // ordem do string do ticket: 
                // idParquimetro   id   endereco  emissao validade tipoPagamento;
                // ordem do construtor do parquimetro:
                // (int id, int idParquimetro, String endereco, String emissao, String validade, String tipoPagamento)
                ticketsSessao.add(new TicketEstacionamento(Integer.parseInt(aux[1]), 
                                                           Integer.parseInt(aux[0]), 
                                                           aux[2], 
                                                           new Date(aux[3]), 
                                                           new Date(aux[4]),
                                                           Parquimetro.pagamentos.valueOf(aux[5])));
                                    
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }    
        return ticketsSessao;
    }

        
    


}
