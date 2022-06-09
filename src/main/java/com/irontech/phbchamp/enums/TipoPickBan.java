/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.irontech.phbchamp.enums;

/**
 *
 * @author andreigor
 */
public enum TipoPickBan {

    PICK("PICK"),
    BAN("BAN");

    private String nome;

    public String getNome() {
        return nome;
    }

    private TipoPickBan(String nome) {
        this.nome = nome;

    }

}
