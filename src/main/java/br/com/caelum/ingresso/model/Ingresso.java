package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	private BigDecimal preco;
	
	@ManyToOne
	private Lugar lugar;
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoIngresso;
	
	public Ingresso() {
	}
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoIngresso, Lugar lugar) {
		this.sessao = sessao;
		this.preco = tipoIngresso.aplicaDesconto(sessao.getPreco());
		this.lugar = lugar;
		this.tipoIngresso = tipoIngresso;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(TipoDeIngresso tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

}
