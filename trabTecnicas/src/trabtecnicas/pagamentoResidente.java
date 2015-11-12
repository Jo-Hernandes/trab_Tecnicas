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
public class pagamentoResidente implements MeioPagamento{

    
    public pagamentoResidente(){
        
    }
    
    @Override
    public double saldo() {
        return 0;
    }

    @Override
    public void pagar(int valor) {
        // pago
    }

    @Override
    public double troco() {
        return 0;
    }
    
}
