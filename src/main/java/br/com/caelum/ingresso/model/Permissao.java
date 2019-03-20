package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissao implements GrantedAuthority {

	private static final long serialVersionUID = 6221520864288241818L;

	@Id
	private String nome;

	public Permissao(String nome) {
		this.nome = nome;
	}

	/**
	 * @deprecated hibernate only
	 */
	public Permissao() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return nome;
	}
	
}
