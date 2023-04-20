/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

import Pessoa.Pessoa;

/**
 *
 * @author bruno
 */
public class Mundo {
    
    public int[][] mapa = new int[30][60];
    
    private Pessoa pessoa = new Pessoa();
    
    public void geraMatrizMundo(){
        
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
    
    public void desenhaMundoConsole(){
        
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[i].length; j++){
                
                switch(mapa[i][j]){
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("\033[47m \033[0m");
                        break;
                    case 20:
                        System.out.print("\033[44m \033[0m");
                        break;
                }
                    
            }
            System.out.println();
              
        }
        System.out.println();
    }
    
    public void atualizaPosicaoPessoas(){
        
        pessoa.mover();
        
        int coordenadaAtualX = pessoa.getCoordenadaAtualX();
        int coordenadaAtualY = pessoa.getCoordenadaAtualY();
        
        int coordenadaAntigaX = pessoa.getCoordenadaAntigaX();
        int coordenadaAntigaY = pessoa.getCoordenadaAntigaY();
        
        int numeroDaCor = pessoa.getNumeroDaCor();
        
        mapa[coordenadaAtualY][coordenadaAtualX] = numeroDaCor;
        mapa[coordenadaAntigaY][coordenadaAntigaX] = 0;
        
    }
    
    public Mundo(){
        
        this.geraMatrizMundo();
        
        //TODO adicionar todas as classes que irao compor a classe mundo
       
        
    }

}
