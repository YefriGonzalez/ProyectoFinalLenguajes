package com.mycompany.proyectofinallenguajes.analizadorLexico;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author yefri
 */
public class Automata {

    private JTextArea textoEntrada;
    private int[][] AutomataMatriz;
    private final int[] ESTADOS_ACEPTACION = {2, 3, 10, 11};
    private String[] lineas;
    private String[] palabras;
    private int fila = 1;
    private int columna = 1;
    private int estadoActual = 0;
    private ArrayList<Token> tokens = new ArrayList<>();
    private ArrayList<Error> errores = new ArrayList<>();
    private Tipo[] tipos = Tipo.values();
    private PalabrasReservadas[] reservadas=PalabrasReservadas.values();

    public Automata(JTextArea textoEntrada) {
        this.textoEntrada = textoEntrada;
        inicializarMatriz();
    }

    public void inicializarMatriz() {
        int filas = 11;
        int columnas = 7;
        //A=1 B=2 C=3 D=4 E=5 F=6 g=7 h=8 i=9 j=10 k=11 error=-1
        AutomataMatriz = new int[filas][columnas];

        //Posiciones del automata
        AutomataMatriz[0][0] = 2;
        AutomataMatriz[0][1] = 3;
        AutomataMatriz[0][2] = 4;
        AutomataMatriz[0][3] = 6;
        AutomataMatriz[0][4] = 11;
        AutomataMatriz[0][5] = 5;
        AutomataMatriz[0][6] = 2;

        AutomataMatriz[1][0] = 2;
        AutomataMatriz[1][1] = 2;
        AutomataMatriz[1][2] = -1;
        AutomataMatriz[1][3] = -1;
        AutomataMatriz[1][4] = -1;
        AutomataMatriz[1][5] = 2;
        AutomataMatriz[1][6] = 2;

        AutomataMatriz[2][0] = -1;
        AutomataMatriz[2][1] = 3;
        AutomataMatriz[2][2] = -1;
        AutomataMatriz[2][3] = -1;
        AutomataMatriz[2][4] = -1;
        AutomataMatriz[2][5] = -1;
        AutomataMatriz[2][6] = -1;

        AutomataMatriz[3][0] = 7;
        AutomataMatriz[3][1] = 7;
        AutomataMatriz[3][2] = -1;
        AutomataMatriz[3][3] = 7;
        AutomataMatriz[3][4] = 7;
        AutomataMatriz[3][5] = 7;
        AutomataMatriz[3][6] = 7;

        AutomataMatriz[4][0] = -1;
        AutomataMatriz[4][1] = 3;
        AutomataMatriz[4][2] = -1;
        AutomataMatriz[4][3] = -1;
        AutomataMatriz[4][4] = -1;
        AutomataMatriz[4][5] = -1;
        AutomataMatriz[4][6] = -1;

        AutomataMatriz[5][0] = -1;
        AutomataMatriz[5][1] = -1;
        AutomataMatriz[5][2] = -1;
        AutomataMatriz[5][3] = 8;
        AutomataMatriz[5][4] = -1;
        AutomataMatriz[5][5] = -1;
        AutomataMatriz[5][6] = -1;

        AutomataMatriz[6][0] = 7;
        AutomataMatriz[6][1] = 7;
        AutomataMatriz[6][2] = 9;
        AutomataMatriz[6][3] = 7;
        AutomataMatriz[6][4] = 7;
        AutomataMatriz[6][5] = 7;
        AutomataMatriz[6][6] = 7;

        AutomataMatriz[7][0] = 10;
        AutomataMatriz[7][1] = 10;
        AutomataMatriz[7][2] = 10;
        AutomataMatriz[7][3] = 10;
        AutomataMatriz[7][4] = 10;
        AutomataMatriz[7][5] = 10;
        AutomataMatriz[7][6] = 10;

        AutomataMatriz[8][0] = -1;
        AutomataMatriz[8][1] = -1;
        AutomataMatriz[8][2] = -1;
        AutomataMatriz[8][3] = -1;
        AutomataMatriz[8][4] = -1;
        AutomataMatriz[8][5] = -1;
        AutomataMatriz[8][6] = -1;

        AutomataMatriz[9][0] = 10;
        AutomataMatriz[9][1] = 10;
        AutomataMatriz[9][2] = 10;
        AutomataMatriz[9][3] = 10;
        AutomataMatriz[9][4] = 10;
        AutomataMatriz[9][5] = 10;
        AutomataMatriz[9][6] = 10;

        AutomataMatriz[10][0] = -1;
        AutomataMatriz[10][1] = -1;
        AutomataMatriz[10][2] = -1;
        AutomataMatriz[10][3] = -1;
        AutomataMatriz[10][4] = 11;
        AutomataMatriz[10][5] = -1;
        AutomataMatriz[10][6] = -1;
    }

    public void leerTextArea() {
        String texto = textoEntrada.getText();
        lineas = texto.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i].charAt(0) == '/' && lineas[i].charAt(1) == '/') {
                tokens.add(new Token(lineas[i], tipos[3].getTipo(), fila, columna));
            } else {
                palabras = lineas[i].split(" ");
                for (int j = 0; j < palabras.length; j++) {
                    analizarPalabra(palabras[j]);
                    columna++;
                }
            }
            columna = 0;
            fila++;
        }
    }

    private void analizarPalabra(String token) {
        String opcion = "";
        estadoActual = 0;
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < reservadas.length; j++) {
                if(palabras[i].equals(reservadas[j].getTipo())){
                    tokens.add(new Token(palabras[j],reservadas[5].getTipo(), fila, columna));
                }
            }
        }
        
        char[] cadenaPalabra = token.toCharArray();
        for (int i = 0; i < token.length(); i++) {
            columna++;
            if (Character.isAlphabetic(cadenaPalabra[i])) {
                estadoActual = AutomataMatriz[estadoActual][0];
            }else {
                if ((Character.isDigit(cadenaPalabra[i]) | cadenaPalabra[i]=='-')&& estadoActual==0) {
                    estadoActual = AutomataMatriz[estadoActual][1];
                }else {
                
                }
            }
        }
    }
}
