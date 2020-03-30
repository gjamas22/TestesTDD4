package com.gft.service;

import com.gft.model.Passageiro;
import com.gft.model.TipoPassageiro;
import com.gft.model.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
//		if (passageiro.getTipo().equals(TipoPassageiro.GOLD)) {
//			if (voo.getPreco() > 500)
//				return voo.getPreco() * 0.85;
//			return voo.getPreco() * 0.9;
//	} else if (passageiro.getTipo().equals(TipoPassageiro.SILVER)) {
//			if (voo.getPreco() > 700.0)
//				return voo.getPreco() *0.9;
//			return voo.getPreco() * 0.94;	
//		}
//		throw new TipoPassageiroInvalidoException();
		return passageiro.getTipo().getCalculadora().calcular(voo);
		
	}

}
