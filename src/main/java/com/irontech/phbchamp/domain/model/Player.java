package com.irontech.phbchamp.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.irontech.phbchamp.enums.Funcoes;
import com.irontech.phbchamp.generic.ModeloGenerico;

@Entity
public class Player extends ModeloGenerico implements Serializable {

	private String nome;
	@Column(name = "sobrenome")
    private String sobreNome;
    private String nick;
    @Column(name = "possui_time" ,columnDefinition = "boolean default false")
    private boolean possuiTime = false;
    @Column(columnDefinition = "boolean default false")
    private boolean capitao;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private Funcoes funcao;

   
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Funcoes getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcoes funcao) {
		this.funcao = funcao;
	}
	
	
	

}
