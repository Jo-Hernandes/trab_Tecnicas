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
    void pagar(double valor);
    double troco();
    void adicionarSaldo(double valor);
    FactoryPagamento.pagamentos getTipo();
    
}
