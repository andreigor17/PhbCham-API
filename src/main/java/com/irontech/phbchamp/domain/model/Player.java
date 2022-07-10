package com.irontech.phbchamp.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.irontech.phbchamp.enums.Funcoes;
import com.irontech.phbchamp.generic.ModeloGenerico;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Player extends ModeloGenerico implements Serializable {

    private String nome;
    @Column(name = "sobrenome")
    private String sobreNome;
    private String nick;
    @Column(name = "possui_time", columnDefinition = "boolean default false")
    private boolean possuiTime = false;
    @Column(columnDefinition = "boolean default false")
    private boolean capitao;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private Funcoes funcao;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Estatisticas> estatisticas;
    private String urlSteam;
    private String steamID;
    @ManyToMany
    private List<Jogo> jogos;

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

    public List<Estatisticas> getEstatisticas() {
        return estatisticas;
    }

    public void setEstatisticas(List<Estatisticas> estatisticas) {
        this.estatisticas = estatisticas;
    }

    public String getUrlSteam() {
        return urlSteam;
    }

    public void setUrlSteam(String urlSteam) {
        this.urlSteam = urlSteam;
    }

    public String getSteamID() {
        return steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

}
