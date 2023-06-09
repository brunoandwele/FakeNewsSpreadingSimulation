/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mundo;

import EstruturasMundo.EstruturasMundo;
import FakeNews.FakeNews;
import IAs.IADestruidoraFakeNews;
import IAs.IAGeradoraFakeNews;
import MeioComunicacaoConfiavel.MeioComunicacaoConfiavel;
import Pessoa.Pessoa;
import RealNews.RealNews;
import SituacaoPessoa.PessoaBemInformada;
import SituacaoPessoa.PessoaImune;
import SituacaoPessoa.PessoaMalInformada;
import java.util.ArrayList;


/**
 *
 * @author bruno
 */
public class Mundo {
    
    public int[][] mapaFisico = new int[30][60]; //Matriz contendo o desenho do mundo e os numeros para cada co
    // Matriz de arraylist que é uma copia do mapaFisico, entretanto contem arrylist<String> que ira guardar os ids de cada pessoa em cada posicao conforme andam.
    public ArrayList<ArrayList<ArrayList<String>>> mapaComIds; 
    private ArrayList<Pessoa> pessoasDoMundo = new ArrayList<>(); //Array das pessoas do mund0
    private int countPessoasSemEfeitos, countPessoasBemInformadas, countPessoasMalInformadas, countPessoasImunes; //Variaves para armazenar a quantidade de pessoas de cada tipo
    private double tempoTotal = 0; //Atributo para guardar o tempo que o codigo estará rodando
    
    private int quantidadeFakeNewsCompartilhadas; //Atributo que guarda a quantidade de fakeNews Compartilhada
    private int quantidadeRealNewsCompartilhadas;//Atributo que guarda a quantidade de realNews Compartilhada
    
    //Atributos que guardam objetos de cada estrutura, fazendo uma composicao com elas.
    private IAGeradoraFakeNews IAGeradoraFakeNews;
    private IADestruidoraFakeNews IADestruidoraFakeNews; 
    private MeioComunicacaoConfiavel MeioComunicacaoConfiavel;
    
    public Mundo(){   
        this.gerarEstruturas(); //Gera as estruturas (objetos das IAs e da emissora)
        this.gerarPessoasMundo();//Gera as 100 pessoas em um array dentro do objeto mundo
        this.gerarMatrizDados(); //Gera a matriz contendo os dados de onde cada pessoa esta (usa o ID)
        this.gerarMatrizMundo(); //Gera a matriz do mundo (a qual sera exibida aos usuarios)
    }
    
    public void gerarEstruturas(){
        //Gera (instancia) as 3 estruturas dentro do mapa
        IAGeradoraFakeNews = new IAGeradoraFakeNews(25,35,5,10);
        IADestruidoraFakeNews = new IADestruidoraFakeNews(15,20,20,22);
        MeioComunicacaoConfiavel = new MeioComunicacaoConfiavel(40,45,20,22);
         
    }
    
    public void colocarEstruturasMatriz(){
        //Adiciona as estruturas na matriz do mapa
        InserirEstruturaMatriz(IAGeradoraFakeNews);
        InserirEstruturaMatriz(IADestruidoraFakeNews);
        InserirEstruturaMatriz(MeioComunicacaoConfiavel); 
    }
    
    public void InserirEstruturaMatriz(EstruturasMundo estrutura){
        //Funcao para posicionar a estrutura no mapa com base nas delimitacoes da area
        int xInicial = estrutura.getCoordenadasXInicial();
        int xFinal = estrutura.getCoordenadasXFinal();
        
        int yInicial = estrutura.getCoordenadasYInicial();
        int yFinal = estrutura.getCoordenadasYFinal();
        //Preenche a area em que a estrutura estiver com o numero da cor dela
        for(int i = yInicial; i < yFinal; i++){

            for(int j = xInicial; j < xFinal; j++){
                
                mapaFisico[i][j] = estrutura.getNumeroDaCor();
            
            }        
        }        
    }
    
