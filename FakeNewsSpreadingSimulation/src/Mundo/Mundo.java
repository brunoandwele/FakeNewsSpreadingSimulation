/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

import Pessoa.Pessoa;
import SituacaoPessoa.PessoaMalInformada;
import java.util.ArrayList;

//Apagar depois
import java.util.Scanner;
//Apagar depois

/**
 *
 * @author bruno
 */
public class Mundo {
    
    //Apagar depois
    Scanner ip = new Scanner(System.in);
    //Apagar depois
    
    public int[][] mapaFisico = new int[30][60];
    public String[][] mapaDados = new String[30][60];
    private ArrayList<Pessoa> pessoasDoMundo = new ArrayList<>();
    

    public ArrayList<Pessoa> getPessoasDoMundo() {
        return pessoasDoMundo;
    }
    
    
    
    
    public Mundo(){
        this.gerarMatrizMundo();    
        this.gerarPessoasMundo();
        //TODO adicionar todas as classes que irao compor a classe mundo  
    }
    
    
    
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
       
        int numeroDePessoas = 40;
        
        
        for(int i = 0; i < numeroDePessoas; i++){
            Pessoa pessoaNova = new Pessoa();
            pessoasDoMundo.add(pessoaNova);
        }
        
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
                    case 21:
                        System.out.print("\033[45m \033[0m");
                        break;
                    case 22:
                        System.out.print("\033[46m \033[0m");
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
    public void verificarEncontroPessoas(){
        
        for(Pessoa pessoa:pessoasDoMundo){
            
            int coordenadaPessoaX = pessoa.getCoordenadaAtualX();
            int coordenadaPessoaY = pessoa.getCoordenadaAtualY();
            
            int posicaoEsquerda = this.mapaFisico[coordenadaPessoaY][coordenadaPessoaX-1];
            int posicaoDireita = this.mapaFisico[coordenadaPessoaY][coordenadaPessoaX+1];
            int posicaoCima = this.mapaFisico[coordenadaPessoaY-1][coordenadaPessoaX];
            int posicaoBaixo = this.mapaFisico[coordenadaPessoaY+1][coordenadaPessoaX];
            
            
            
            if(posicaoEsquerda != 0 && posicaoEsquerda != 1){
                String whatsAppIDPessoaNova = this.mapaDados[coordenadaPessoaY][coordenadaPessoaX-1];
                pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);                
                
            }
            if(posicaoDireita != 0 && posicaoDireita != 1){
                String whatsAppIDPessoaNova = this.mapaDados[coordenadaPessoaY][coordenadaPessoaX+1];
                pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);
              
            }
            if(posicaoCima != 0 && posicaoCima != 1){
                String whatsAppIDPessoaNova = this.mapaDados[coordenadaPessoaY-1][coordenadaPessoaX];
                pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);
                
            }
            if(posicaoBaixo != 0 && posicaoBaixo != 1){
                String whatsAppIDPessoaNova = this.mapaDados[coordenadaPessoaY+1][coordenadaPessoaX];
                pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);
                
            }
          
        }
        
    }
    public void animacaoMundo(){
        
        while(true){
            
            desenhaMundoConsole();
            movimentaPessoas();
            verificarEncontroPessoas();
            
            
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
    }
    
    public void mandarFakeNewsParaContatos(Pessoa pessoaInfectada){
        
        ArrayList<String> contatosPessoaInfectada = pessoaInfectada.getContatos();
        
        for (String contatoRegistrado:contatosPessoaInfectada){
            
            for(Pessoa possivelContato:pessoasDoMundo){
                String whatsAppIDPossivelContato = possivelContato.getWhatsAppID();
                
                if(whatsAppIDPossivelContato.equals(contatoRegistrado)){

                    int indicePessoaEcontrada = pessoasDoMundo.indexOf(possivelContato);
                    
                    PessoaMalInformada contatoMalInformado = new PessoaMalInformada(possivelContato);
                    
                    pessoasDoMundo.set(indicePessoaEcontrada,contatoMalInformado);   
                }
            }  
        }
        
        int indicePessoaInfectada = pessoasDoMundo.indexOf(pessoaInfectada);
        PessoaMalInformada PessoaInfectadaMalInformada = new PessoaMalInformada(pessoaInfectada);
                    
        pessoasDoMundo.set(indicePessoaInfectada,PessoaInfectadaMalInformada);
        
    }
    

}
