package Pessoa;

import InterfacePessoa.IMovable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author bruno
 */

public class Pessoa implements IMovable{
  
    private int coordenadaAtualX = 30, coordenadaAtualY = 15;
    private int coordenadaAntigaX, coordenadaAntigaY;
    
    private int numeroDaCor = 20; //Pessoa sem efeitos (cor default)
    
    private String whatsAppID;
    
    private ArrayList<String> contatos = new ArrayList<String>();
    
    private int gerarDirecao(){
       //gera a proxima direcao
        
       Random random = new Random();
       int proximaDirecao = random.nextInt(4);
       
       return proximaDirecao = 2;
        
    }
    
    private void salvarCoordenadasAnitgas(){
       this.coordenadaAntigaX = this.coordenadaAtualX;
       this.coordenadaAntigaY = this.coordenadaAtualY;
    }
    
    public void mover(){
        
       salvarCoordenadasAnitgas();
 
       int proximaDirecao = gerarDirecao();
       
       switch(proximaDirecao){
           
           //Para esquerda
           case 0:
               this.coordenadaAtualX -= 1;
               
               if (this.coordenadaAtualX < 1){
                   this.coordenadaAtualX = 58;
               }
               
               break;
               
           //Para direita
           case 1:
               this.coordenadaAtualX += 1;
               
               if (this.coordenadaAtualX > 58){
                   this.coordenadaAtualX = 1;
               }
               
               break;
               
           //Para cima
           case 2:
               this.coordenadaAtualY -= 1;
               
               if (this.coordenadaAtualY < 1){
                   this.coordenadaAtualY = 28;
               }
               
               break;
               
           //Para baixo
           case 3:
               this.coordenadaAtualY += 1;
               
               if (this.coordenadaAtualY > 28){
                   this.coordenadaAtualY = 1;
               }
               
               break;
               
           default:
               this.coordenadaAtualX = this.coordenadaAntigaX;
               this.coordenadaAtualY = this.coordenadaAntigaY;
       }
       
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

    
    
    
}
