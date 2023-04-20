/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

import Pessoa.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Mundo {
    
    public int[][] mapaFisico = new int[30][60];
    public String[][] mapaDados = new String[30][60];
    private ArrayList<Pessoa> pessoasDoMundo = new ArrayList<>();
    
    
    
    public void gerarMatrizMundo(){
        
        // preenche a primeira e última coluna com 1
        for (int i = 0; i < 30; i++) {
            mapaFisico[i][0] = 1;
            mapaFisico[i][59] = 1;
            mapaDados[i][0] = "1";
            mapaDados[i][59] = "1";
        }

        // preenche a primeira e última linha com 1
        for (int i = 0; i < 60; i++) {
            mapaFisico[0][i] = 1;
            mapaFisico[29][i] = 1;
            mapaDados[0][i] = "1";
            mapaDados[29][i] = "1";
        }

        // preenche o interior da matriz com 0
        for (int i = 1; i < 29; i++) {
            for (int j = 1; j < 59; j++) {
                mapaFisico[i][j] = 0;
                mapaDados[i][j] = "0";
            }
        }
    }
    public void gerarPessoasMundo(){
        for(int i = 0; i < 100; i++){
            Pessoa pessoaNova = new Pessoa();
            pessoasDoMundo.add(pessoaNova);
            System.out.println("Pessoa add");
        }
        System.out.println(pessoasDoMundo.size());
    }
    public void desenhaMundoConsole(){
        
        for(int i = 0; i < mapaFisico.length; i++){
            for(int j = 0; j < mapaFisico[i].length; j++){
                
                switch(mapaFisico[i][j]){
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
    public void atualizaPessoasNosMapas(Pessoa pessoa){
        
        int coordenadaAtualX = pessoa.getCoordenadaAtualX();
        int coordenadaAtualY = pessoa.getCoordenadaAtualY();
        
        int coordenadaAntigaX = pessoa.getCoordenadaAntigaX();
        int coordenadaAntigaY = pessoa.getCoordenadaAntigaY();
           
        int numeroDaCor = pessoa.getNumeroDaCor();
        
        mapaFisico[coordenadaAtualY][coordenadaAtualX] = numeroDaCor;
        mapaFisico[coordenadaAntigaY][coordenadaAntigaX] = 0;
        
        String whatsAppID = pessoa.getWhatsAppID();
        
        mapaDados[coordenadaAtualY][coordenadaAtualX] = whatsAppID;
        mapaDados[coordenadaAntigaY][coordenadaAntigaX] = "0";
    }
    public void movimentaPessoas(){       
        
        for(Pessoa pessoa: pessoasDoMundo){
            pessoa.mover();  
            atualizaPessoasNosMapas(pessoa);            
        }
        
    }
    public void verificarEncontroDePessoas(Pessoa pessoa){
  
    }   
    
    public void animacaoMundo(){
        
        while(true){
            
            desenhaMundoConsole();
            movimentaPessoas();
            
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
    }
    
    public Mundo(){
        this.gerarMatrizMundo();    
        this.gerarPessoasMundo();
        //TODO adicionar todas as classes que irao compor a classe mundo  
    }

}
