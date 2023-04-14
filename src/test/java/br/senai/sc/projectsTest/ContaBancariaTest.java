package br.senai.sc.projectsTest;

import br.senai.sc.projects.ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    ContaBancaria contaBancaria;

    @BeforeEach
    public void setup() {
        contaBancaria = new ContaBancaria("123", "erika");
        contaBancaria.setSaldo(1000);
        contaBancaria.setTaxaJuros(1.5);
    }

    @Test
    public void getNumeroContaTest() {
        assertEquals("123", contaBancaria.getNumeroConta());
    }

    @Test
    public void getTitular() {
        assertEquals("erika", contaBancaria.getTitular());
    }

    @Test
    public void getTaxaJuros() {
        assertEquals(1.5, contaBancaria.getTaxaJuros());
    }

    @Test
    public void depositarTest() {
        assertFalse(contaBancaria.depositar(0));
        assertFalse(contaBancaria.depositar(-1));
        assertTrue(contaBancaria.depositar(1));
    }

    @Test
    public void sacarTest() {
        assertFalse(contaBancaria.sacar(0));
        assertFalse(contaBancaria.sacar(-1));
        assertFalse(contaBancaria.sacar(1001));
        assertTrue(contaBancaria.sacar(1000));
    }

    @Test
    public void transferirTest() {
        ContaBancaria contaDestino = new ContaBancaria("456", "henrique");
        boolean condition = contaBancaria.sacar(100);
        assertTrue(condition);
        assertTrue(contaBancaria.transferir(contaDestino, 100));
    }

    @Test
    public void aplicarJurosTest() {
        contaBancaria.aplicarJuros();
        assertEquals(2500, contaBancaria.getSaldo());
    }

    @Test
    public void alterarTitularTest() {
        assertFalse(contaBancaria.alterarTitular(null));
        assertFalse(contaBancaria.alterarTitular(""));
        assertTrue(contaBancaria.alterarTitular("maria"));
    }
}
