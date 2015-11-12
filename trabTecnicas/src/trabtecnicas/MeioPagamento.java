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
public interface MeioPagamento {
    
    double saldo();
    void pagar(int valor);
    double troco();
    boolean encerrar();
}
