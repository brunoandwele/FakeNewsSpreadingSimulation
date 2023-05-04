/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

import EstruturasMundo.EstruturasMundo;
import IAs.IADestruidoraFakeNews;
import IAs.IAGeradoraFakeNews;
import MeioComunicacaoConfiavel.MeioComunicacaoConfiavel;
import Pessoa.Pessoa;
import SituacaoPessoa.PessoaBemInformada;
import SituacaoPessoa.PessoaImune;
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
    
    private IAGeradoraFakeNews IAGeradoraFakeNews;
    private IADestruidoraFakeNews IADestruidoraFakeNews; 
    private MeioComunicacaoConfiavel MeioComunicacaoConfiavel;
    
    public Mundo(){   
        this.gerarEstruturas();
        this.gerarPessoasMundo();
        this.gerarMatrizDados();  
        this.gerarMatrizMundo();
        
    }
    
    public void gerarEstruturas(){
        
        IAGeradoraFakeNews = new IAGeradoraFakeNews(25,35,5,10);
        IADestruidoraFakeNews = new IADestruidoraFakeNews(10,20,20,25);
        MeioComunicacaoConfiavel = new MeioComunicacaoConfiavel(40,50,20,25);
         
    }
    
    public void colocarEstruturasMatriz(){
        InserirEstruturaMatriz(IAGeradoraFakeNews);
        InserirEstruturaMatriz(IADestruidoraFakeNews);
        InserirEstruturaMatriz(MeioComunicacaoConfiavel);
        
    }
    
    public void InserirEstruturaMatriz(EstruturasMundo estrutura){
        
        int xInicial = estrutura.getCoordenadasXInicial();
        int xFinal = estrutura.getCoordenadasXFinal();
        
        int yInicial = estrutura.getCoordenadasYInicial();
        int yFinal = estrutura.getCoordenadasYFinal();
 
        for(int i = yInicial; i < yFinal; i++){

            for(int j = xInicial; j < xFinal; j++){
                
                mapaFisico[i][j] = estrutura.getNumeroDaCor();
            
            }        
        }        
    }
    
    public void gerarMatrizMundo(){
        
        // preenche a primeira e última coluna com 1
        for (int i = 0; i < 30; i++) {
            mapaFisico[i][0] = 1;
            mapaFisico[i][59] = 1;
        }

        // preenche a primeira e última linha com 1
        for (int i = 0; i < 60; i++) {
            mapaFisico[0][i] = 1;
            mapaFisico[29][i] = 1;
        }

        // preenche o interior da matriz com 0
        for (int i = 1; i < 29; i++) {
            for (int j = 1; j < 59; j++) {
                mapaFisico[i][j] = 0;
            }
        }
        
        colocarEstruturasMatriz();
        
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
                        System.out.print("\033[44m \033[0m");
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
                    case 31:
                        System.out.print("\033[45m \033[0m");
                        break;
                    case 32:
                        System.out.print("\033[46m \033[0m");
                        break;
                    case 33:
                        System.out.print("\033[47m \033[0m");
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
            gerarMatrizMundo();
            movimentaPessoas();
            verificarEncontroComObjetos();
  
            try{
                Thread.sleep(50);
                tempoTotal+=0.5;
            }
            catch(Exception e){
                e.printStackTrace();
            }     
        }   
    }
    
    public void gerarPessoasMundo(){
       
        int numeroDePessoas = 100;
        
        
        for(int i = 0; i < numeroDePessoas; i++){
            Pessoa pessoaNova = new Pessoa(true);
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
        
        String whatsAppID = pessoa.getWhatsAppID();
              
        //Atualiza no mapa dos Dados (Matriz de ArrayList de ArrayList de ArrayList de String)
        mapaDados.get(coordenadaAtualY).get(coordenadaAtualX).add(whatsAppID);
        mapaDados.get(coordenadaAntigaY).get(coordenadaAntigaX).remove(whatsAppID);

    
    }
    public void movimentaPessoas(){       
        
        for(Pessoa pessoa: pessoasDoMundo){
            pessoa.mover();  
            atualizaPessoasNosMapas(pessoa);
            
            if (pessoa instanceof PessoaImune){
                verificarTempoPessoaImune((PessoaImune) pessoa);
            }
            
        }
        
    }
    
    public void verificarEncontroComObjetos(){
        
        for(Pessoa pessoa : pessoasDoMundo){
            verificarEncontroPessoas(pessoa);
        }
        for(Pessoa pessoa : pessoasDoMundo){
            verificarEncontroEstruturas(pessoa);
        }
        
    }
    public void verificarEncontroPessoas(Pessoa pessoa){

            int coordenadaPessoaX = pessoa.getCoordenadaAtualX();
            int coordenadaPessoaY = pessoa.getCoordenadaAtualY();
            ArrayList<String> listaPessoasNessasCoordenadas;
            
            //Verifica se tem alguem na esquerda, direita, embaixo, em cima ou na mesma posicao
            
            //Verifica na mesma posicao (coordenadas sao as mesmas)
            listaPessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY).get(coordenadaPessoaX);
            if(listaPessoasNessasCoordenadas.size()>1){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);   
                }
 
            }
            
            //Verifica na posicao a esquerda (coordenada X - 1)
            listaPessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY).get(coordenadaPessoaX-1);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
 
            }
            
            //Verifica na posicao a direita (coordenada X + 1)
            listaPessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY).get(coordenadaPessoaX+1);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
            }
            
            //Verifica na posicao a cima (coordenada Y - 1)
            listaPessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY-1).get(coordenadaPessoaX);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
            }
            
            //Verifica na posicao a baixo (coordenada Y + 1)
            listaPessoasNessasCoordenadas = mapaDados.get(coordenadaPessoaY+1).get(coordenadaPessoaX);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
            }
    }
    
    public void verificarEncontroEstruturas(Pessoa pessoa){
        
        int coordenadasX = pessoa.getCoordenadaAtualX();
        int coordenadasY = pessoa.getCoordenadaAtualY();
        
        int posicaoEsquerda = mapaFisico[coordenadasY][coordenadasX-1];
        int posicaoDireita = mapaFisico[coordenadasY][coordenadasX+1];
        int poaicaoCima = mapaFisico[coordenadasY-1][coordenadasX];
        int posicaoBaixo = mapaFisico[coordenadasY+1][coordenadasX];
        
        if(posicaoEsquerda == 31){
            mandarFakeNewsParaContatos(pessoa);
        }
        else if(posicaoEsquerda == 32){
            mandarRealNewsParaContatos(pessoa);
        }
        else if(posicaoEsquerda == 33){
            transformarParaPessoaImune(pessoa);
        }
        else if(posicaoDireita == 31){
            mandarFakeNewsParaContatos(pessoa);
        }
        else if(posicaoDireita == 32){
            mandarRealNewsParaContatos(pessoa);
        }
        else if(posicaoDireita == 33){
            transformarParaPessoaImune(pessoa);
        }
        else if(poaicaoCima == 31){
            mandarFakeNewsParaContatos(pessoa);
        }
        else if(poaicaoCima == 32){
            mandarRealNewsParaContatos(pessoa);
        }
        else if(poaicaoCima == 33){
            transformarParaPessoaImune(pessoa);
        }
        else if(posicaoBaixo == 31){
            mandarFakeNewsParaContatos(pessoa);
        }
        else if(posicaoBaixo == 32){
            mandarRealNewsParaContatos(pessoa);
        }
        else if(posicaoBaixo == 33){
            transformarParaPessoaImune(pessoa);
        }
              
        
    }
    
    public void transformarParaPessoaNormal(Pessoa pessoa){
        int indicePessoa = pessoasDoMundo.indexOf(pessoa);
        Pessoa pessoaNormal = new Pessoa (pessoa);        
        pessoasDoMundo.set(indicePessoa,pessoaNormal);
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
    public void transformarParaPessoaImune(Pessoa pessoa){
        
        if((pessoa instanceof PessoaImune) == false){
        
            int indicePessoa = pessoasDoMundo.indexOf(pessoa);
            PessoaImune pessoaImunizada = new PessoaImune(pessoa);
            pessoasDoMundo.set(indicePessoa,pessoaImunizada);
            
        }
 
    }
    public void mandarRealNewsParaContatos(Pessoa pessoaSabia){

        ArrayList<String> contatosPessoaInfectada = pessoaSabia.getContatos();

        for (String contatoRegistrado:contatosPessoaInfectada){
            
            for(Pessoa possivelContato:pessoasDoMundo){
                
                
                
                String whatsAppIDPossivelContato = possivelContato.getWhatsAppID();
                
                if(whatsAppIDPossivelContato.equals(contatoRegistrado)){    
                    
                    if(possivelContato instanceof PessoaImune){
                        continue;
                    }
                    
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
                    
                    if(possivelContato instanceof PessoaImune){
                        continue;
                    }   
                    
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
    public void verificarTempoPessoaImune(PessoaImune pessoa){
        
        double tempoRestante = pessoa.getContadorDeImunizacao();
        
        if (tempoRestante <= 0.0){
            voltarPessoaImuneParaOriginal(pessoa);
        }
        else{
            pessoa.setContadorDeImunizacao(tempoRestante-0.5);
        }
        
    }
    public void voltarPessoaImuneParaOriginal(PessoaImune pessoa){
        
        int tipoPessoaAnterior = pessoa.getTipoPessoaAnterior();
        
        switch(tipoPessoaAnterior){
            
            case 1 ->{
                transformarParaPessoaMalInformada(pessoa);
                break;
            }
            case 2 ->{
                transformarParaPessoaBemInformada(pessoa);
                break;
            }
            default ->{
                transformarParaPessoaNormal(pessoa);
                break;
            }
            
        }
        
    }
}
