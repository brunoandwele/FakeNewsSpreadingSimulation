/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstruturasMundo;

/**
 *
 * @author bruno
 */
public class EstruturasMundo {
    
    protected int coordenadasXInicial, coordenadasXFinal;
    protected int coordenadasYInicial, coordenadasYFinal; 
    
    protected int numeroDaCor;
    
    public EstruturasMundo(int coordenadasXInicial, int coordenadasXFinal, int coordenadasYInicial, int coordenadasYFinal){
        
        this.coordenadasXInicial = coordenadasXInicial;
        this.coordenadasXFinal = coordenadasXFinal;
        this.coordenadasYInicial = coordenadasYInicial;
        this.coordenadasYFinal = coordenadasYFinal;
        
        
    }

    public int getCoordenadasXInicial() {
        return coordenadasXInicial;
    }

    public void setCoordenadasXInicial(int coordenadasXInicial) {
        this.coordenadasXInicial = coordenadasXInicial;
    }

    public int getCoordenadasXFinal() {
        return coordenadasXFinal;
    }

    public void setCoordenadasXFinal(int coordenadasXFinal) {
        this.coordenadasXFinal = coordenadasXFinal;
    }

    public int getCoordenadasYInicial() {
        return coordenadasYInicial;
    }

    public void setCoordenadasYInicial(int coordenadasYInicial) {
        this.coordenadasYInicial = coordenadasYInicial;
    }

    public int getCoordenadasYFinal() {
        return coordenadasYFinal;
    }

    public void setCoordenadasYFinal(int coordenadasYFinal) {
        this.coordenadasYFinal = coordenadasYFinal;
    }

    public int getNumeroDaCor() {
        return numeroDaCor;
    }

    public void setNumeroDaCor(int numeroDaCor) {
        this.numeroDaCor = numeroDaCor;
    }
    
    
}