    public void gerarMatrizMundo(){
        
        //Gera a matriz do mundo
        
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
        
        //coloca as estruturas na matriz do mundo
        colocarEstruturasMatriz();
        
    }
    public void gerarMatrizDados(){
        
        //gera a matriz de dados, a qual controla onde cada pessoa esta (copia do mundo original mas com os ids no lugar das pessoas)
        //É uma matriz usando arraylist, a qual no final simula o mundo visto pelos usuarios, mas no lugar dos numeros das pessoas, há 
        //uma lista com os ids das pessoas que estao la - facilita na hora de adicionar nos contatos de uma pessoa.
        
        mapaComIds = new ArrayList<>();
        
        for(int i = 0;i < 30; i++){
            
            mapaComIds.add(new ArrayList<ArrayList<String>>());
            
            for(int j = 0;j < 60; j++){
                mapaComIds.get(i).add(new ArrayList<String>());
            }
            
            mapaComIds.get(i).trimToSize();//Reduz o tamanho do array para o que ele já tem, para desocupar espaco
        }
        
        mapaComIds.trimToSize();//Reduz o tamanho do array para o que ele já tem, para desocupar espaco
        
    }
    public void mostrarDadosMundo(){
        
        //Mostra a quantidade de pessoas totais de cada tipo, levando em conta o numero de cor de cada pessoa no array
        
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
        //Prints mostrando os dados do mundo
        System.out.println("###########################");
        System.out.println("\033[45m \033[0m - IAGeradoraFakeNews");
        System.out.println("\033[46m \033[0m - IADestruidoraFakeNews");
        System.out.println("\033[47m \033[0m - Fonte De Informacao Confiavel");
        System.out.println("\033[44m \033[0m - Pessoas sem efeitos:    " + countPessoasSemEfeitos);
        System.out.println("\033[41m \033[0m - Pessoas MAL informadas: " + countPessoasMalInformadas);
        System.out.println("\033[42m \033[0m - Pessoas BEM informadas: " + countPessoasBemInformadas);
        System.out.println("\033[43m \033[0m - Pessoas imunes:         " + countPessoasImunes);
        System.out.println("Quantidade de FakeNews compartilhadas:   " + this.quantidadeFakeNewsCompartilhadas);
        System.out.println("Quantidade de RealNews compartilhadas:   " + this.quantidadeRealNewsCompartilhadas);
        System.out.println("###########################");
        System.out.println("");
    }
    public void desenhaMundoConsole(){
        //Funcao para imprimir o mundo no console com as cores coretas
        
        for(int i = 0; i < mapaFisico.length; i++){
            for(int j = 0; j < mapaFisico[i].length; j++){
                
                switch(mapaFisico[i][j]){
                    //Cor para o vazio - "branco"
                    case 0:
                        System.out.print(" ");
                        break;
                    //Cor para a borda - azul escuro
                    case 1:
                        System.out.print("\033[44m \033[0m");
                        break;
                    //Cor para pessoa sem efeitos - azul escuro
                    case 20:
                        System.out.print("\033[44m \033[0m");
                        break;
                    //Cor para pessoa mal informada - vermelho
                    case 21:
                        System.out.print("\033[41m \033[0m");
                        break;
                    //Cor para pessoa bem informada - verde
                    case 22:
                        System.out.print("\033[42m \033[0m");
                        break;
                    //Cor para pessoa imune - amarelo
                    case 23:
                        System.out.print("\033[43m \033[0m");
                        break;
                    //Cor para IA geradora de fake news - rosa
                    case 31:
                        System.out.print("\033[45m \033[0m");
                        break;
                    //Cor para IA destruidora de fake news - ciano
                    case 32:
                        System.out.print("\033[46m \033[0m");
                        break;
                    //Cor para fonte de informacao confiavel - cinza
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
            //Mostra o tempo percorrido desde o inicio da animacao
            System.out.println("Tempo total: " + tempoTotal);
            
            mostrarDadosMundo(); //Mostra a quantidade de cada tipo de pessoa
            desenhaMundoConsole(); //Imprime o mundo no console
            gerarMatrizMundo(); // Refaz a matriz do mundo
            atualizarPessoas(); // Movimenta as pessoas
            verificarEncontroComObjetos(); //Verifica se houve o encontro com alguma estrutura
  
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
        //Gera as 100 pessoas do mundo
        
        int numeroDePessoas = 100;
  
        for(int i = 0; i < numeroDePessoas; i++){
            Pessoa pessoaNova = new Pessoa(true);
            pessoasDoMundo.add(pessoaNova);
        }
        
    }
    public void atualizaPessoasNosMapas(Pessoa pessoa){
        
        //Atualiza as posicoes das pessoas no mundo
        
        int coordenadaAtualX = pessoa.getCoordenadaAtualX();
        int coordenadaAtualY = pessoa.getCoordenadaAtualY();
        
        int coordenadaAntigaX = pessoa.getCoordenadaAntigaX();
        int coordenadaAntigaY = pessoa.getCoordenadaAntigaY();
           
        int numeroDaCor = pessoa.getNumeroDaCor();
        
        //Atualiza no mapa das cores (Matriz de inteiros)
        mapaFisico[coordenadaAtualY][coordenadaAtualX] = numeroDaCor;
        
        String whatsAppID = pessoa.getWhatsAppID();
              
        //Atualiza no mapa dos Dados (Matriz de ArrayList de ArrayList de ArrayList de String)
        mapaComIds.get(coordenadaAtualY).get(coordenadaAtualX).add(whatsAppID);
        mapaComIds.get(coordenadaAntigaY).get(coordenadaAntigaX).remove(whatsAppID);

    
    }
    public void atualizarPessoas(){       
        //Atualiza a posicao de cada pessoa do mundo ao chamar as funcoes que movem as pessoas
        //E se a pessoa for imune, ela tem o seu tempo restante verificado
        
        for(Pessoa pessoa: pessoasDoMundo){
            pessoa.mover();  //Altera as coordenadas
            atualizaPessoasNosMapas(pessoa); //Atualiza na matriz
            
            if (pessoa instanceof PessoaImune){
                verificarTempoPessoaImune((PessoaImune) pessoa);
            }
            
        }
        
    }
    
    public void verificarEncontroComObjetos(){
        //Verifica o encontro das pessoas com outros objetos do mundo
        
        for(Pessoa pessoa : pessoasDoMundo){
            verificarEncontroPessoas(pessoa); //Verifica com as outras pessoas;
        }
        
        for(Pessoa pessoa : pessoasDoMundo){
            verificarEncontroEstruturas(pessoa); //Verifica com as estruturas
        }
        
    }
    public void verificarEncontroPessoas(Pessoa pessoa){
            //Funcao que verifica o encontro de uma pessoas com outras
            //Utiliza a matriz de dados (copia da matriz do mundo, mas dentro contem arrayList de strings, os quais
            //guardam os ids das pessoas em cada posicao que estao
            
            int coordenadaPessoaX = pessoa.getCoordenadaAtualX();
            int coordenadaPessoaY = pessoa.getCoordenadaAtualY();
            ArrayList<String> listaPessoasNessasCoordenadas;
            
            //Verifica se tem alguem na esquerda, direita, embaixo, em cima ou na mesma posicao
            
            //Verifica na mesma posicao (coordenadas sao as mesmas)
            listaPessoasNessasCoordenadas = mapaComIds.get(coordenadaPessoaY).get(coordenadaPessoaX);
            if(listaPessoasNessasCoordenadas.size()>1){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);   
                }
 
            }
            
            //Verifica na posicao a esquerda (coordenada X - 1)
            listaPessoasNessasCoordenadas = mapaComIds.get(coordenadaPessoaY).get(coordenadaPessoaX-1);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
 
            }
            
            //Verifica na posicao a direita (coordenada X + 1)
            listaPessoasNessasCoordenadas = mapaComIds.get(coordenadaPessoaY).get(coordenadaPessoaX+1);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
            }
            
