/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinallenguajes.analizadorLexico;

/**
 *
 * @author yefri
 */
public enum PalabrasReservadas {
    ESCRIBIR("ESCRIBIR"),
    FIN("FIN"),
    REPETIR("REPETIR"),
    INICIAR("INICIAR"),
    SI("SI"),
    VERDADERO("VERDADERO"),
    FALSO("FALSO"),
    ENTONCES("ENTONCES");

    String tipo;
    private PalabrasReservadas(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }
}
