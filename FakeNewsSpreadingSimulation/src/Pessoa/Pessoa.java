package Pessoa;

import InterfacePessoa.IMovable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author bruno
 */

public class Pessoa implements IMovable{
  
    private int coordenadaAtualX, coordenadaAtualY;
    private int coordenadaAntigaX, coordenadaAntigaY;
    private int numeroDaCor;
    private static int baseWhatsAppID = 0;
    private String whatsAppID;
    private ArrayList<String> contatos = new ArrayList<>();
    
    public Pessoa(boolean gerarNovasCoordenadas){
        
        this.numeroDaCor = 20; //Pessoa sem efeitos (cor default -> 20)
        
        String numeroID = String.valueOf(baseWhatsAppID);      
        this.whatsAppID = "#" + numeroID;
        baseWhatsAppID++;
        
        if(gerarNovasCoordenadas){
            setCoordenadasIniciais();
        }
 
    }
   
 
    private int gerarDirecao(){
       //gera a proxima direcao
        
       Random random = new Random();
       int proximaDirecao = random.nextInt(4);
       
       return proximaDirecao;
        
    }
    private void setCoordenadasIniciais(){
        Random random = new Random();
        coordenadaAtualX = random.nextInt(1,59);
        coordenadaAtualY = random.nextInt(1,29);
    }
    private void salvarCoordenadasAnitgas(){
       this.coordenadaAntigaX = this.coordenadaAtualX;
       this.coordenadaAntigaY = this.coordenadaAtualY;
    }
    public void adicionarWhatsApp(String whatsAppIdPessoaNova){
        
        if(contatos.contains(whatsAppIdPessoaNova) == false && whatsAppIdPessoaNova!=this.whatsAppID){
            contatos.add(whatsAppIdPessoaNova);
        }

    }
    @Override
    public void mover(){
        
       salvarCoordenadasAnitgas();
 
       int proximaDirecao = gerarDirecao();
       
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
