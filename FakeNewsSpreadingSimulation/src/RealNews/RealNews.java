/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealNews;

/**
 *
 * @author brunoandwele
 */
public class RealNews {
    //Base para definir o numero da realNews compartilhada
    private static int baseNumeroRealNews = 0;
    public int numeroRealNews;
    
    public RealNews(){
        //Construtor que atualiza a variavel estatica e associa ao numero da real news criada
        baseNumeroRealNews++;
        this.numeroRealNews = baseNumeroRealNews;
    }

    public static int getBaseNumeroRealNews() {
        return baseNumeroRealNews;
    }

    public static void setBaseNumeroRealNews(int baseNumeroRealNews) {
        RealNews.baseNumeroRealNews = baseNumeroRealNews;
    }

    public int getNumeroRealNews() {
        return numeroRealNews;
    }

    public void setNumeroRealNews(int numeroRealNews) {
        this.numeroRealNews = numeroRealNews;
    }
    
    
}
