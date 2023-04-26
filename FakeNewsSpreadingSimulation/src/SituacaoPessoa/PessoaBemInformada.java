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

public class PessoaBemInformada extends Pessoa{

    public PessoaBemInformada(Pessoa pessoa) {
        
        super(); // Chama o construtor padrão de Pessoa
        
        this.setCoordenadaAtualX(pessoa.getCoordenadaAtualX());
        this.setCoordenadaAtualY(pessoa.getCoordenadaAtualY());
        this.setCoordenadaAntigaX(pessoa.getCoordenadaAntigaX());
        this.setCoordenadaAntigaY(pessoa.getCoordenadaAntigaY());  
        this.setWhatsAppID(pessoa.getWhatsAppID());
        this.getContatos().addAll(pessoa.getContatos());
        
        this.setNumeroDaCor(22); // Define o número da cor para 22
    }
    
    public PessoaBemInformada(){
        super();
        this.setNumeroDaCor(22);// Define o número da cor para 22
 
    }
    
    
}
