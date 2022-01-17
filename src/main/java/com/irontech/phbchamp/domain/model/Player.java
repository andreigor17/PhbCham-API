package com.irontech.phbchamp.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(name = "sobrenome")
    private String sobreNome;
    private String nick;
    @Column(name = "possui_time" ,columnDefinition = "boolean default false")
    private boolean possuiTime = false;
    @Column(columnDefinition = "boolean default false")
    private boolean capitao;

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public boolean isPossuiTime() {
		return possuiTime;
	}
	public void setPossuiTime(boolean possuiTime) {
		this.possuiTime = possuiTime;
	}
	public boolean isCapitao() {
		return capitao;
	}
	public void setCapitao(boolean capitao) {
		this.capitao = capitao;

	}
	@Override
	public int hashCode() {
		return Objects.hash(capitao, id, nick, nome, possuiTime, sobreNome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return capitao == other.capitao && Objects.equals(id, other.id) && Objects.equals(nick, other.nick)
				&& Objects.equals(nome, other.nome) && possuiTime == other.possuiTime
				&& Objects.equals(sobreNome, other.sobreNome);
	}
	

}
