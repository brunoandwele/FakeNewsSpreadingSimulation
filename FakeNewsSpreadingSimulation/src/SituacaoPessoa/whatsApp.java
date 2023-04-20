/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SituacaoPessoa;

import Pessoa.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class whatsApp {
    
    public void adicionarPessoaNosContatos(Pessoa pessoaBase, Pessoa pessoaNova){
               
        String idPessoaNova = pessoaNova.getWhatsAppID();
        ArrayList<String> contatosPessoaBase = pessoaBase.getContatos();
        
        if(contatosPessoaBase.contains(idPessoaNova) == false){
            contatosPessoaBase.add(idPessoaNova);
        }
        
    }
}
