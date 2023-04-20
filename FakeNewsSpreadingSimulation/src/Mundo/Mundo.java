/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

/**
 *
 * @author bruno
 */
public class Mundo {
    
    public int[][] mapa = new int[30][60];
    
    public void criaMundo(){
        
        // preenche a primeira e última coluna com 1
        for (int i = 0; i < 30; i++) {
            mapa[i][0] = 1;
            mapa[i][59] = 1;
        }

        // preenche a primeira e última linha com 1
        for (int i = 0; i < 60; i++) {
            mapa[0][i] = 1;
            mapa[29][i] = 1;
        }

        // preenche o interior da matriz com 0
        for (int i = 1; i < 29; i++) {
            for (int j = 1; j < 59; j++) {
                mapa[i][j] = 0;
            }
        }
    }
    
    public void desenhaMundo(){
        //TODO criar funcao que imprime o mundo
    }
    
    public Mundo(){
        this.criaMundo();
        
        //TODO adicionar todas as classes que irao compor a classe mundo
       
        
    }

}
