package com.irontech.phbchamp.enums;

public enum StatusCamp {
	
	EM_ANDAMENTO(1, "Em Andamento"),
    FINALIZADO(2, "Finalizado");
    
    private String nome;
    private Integer valor;

    public String getNome() {
        return nome;
    }

    public Integer getValor() {
        return valor;
    }
    
    

    private StatusCamp(Integer valor, String nome) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