            //Verifica na posicao a cima (coordenada Y - 1)
            listaPessoasNessasCoordenadas = mapaComIds.get(coordenadaPessoaY-1).get(coordenadaPessoaX);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
            }
            
            //Verifica na posicao a baixo (coordenada Y + 1)
            listaPessoasNessasCoordenadas = mapaComIds.get(coordenadaPessoaY+1).get(coordenadaPessoaX);
            if(listaPessoasNessasCoordenadas.size()>0){
                
                for(String whatsAppPessoa:listaPessoasNessasCoordenadas){
                    pessoa.adicionarWhatsApp(whatsAppPessoa);          
                }
            }
    }
    
    public void verificarEncontroEstruturas(Pessoa pessoa){
        //Verifica encontro com as estruturas do mundo
        //Para isso, ele analisa as cores da matriz do mundo
        
        //31 -> IA geradora de fakeNews
        //32 -> IA destruidora de fakeNews
        //33 -> Fonte de informacao confiavel
        
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
    
    public void transformarParaPessoaMalInformada(Pessoa pessoa, FakeNews novaFakeNewsCompartilhada){
        //Usa um construtor de copia para copiar a pessoa de uma certa classe para a pessoa malInformada
        int indicePessoa = pessoasDoMundo.indexOf(pessoa);
        PessoaMalInformada pessoaTransformadaMalInformada = new PessoaMalInformada(pessoa,novaFakeNewsCompartilhada);
        pessoasDoMundo.set(indicePessoa,pessoaTransformadaMalInformada);
 
    }
    public void transformarParaPessoaBemInformada(Pessoa pessoa, RealNews novaRealNewsCompartilhada){
        //Usa um construtor de copia para copiar a pessoa de uma certa classe para a pessoa Bem Informada
        int indicePessoa = pessoasDoMundo.indexOf(pessoa);
        PessoaBemInformada pessoaBemInformada = new PessoaBemInformada(pessoa,novaRealNewsCompartilhada);
        pessoasDoMundo.set(indicePessoa,pessoaBemInformada);
 
    }
    public void transformarParaPessoaImune(Pessoa pessoa){
        //Usa um construtor de copia para copiar a pessoa de uma certa classe para a pessoa Imune
        int indicePessoa = pessoasDoMundo.indexOf(pessoa);
        PessoaImune pessoaImunizada = new PessoaImune(pessoa);
        pessoasDoMundo.set(indicePessoa,pessoaImunizada);
            
         
    }
    public void mandarRealNewsParaContatos(Pessoa pessoaSabia){
        //Funcao para "enviar" noticias verdadeiras para o contato de alguma pessoa
        //O envio só acontece se a pessoa que entrou em contato não está imuene
        
        if((pessoaSabia instanceof PessoaImune) == false){
            //Cria a fakenews que será compartilhada
            RealNews novaRealNewsCompartilhada = new RealNews();
            
            ArrayList<String> contatosPessoaInfectada = pessoaSabia.getContatos();

            for (String contatoRegistrado:contatosPessoaInfectada){
                //Analisa na lista de contatos da pessoa quem ela tem, e entao usa a funcao de transformarParaPessoaBemInformada() nelas

                for(Pessoa possivelContato:pessoasDoMundo){

                    String whatsAppIDPossivelContato = possivelContato.getWhatsAppID();

                    if(whatsAppIDPossivelContato.equals(contatoRegistrado)){    
                        //Se a pessoa for imune, ela nao se transforma em BemInformada
                        if(possivelContato instanceof PessoaImune){
                            continue;
                        }

                        transformarParaPessoaBemInformada(possivelContato,novaRealNewsCompartilhada);
                    }
                }  
            }
            //finalmente transforma a pessoa que entrou em contato em bemInformada
            transformarParaPessoaBemInformada(pessoaSabia,novaRealNewsCompartilhada);
            //Define a quantidade de RealNews enviadas com base na ultima realNews envidada.
            this.quantidadeRealNewsCompartilhadas = novaRealNewsCompartilhada.getNumeroRealNews();
        }
    }
    
    public void mandarFakeNewsParaContatos(Pessoa pessoaInfectada){
        //Funcao para "enviar" noticias falsas para o contato de alguma pessoa
        //O envio só acontece se a pessoa que entrou em contato não está imuene
        
        if((pessoaInfectada instanceof PessoaImune) == false){
            
            //Cria a fakenews que será compartilhada
            FakeNews novaFakeNewsCompartilhada = new FakeNews();
            
            ArrayList<String> contatosPessoaInfectada = pessoaInfectada.getContatos();
            
            //Analisa na lista de contatos da pessoa quem ela tem, e entao usa a funcao de transformarParaPessoaMalInformada() nelas
            for (String contatoRegistrado:contatosPessoaInfectada){

                for(Pessoa possivelContato:pessoasDoMundo){
                    
                    String whatsAppIDPossivelContato = possivelContato.getWhatsAppID();

                    if(whatsAppIDPossivelContato.equals(contatoRegistrado)){
                        //Se a pessoa for imune, ela nao se transforma em malInformada
                        if(possivelContato instanceof PessoaImune){
                            continue;
                        }   

                        transformarParaPessoaMalInformada(possivelContato,novaFakeNewsCompartilhada);
                    }
                }  
            }
            //finalmente transforma a pessoa que entrou em contato em malInformada
            transformarParaPessoaMalInformada(pessoaInfectada,novaFakeNewsCompartilhada);
            //Define a quantidade de fakeNews enviadas com base na ultima fakeNews envidada.
            this.quantidadeFakeNewsCompartilhadas =  novaFakeNewsCompartilhada.getNumeroFakeNews();
        }
    }
    
    public void verificarTempoPessoaImune(PessoaImune pessoa){
        //Funcao para verificar tempo restante de uma pessoa imune
        double tempoRestante = pessoa.getContadorDeImunizacao();
        
        if (tempoRestante <= 0.0){
            //Se o tempo acabar, ela volta para a posicao original
            transformarParaPessoaBemInformada(pessoa,null);
        }
        else{
            //Atualiza o tempo restante de imunizacao -> -0.5 porque a iteracao ocorre a cada 0.5 segundos
            pessoa.setContadorDeImunizacao(tempoRestante-0.5);
        }
        
    }

}
