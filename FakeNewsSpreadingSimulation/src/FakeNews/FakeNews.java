/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FakeNews;

/**
 *
 * @author bruno
 */
public class FakeNews {
    //Base para definir o numero da fakeNews compartilhada
    private static int baseNumeroFakeNews = 0;
    public int numeroFakeNews;
    
    public FakeNews(){
        baseNumeroFakeNews++;
        this.numeroFakeNews = baseNumeroFakeNews;
    }

    public static int getBaseNumeroFakeNews() {
        return baseNumeroFakeNews;
    }

    public static void setBaseNumeroFakeNews(int baseNumeroFakeNews) {
        FakeNews.baseNumeroFakeNews = baseNumeroFakeNews;
    }

    public int getNumeroFakeNews() {
        return numeroFakeNews;
    }

    public void setNumeroFakeNews(int numeroFakeNews) {
        this.numeroFakeNews = numeroFakeNews;
    }
    
}
