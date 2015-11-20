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

    
    public pagamentoResidente(){}
    
    @Override
    public double saldo() {
        return Double.MAX_VALUE;
    }

    @Override
    public void pagar(double valor) {
    }

    @Override
    public double troco() {
        return 0;
    }

    @Override
    public FactoryPagamento.pagamentos getTipo() {
        return FactoryPagamento.pagamentos.residente;
    }

    @Override
    public void adicionarSaldo(double valor) {}
    
  
    
}
