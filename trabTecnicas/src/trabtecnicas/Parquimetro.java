/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabtecnicas;

import java.util.Date;

/**
 *
 * @author 13280025
 */
public class Parquimetro {
    
    private Date inicioTarifacao = new Date(0, 0, 0, 8, 30);
    private Date finalTarifacao = new Date(0, 0, 0, 18, 30);
    private int minTime = 30;
    private int maxTime = 120;
    private int incremento = 10;
    private double valorBase = 0.75;
    private double valorIncremento = 0.25;
    
}
