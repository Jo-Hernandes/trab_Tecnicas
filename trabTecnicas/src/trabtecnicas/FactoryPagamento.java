/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabtecnicas;

/**
 *
 * @author joohe
 */
public class FactoryPagamento {
 
    static FactoryPagamento instance;
    
    enum pagamentos {moedas, cartao, residente};
    
    private FactoryPagamento(){
        
    }
    
    static public FactoryPagamento getInstance(){
        if (instance == null){
            instance = new FactoryPagamento();
        }
        return instance;
    }
    
    public MeioPagamento tipoPagamento(pagamentos tipo){
                
        switch (tipo){
        
            case moedas :   return new pagamentoMoedas();
            case cartao :   return new pagamentoCartaoRecarregavel(50);
            case residente: return new pagamentoResidente();
            
        }
        
        return null;
    }
    
}
