package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBancos implements Desconto {

	@Override
	public BigDecimal aplicarDescontpSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(precoOriginal.multiply(new BigDecimal("0.3")));
	}

	@Override
	public String getDescricao() {
		return "Desconto banco";
	}

}
