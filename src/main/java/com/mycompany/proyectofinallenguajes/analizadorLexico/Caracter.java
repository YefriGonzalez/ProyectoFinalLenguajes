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
public enum Caracter {
    IGUAL('='),
    MENORQUE('<'),
    MAYORQUE('>'),
    SUMA('+'),
    RESTA('-'),
    MULTIPLICACION('*'),
    DIVISION('/'),
    MODULO('%'),
    PUNTO('.'),
    COMA(','),
    PUNTO_COMA(';'),
    DOS_PUNTOS(':'),
    CORCHETE_IZQUIERDO('['),
    CORCHETE_DERECHO(']'),
    PARENTESIS_IZQUIERDO('('),
    PARENTESIS_DERECHO(')'),
    LLAVE_IZQUIERDA('{'),
    LLAVE_DERECHA('}'),
    COMILLA_SIMPLE('\'');
   
    
    char tipo;
    
    private Caracter(char tipo) {
        this.tipo = tipo;
    }

    public char getTipo() {
        return this.tipo;
    }

}
