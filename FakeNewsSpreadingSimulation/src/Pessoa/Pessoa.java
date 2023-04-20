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
    private int numeroDaCor = 20; //Pessoa sem efeitos (cor default)
    private static int baseWhatsAppID = 0;
    private String whatsAppID;
    private ArrayList<String> contatos = new ArrayList<>();
    
    
   
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
    @Override
    public void mover(){
        
       salvarCoordenadasAnitgas();
 
       int proximaDirecao = gerarDirecao();
       
       switch(proximaDirecao){
           case 0 -> {
               this.coordenadaAtualX -= 1;
               
               if (this.coordenadaAtualX < 1){
                   this.coordenadaAtualX = 58;
               }
            }
           case 1 -> {
               this.coordenadaAtualX += 1;
               
               if (this.coordenadaAtualX > 58){
                   this.coordenadaAtualX = 1;
               }
            }
           case 2 -> {
               this.coordenadaAtualY -= 1;
               
               if (this.coordenadaAtualY < 1){
                   this.coordenadaAtualY = 28;
               }
            }
           case 3 -> {
               this.coordenadaAtualY += 1;
               
               if (this.coordenadaAtualY > 28){
                   this.coordenadaAtualY = 1;
               }
            }
               
           default -> {
               this.coordenadaAtualX = this.coordenadaAntigaX;
               this.coordenadaAtualY = this.coordenadaAntigaY;
            }
       }
        //Para esquerda
        //Para direita
        //Para cima
        //Para baixo
               
    }

    
    
    public Pessoa(){
        
        String numeroID = String.valueOf(baseWhatsAppID);
        this.whatsAppID = "#" + numeroID;
        
        baseWhatsAppID++;
        
        setCoordenadasIniciais();
        
    }
    
    public int getCoordenadaAtualX() {
        return coordenadaAtualX;
    }
    public int getCoordenadaAtualY() {
        return coordenadaAtualY;
    }
    public int getCoordenadaAntigaX() {
        return coordenadaAntigaX;
    }
    public int getCoordenadaAntigaY() {
        return coordenadaAntigaY;
    }
    public int getNumeroDaCor() {
        return numeroDaCor;
    }
    public String getWhatsAppID() {
        return whatsAppID;
    }
    public ArrayList<String> getContatos() {
        return contatos;
    } 

}
