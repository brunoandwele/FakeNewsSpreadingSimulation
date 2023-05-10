/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SituacaoPessoa;

import Pessoa.Pessoa;

/**
 *
 * @author bruno
 */
public class PessoaImune extends Pessoa{
    
    public double contadorDeImunizacao = 30; //Tempo total de 30 segundos

    public PessoaImune(Pessoa pessoa) {
        //Construtor de copia, para poder gerar um novo objeto a partir de um outro da classe Pessoa
        super(false); // Chama o construtor padrão de Pessoa
        
        this.setCoordenadaAtualX(pessoa.getCoordenadaAtualX());
        this.setCoordenadaAtualY(pessoa.getCoordenadaAtualY());
        this.setCoordenadaAntigaX(pessoa.getCoordenadaAntigaX());
        this.setCoordenadaAntigaY(pessoa.getCoordenadaAntigaY());  
        this.setWhatsAppID(pessoa.getWhatsAppID());
        this.getContatos().addAll(pessoa.getContatos());
        
        this.setNumeroDaCor(23); // Define o número da cor para 23
        
    }
    
    public PessoaImune(){
        super(true);
        this.setNumeroDaCor(23);// Define o número da cor para 23
 
    }

    public double getContadorDeImunizacao() {
        return contadorDeImunizacao;
    }

    public void setContadorDeImunizacao(double contadorDeImunizacao) {
        this.contadorDeImunizacao = contadorDeImunizacao;
    }

    
    
   
}
