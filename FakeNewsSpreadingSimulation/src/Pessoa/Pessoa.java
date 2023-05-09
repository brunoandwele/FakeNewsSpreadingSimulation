package Pessoa;

import InterfacePessoa.IMovable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author bruno
 */

public class Pessoa implements IMovable{
  
    private int coordenadaAtualX, coordenadaAtualY; //Coordenadas Atuais
    private int coordenadaAntigaX, coordenadaAntigaY; //Coordenadas Antigas
    private int numeroDaCor; //Numero da cor
    private static int baseWhatsAppID = 0; //Variavel para controlar o ID do whatsApp ao criar novas pessoas
    private String whatsAppID; //Atributo que guarda o whatsapp id de uma pessoa
    private ArrayList<String> contatos = new ArrayList<>(); //Lista de contatos
    
    public Pessoa(boolean gerarNovasCoordenadas){
        //Construtor para pessoa, a qual recebe como argumento um valor booleano para verificar se novas coordenadas devem ou nao serem criadas
        this.numeroDaCor = 20; //Pessoa sem efeitos (cor default -> 20)
        
        String numeroID = String.valueOf(baseWhatsAppID);      
        this.whatsAppID = "#" + numeroID;
        baseWhatsAppID++; //Incrementa a variavel estatica, para mudar o id das proximas pessoas que serao criadas
        
        if(gerarNovasCoordenadas){
            setCoordenadasIniciais();
        }
 
    }
    
    public Pessoa(Pessoa pessoa){
        //Construtor copias para caso uma pessoa de uma subclasse vire uma pessoa da classe Pessoa somente
        this.setCoordenadaAtualX(pessoa.getCoordenadaAtualX());
        this.setCoordenadaAtualY(pessoa.getCoordenadaAtualY());
        this.setCoordenadaAntigaX(pessoa.getCoordenadaAntigaX());
        this.setCoordenadaAntigaY(pessoa.getCoordenadaAntigaY());  
        this.setWhatsAppID(pessoa.getWhatsAppID());
        this.getContatos().addAll(pessoa.getContatos());
        this.numeroDaCor = 20;
    }
   
 
    private int gerarDirecao(){
       //gera a proxima direcao para qual a pessoa vai
        
       Random random = new Random();
       int proximaDirecao = random.nextInt(4);
       
       return proximaDirecao;
        
    }
    private void setCoordenadasIniciais(){
        //Define as coordenadas iniciais
        Random random = new Random();
        coordenadaAtualX = random.nextInt(1,59);
        coordenadaAtualY = random.nextInt(1,29);
    }
    private void salvarCoordenadasAnitgas(){
        //Salva as coordenadas antigas
       this.coordenadaAntigaX = this.coordenadaAtualX;
       this.coordenadaAntigaY = this.coordenadaAtualY;
    }
    public void adicionarWhatsApp(String whatsAppIdPessoaNova){
        //Adiciona o whatsApp id de uma pessoa na lista de contatos dessa pessoa
        if(contatos.contains(whatsAppIdPessoaNova) == false && whatsAppIdPessoaNova!=this.whatsAppID){
            contatos.add(whatsAppIdPessoaNova);
        }

    }
    @Override
    public void mover(){
        //Funcao que move a pessoa
       salvarCoordenadasAnitgas(); //Antes salva as coordenadas antigas
 
       int proximaDirecao = gerarDirecao(); //Gera a proxima direcao
       
       switch(proximaDirecao){
           
           //Para Esquerda
           case 0 -> {
               this.coordenadaAtualX -= 1;
               
               if (this.coordenadaAtualX < 1){
                   this.coordenadaAtualX = 58;
               }
            }
           //Para Direita
           case 1 -> {
               this.coordenadaAtualX += 1;
               
               if (this.coordenadaAtualX > 58){
                   this.coordenadaAtualX = 1;
               }
            }
           //Para Cima
           case 2 -> {
               this.coordenadaAtualY -= 1;
               
               if (this.coordenadaAtualY < 1){
                   this.coordenadaAtualY = 28;
               }
            }
           //Para Baixo
           case 3 -> {
               this.coordenadaAtualY += 1;
               
               if (this.coordenadaAtualY > 28){
                   this.coordenadaAtualY = 1;
               }
            }
           
       }

               
    }
    //Gets and Sets
    public int getCoordenadaAtualX() {
        return coordenadaAtualX;
    }

    public void setCoordenadaAtualX(int coordenadaAtualX) {
        this.coordenadaAtualX = coordenadaAtualX;
    }

    public int getCoordenadaAtualY() {
        return coordenadaAtualY;
    }

    public void setCoordenadaAtualY(int coordenadaAtualY) {
        this.coordenadaAtualY = coordenadaAtualY;
    }

    public int getCoordenadaAntigaX() {
        return coordenadaAntigaX;
    }

    public void setCoordenadaAntigaX(int coordenadaAntigaX) {
        this.coordenadaAntigaX = coordenadaAntigaX;
    }

    public int getCoordenadaAntigaY() {
        return coordenadaAntigaY;
    }

    public void setCoordenadaAntigaY(int coordenadaAntigaY) {
        this.coordenadaAntigaY = coordenadaAntigaY;
    }

    public int getNumeroDaCor() {
        return numeroDaCor;
    }

    public void setNumeroDaCor(int numeroDaCor) {
        this.numeroDaCor = numeroDaCor;
    }

    public String getWhatsAppID() {
        return whatsAppID;
    }

    public void setWhatsAppID(String whatsAppID) {
        this.whatsAppID = whatsAppID;
    }

    public ArrayList<String> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<String> contatos) {
        this.contatos = contatos;
    }
    
  
}
