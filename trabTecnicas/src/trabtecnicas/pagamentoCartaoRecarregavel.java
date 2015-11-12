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
public class pagamentoCartaoRecarregavel implements MeioPagamento{

        private int creditos;
        
        
    public pagamentoCartaoRecarregavel(int creditos){
        this.creditos = creditos;
    }
    
    @Override
    public double saldo() {
        return creditos;
    }

    @Override
    public void pagar(int valor) {
        creditos -= valor;
    }

    @Override
    public double troco() {
        return 0;
    }

}
