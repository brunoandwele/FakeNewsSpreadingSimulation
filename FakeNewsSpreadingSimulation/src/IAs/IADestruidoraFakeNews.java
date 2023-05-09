/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IAs;

import EstruturasMundo.EstruturasMundo;

/**
 *
 * @author bruno
 */
public class IADestruidoraFakeNews extends EstruturasMundo{

    public IADestruidoraFakeNews(int coordenadasXInicial, int coordenadasXFinal, int coordenadasYInicial, int coordenadasYFinal) {
        //Construtor para definir as coordenadas iniciais
        super(coordenadasXInicial, coordenadasXFinal, coordenadasYInicial, coordenadasYFinal);
        
        this.setNumeroDaCor(32); //Numero da cor padrao para IADestruidoraFakeNews é 32
    }
    
    
}
