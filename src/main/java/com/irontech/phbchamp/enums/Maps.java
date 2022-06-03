package com.irontech.phbchamp.enums;

public enum Maps {

    MIRAGE(1, "Mirage"),
    DUST2(2, "Dust2"),
    INFERNO(3, "Inferno"),
    OVERPASS(4, "Overpass"),
    NUKE(5, "Nuke"),
    VERTIGO(6, "Vertigo"),
    ANCIENT(7, "Ancient");

    private String nome;
    private Integer valor;

    public String getNome() {
        return nome;
    }

    public Integer getValor() {
        return valor;
    }

    private Maps(Integer valor, String nome) {
        this.nome = nome;
        this.valor = valor;
    }

}
