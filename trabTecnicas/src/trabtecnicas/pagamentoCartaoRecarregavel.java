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

        private double creditos;
        
        
    public pagamentoCartaoRecarregavel(double creditos){
        this.creditos = creditos;
    }
    
    @Override
    public double saldo() {
        return creditos;
    }

    @Override
    public void pagar(double valor) {
        creditos -= valor;
    }

    @Override
    public double troco() {
        return 0;
    }

    @Override
    public FactoryPagamento.pagamentos getTipo() {
        return FactoryPagamento.pagamentos.cartao;
    }

    @Override
    public void adicionarSaldo(double valor) {
        creditos += valor;
    }

}
