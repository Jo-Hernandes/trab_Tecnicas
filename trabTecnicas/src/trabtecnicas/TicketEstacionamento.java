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
public class TicketEstacionamento {
    
    enum pagamentos {moedas, cartao, residente};

        
    private int id;
    private int idParquimetro;
    private String endereco;
    private Date emissao;
    private Date validade;
    private FactoryPagamento.pagamentos tipoPagamento;

    public TicketEstacionamento(int id, int idParquimetro, String endereco, Date emissao, Date validade, FactoryPagamento.pagamentos tipoPagamento) {
        this.id = id;
        this.idParquimetro = idParquimetro;
        this.endereco = endereco;
        this.emissao = emissao;
        this.validade = validade;
        this.tipoPagamento = tipoPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdParquimetro() {
        return idParquimetro;
    }

    public void setIdParquimetro(int idParquimetro) {
        this.idParquimetro = idParquimetro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return idParquimetro + "," + 
                id + "," + 
                endereco + "," + 
                emissao.toString() + "," + 
                validade.toString() + "," + 
                tipoPagamento;
    }
    
    
    
    
}

/*
Número de identificação do parquímetro (5 dígitos de tamanho fixo);

Endereço do parquímetro;

Número serial do tíquete emitido (5 dígitos de tamanho fixo);

Data e hora de emissão do tíquete;

Data e hora de validade do tíquete */