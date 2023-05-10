/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SituacaoPessoa;

import FakeNews.FakeNews;
import Pessoa.Pessoa;

/**
 *
 * @author bruno
 */
public class PessoaMalInformada extends Pessoa{
    
    private  FakeNews fakeNewsRecebida;//Atributo responsavel por agregar uma fakeNews compartilhada com a pessoa
    
    public PessoaMalInformada(Pessoa pessoa, FakeNews novaFakeNewsCompartilhada) {
        //Construtor de copia, para poder gerar um novo objeto a partir de um outro da classe Pessoa
        super(false); // Chama o construtor padrão de Pessoa
        
        this.setCoordenadaAtualX(pessoa.getCoordenadaAtualX());
        this.setCoordenadaAtualY(pessoa.getCoordenadaAtualY());
        this.setCoordenadaAntigaX(pessoa.getCoordenadaAntigaX());
        this.setCoordenadaAntigaY(pessoa.getCoordenadaAntigaY());  
        this.setWhatsAppID(pessoa.getWhatsAppID());
        this.getContatos().addAll(pessoa.getContatos());
        
        this.setNumeroDaCor(21); // Define o número da cor para 21
        this.fakeNewsRecebida = novaFakeNewsCompartilhada;//Define o atributo agragando uma fakeNews recebida;
    }
    
    public PessoaMalInformada(){
        super(true);
        this.setNumeroDaCor(21);// Define o número da cor para 22
    }

    public FakeNews getFakeNewsRecebida() {
        return fakeNewsRecebida;
    }

    public void setFakeNewsRecebida(FakeNews fakeNewsRecebida) {
        this.fakeNewsRecebida = fakeNewsRecebida;
    }
    
    
    
}
