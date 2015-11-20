/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabtecnicas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joohe
 */
public class ParquimetroTest {
    
    public ParquimetroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of definirPagamento method, of class Parquimetro.
     */
    @Test
    public void testDefinirPagamento() {
        System.out.println("definirPagamento");
        Parquimetro instance = new Parquimetro(1009, "rua alameda dos anjos 00666");
        instance.definirPagamento(FactoryPagamento.pagamentos.moedas);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(FactoryPagamento.pagamentos.moedas, instance.getTipoPagamento());
    
    }  

    /**
     * Test of incrementarValidade method, of class Parquimetro.
     */
    @Test
    public void testIncrementarValidade() {
        System.out.println("incrementarValidade");
        Parquimetro instance = new Parquimetro(69, "av ipiranga 6681 ");
        instance.incrementarValidade();
        assertEquals(1, instance.getIncrementos());
    }

    /**
     * Test of decrementarValidade method, of class Parquimetro.
     */
    @Test
    public void testDecrementarValidade() {
        System.out.println("decrementarValidade");
        Parquimetro instance = new Parquimetro(0001, "rua dos bobos numero 1");
        instance.decrementarValidade();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0, instance.getIncrementos());
        
    }
    

    /**
     * Test of adicionarMoeda method, of class Parquimetro.
     */
    @Test
    public void testAdicionarMoeda() {
        System.out.println("adicionarMoeda");
        double tipo = 0.5;
        Parquimetro instance = new Parquimetro(0001, "rua dos bobos nº 0");
        instance.adicionarMoeda(1);
        assertEquals(tipo, instance.getValorInserido(), 0.1);
        // TODO review the generated test code and remove the default call to fail.

    }
    

    /**
     * Test of gerarTicket method, of class Parquimetro.
     */
    @Test
    public void testGerarTicket() {
        System.out.println("gerarTicket");
        Parquimetro instance = new Parquimetro(010, "rua joao sem braco 01");
        instance.definirPagamento(FactoryPagamento.pagamentos.residente);
        assertNotNull(instance.gerarTicket());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of randomInteger method, of class Parquimetro.
     */
    @Test
    public void testRandomInteger() {
        System.out.println("randomInteger");
        int min = 0;
        int max = 0;
        Parquimetro instance = new Parquimetro(0101, "rua dos bobos 9909");
        int expResult = 0;
        int result = instance.geraTickedID(min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
