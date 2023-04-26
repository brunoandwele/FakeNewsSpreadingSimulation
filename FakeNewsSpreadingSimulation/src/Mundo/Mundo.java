/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

import Pessoa.Pessoa;
import SituacaoPessoa.PessoaBemInformada;
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
    public ArrayList<ArrayList<ArrayList<String>>> mapaDados;
    private ArrayList<Pessoa> pessoasDoMundo = new ArrayList<>();
    private int countPessoasSemEfeitos, countPessoasBemInformadas, countPessoasMalInformadas, countPessoasImunes;
    private double tempoTotal = 0;
    
    public Mundo(){
        this.gerarMatrizMundo();   
        this.gerarMatrizDados();
        this.gerarPessoasMundo();
    }
    
    
    
    public void gerarMatrizMundo(){
        
        // preenche a primeira e última coluna com 1
        for (int i = 0; i < 30; i++) {
            mapaFisico[i][0] = 1;
            mapaFisico[i][59] = 1;
//            mapaDados[i][0] = "1";
//            mapaDados[i][59] = "1";
        }

        // preenche a primeira e última linha com 1
        for (int i = 0; i < 60; i++) {
            mapaFisico[0][i] = 1;
            mapaFisico[29][i] = 1;
//            mapaDados[0][i] = "1";
//            mapaDados[29][i] = "1";
        }

        // preenche o interior da matriz com 0
        for (int i = 1; i < 29; i++) {
            for (int j = 1; j < 59; j++) {
                mapaFisico[i][j] = 0;
//                mapaDados[i][j] = "0";
            }
        }
    }
    public void gerarMatrizDados(){
        
        mapaDados = new ArrayList<>();
        
        for(int i = 0;i < 30; i++){
            
            mapaDados.add(new ArrayList<ArrayList<String>>());
            
            for(int j = 0;j < 60; j++){
                mapaDados.get(i).add(new ArrayList<String>());
            }
            
            mapaDados.get(i).trimToSize();
        }
        
        mapaDados.trimToSize();
        
    }
    public void mostrarQuantidadeDePessoasPorTipo(){
        
        countPessoasSemEfeitos = 0;
        countPessoasMalInformadas = 0; 
        countPessoasBemInformadas = 0;
        countPessoasImunes = 0;
        
        for(Pessoa pessoa: pessoasDoMundo){
            
            int numeroDaCor = pessoa.getNumeroDaCor();
                
                switch(numeroDaCor){
                    
                    case 20 -> {
                        countPessoasSemEfeitos++;
                    }
                    case 21 -> {
                        countPessoasMalInformadas++;
                    }
                    case 22 -> {
                        countPessoasBemInformadas++;
                    }
                    case 23 -> {
                        countPessoasImunes++;
                    }   
                }
                
            
        }
        System.out.println("###########################");
        System.out.println("Pessoas sem efeitos:    " + countPessoasSemEfeitos);
        System.out.println("Pessoas MAL informadas: " + countPessoasMalInformadas);
        System.out.println("Pessoas BEM informadas: " + countPessoasBemInformadas);
        System.out.println("Pessoas imunes:         " + countPessoasImunes);
        System.out.println("###########################");
        System.out.println("");
    }
    public void desenhaMundoConsole(){
        
        for(int i = 0; i < mapaFisico.length; i++){
            for(int j = 0; j < mapaFisico[i].length; j++){
                
                switch(mapaFisico[i][j]){
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("\033[46m \033[0m");
                        break;
                    case 20:
                        System.out.print("\033[44m \033[0m");
                        break;
                    case 21:
                        System.out.print("\033[41m \033[0m");
                        break;
                    case 22:
                        System.out.print("\033[42m \033[0m");
                        break;
                    case 23:
                        System.out.print("\033[43m \033[0m");
                        break;
                }
                    
            }
            System.out.println();
              
        }
        System.out.println();
        
    }
    public void animacaoMundo(){
        
        while(true){
            System.out.println("Tempo total: " + tempoTotal);
            mostrarQuantidadeDePessoasPorTipo();
            desenhaMundoConsole();
            movimentaPessoas();
            verificarEncontroPessoas();
  
            try{
                Thread.sleep(500);
                tempoTotal+=0.5;
            }
            catch(Exception e){
                e.printStackTrace();
            }     
        }   
    }
    
    public void gerarPessoasMundo(){
       
        int numeroDePessoas = 50;
        
        
        for(int i = 0; i < numeroDePessoas; i++){
            Pessoa pessoaNova = new Pessoa();
            pessoasDoMundo.add(pessoaNova);
        }
        
    }
    public void atualizaPessoasNosMapas(Pessoa pessoa){
        
        int coordenadaAtualX = pessoa.getCoordenadaAtualX();
        int coordenadaAtualY = pessoa.getCoordenadaAtualY();
        
        int coordenadaAntigaX = pessoa.getCoordenadaAntigaX();
        int coordenadaAntigaY = pessoa.getCoordenadaAntigaY();
           
        int numeroDaCor = pessoa.getNumeroDaCor();
        
        //Atualiza no mapa das cores (Matriz de inteiros)
        mapaFisico[coordenadaAtualY][coordenadaAtualX] = numeroDaCor;
        mapaFisico[coordenadaAntigaY][coordenadaAntigaX] = 0;
        
        String whatsAppID = pessoa.getWhatsAppID();
              
        //Atualiza no mapa dos Dados (Matriz de ArrayList de ArrayList de ArrayList de String)
        mapaDados.get(coordenadaAtualY).get(coordenadaAtualX).add(whatsAppID);
        mapaDados.get(coordenadaAntigaY).get(coordenadaAntigaX).remove(whatsAppID);

    
    }
    public void movimentaPessoas(){       
        
        for(Pessoa pessoa: pessoasDoMundo){
            pessoa.mover();  
            atualizaPessoasNosMapas(pessoa);            
        }
        
    }
    public void verificarEncontroPessoas(){
   
        for(Pessoa pessoa:pessoasDoMundo){
            
            ArrayList<String> contatos = pessoa.getContatos();
            
            if (contatos.size()>1){
//                mandarFakeNewsParaContatosComentado(pessoa);
                mandarFakeNewsParaContatos(pessoa);
            }
            
            
            int coordenadaPessoaX = pessoa.getCoordenadaAtualX();
            int coordenadaPessoaY = pessoa.getCoordenadaAtualY();
            
            int posicaoEsquerda = this.mapaFisico[coordenadaPessoaY][coordenadaPessoaX-1];
            int posicaoDireita = this.mapaFisico[coordenadaPessoaY][coordenadaPessoaX+1];
            int posicaoCima = this.mapaFisico[coordenadaPessoaY-1][coordenadaPessoaX];
            int posicaoBaixo = this.mapaFisico[coordenadaPessoaY+1][coordenadaPessoaX];
            
            //Verifica se tem alguem na esquerda, direita, embaixo, em cima ou na mesma posicao
            
            ArrayList<String> pessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY).get(coordenadaPessoaX);
            
            if(pessoasNessasCoordenadas.size()>1){
                
                for(String whatsAppPessoas:pessoasNessasCoordenadas){
                    String whatsAppIDPessoaNova = whatsAppPessoas;
                    pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);          
                }
 
            }
            if(posicaoEsquerda != 0 && posicaoEsquerda != 1){
                
                pessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY).get(coordenadaPessoaX-1);

                for(String whatsAppPessoas:pessoasNessasCoordenadas){
                    String whatsAppIDPessoaNova = whatsAppPessoas;
                    pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);          
                }
 
            }
            if(posicaoDireita != 0 && posicaoDireita != 1){
                
                pessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY).get(coordenadaPessoaX+1);

                for(String whatsAppPessoas:pessoasNessasCoordenadas){
                    String whatsAppIDPessoaNova = whatsAppPessoas;
                    pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);
                }
              
            }
            if(posicaoCima != 0 && posicaoCima != 1){
                
                pessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY-1).get(coordenadaPessoaX);

                for(String whatsAppPessoas:pessoasNessasCoordenadas){
                    String whatsAppIDPessoaNova = whatsAppPessoas;
                    pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);
                }
  
            }
            if(posicaoBaixo != 0 && posicaoBaixo != 1){
                
                pessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY+1).get(coordenadaPessoaX);

                for(String whatsAppPessoas:pessoasNessasCoordenadas){
                    String whatsAppIDPessoaNova = whatsAppPessoas;
                    pessoa.adicionarWhatsApp(whatsAppIDPessoaNova);
                }
              
            }
          
        }
        
    }
    public void transformarParaPessoaMalInformada(Pessoa pessoa){
        
        int indicePessoa = pessoasDoMundo.indexOf(pessoa);
        PessoaMalInformada pessoaMalInformada = new PessoaMalInformada(pessoa);            
        pessoasDoMundo.set(indicePessoa,pessoaMalInformada);
 
    }
    public void transformarParaPessoaBemInformada(Pessoa pessoa){
        
        int indicePessoa = pessoasDoMundo.indexOf(pessoa);
        PessoaBemInformada pessoaBemInformada = new PessoaBemInformada(pessoa);            
        pessoasDoMundo.set(indicePessoa,pessoaBemInformada);
 
    }
    public void mandarRealNewsParaContatos(Pessoa pessoaSabia){

        ArrayList<String> contatosPessoaSabia = pessoaSabia.getContatos();

        for (String contatoRegistrado:contatosPessoaSabia){
            
            for(Pessoa possivelContato:pessoasDoMundo){
                
                String whatsAppIDPossivelContato = possivelContato.getWhatsAppID();
                
                if(whatsAppIDPossivelContato.equals(contatoRegistrado)){        
                    transformarParaPessoaBemInformada(possivelContato);
                }
            }  
        }
        transformarParaPessoaBemInformada(pessoaSabia);
    }
    public void mandarFakeNewsParaContatos(Pessoa pessoaInfectada){

        ArrayList<String> contatosPessoaInfectada = pessoaInfectada.getContatos();

        for (String contatoRegistrado:contatosPessoaInfectada){
            
            for(Pessoa possivelContato:pessoasDoMundo){
                
                String whatsAppIDPossivelContato = possivelContato.getWhatsAppID();
                
                if(whatsAppIDPossivelContato.equals(contatoRegistrado)){        
                    transformarParaPessoaMalInformada(possivelContato);
                }
            }  
        }
        transformarParaPessoaMalInformada(pessoaInfectada);
    }
    public void mandarFakeNewsParaContatosComentado(Pessoa pessoaInfectada){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ArrayList<String> contatosPessoaInfectada = pessoaInfectada.getContatos();
        String id = pessoaInfectada.getWhatsAppID();
        System.out.println("Contatos - "+ id);
        for(String contato1:contatosPessoaInfectada){
            System.out.print(contato1 +" / ");
        }
        System.out.println("");
        System.out.println("##########");
        for (String contatoRegistrado:contatosPessoaInfectada){
            
            for(Pessoa possivelContato:pessoasDoMundo){
                
                String whatsAppIDPossivelContato = possivelContato.getWhatsAppID();
                
                if(whatsAppIDPossivelContato.equals(contatoRegistrado)){
                    System.out.println("Comparacao: " + whatsAppIDPossivelContato + "//" + contatoRegistrado);
                    int index2 = pessoasDoMundo.indexOf(possivelContato);
                    String id2 = pessoasDoMundo.get(index2).getWhatsAppID();
                    System.out.println("Classe do contato anterior a transformacao: " + id2+ " - " + pessoasDoMundo.get(index2).getClass());
                    transformarParaPessoaMalInformada(possivelContato);
                    ArrayList<String> contatos2 = pessoasDoMundo.get(index2).getContatos();
                    id2 = pessoasDoMundo.get(index2).getWhatsAppID();
                    System.out.println("Classe do contato apos transformacao: " + id2+ " - " + pessoasDoMundo.get(index2).getClass());
                    System.out.println("Contatos - " + id2);
                    for(String contato2:contatos2){
                        System.out.print(contato2 +" / ");
                    }
                    System.out.println("");
                    System.out.println("-----------");
                }
            }  
        }
        
        int index1 = pessoasDoMundo.indexOf(pessoaInfectada);
        System.out.println("Classe da pessoa infectada anterior a transformacao: " + pessoasDoMundo.get(index1).getClass());
        transformarParaPessoaMalInformada(pessoaInfectada);
        
        System.out.println("Classe da pessoa infectada apos transformacao: " + pessoasDoMundo.get(index1).getClass());
        String teste = ip.nextLine();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

}
