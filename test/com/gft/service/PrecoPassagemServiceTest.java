package com.gft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gft.model.Passageiro;
import com.gft.model.TipoPassageiro;
import com.gft.model.Voo;

public class PrecoPassagemServiceTest {

	private PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		precoPassagemService  = new PrecoPassagemService();
	}
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado,valor,0.0001);
	}
	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo","Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo,  90.0);
	}
	@Test
	public void deveCalcularValorPassagemParaPasseiroGold_ComValorAcimaDosLimites() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo","Rio de Janeiro", 600.0);
		assertValorPassagem(passageiro, voo,  510.0);
	}
	@Test
	public void deveCalcularValorPassageiroSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo","Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo,  94.0);
	}
	
	public void deveCalcularValorPassagemParaPasssageiroSilver_comValorAcimaDoLimite() throws Exception{
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo","Rio de Janeiro", 800.0);
		assertValorPassagem(passageiro, voo,  720.0);
	}
	
}
