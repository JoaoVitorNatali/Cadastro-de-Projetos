/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.custom;

import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author João Vitor
 */
public class ValidaCampoForm {
    public static String getTexto(JTextField campo, Component parent, String mensagemErro){
        String texto = campo.getText();
        if(texto.equals("")){
            AlertaErro.showErro(parent, mensagemErro);
        }
        return texto;
    }
    
    public static String getCnpj(JFormattedTextField campo, Component parent, String mensagemErro){
        String texto = campo.getText();
        if(texto.equals("") || !ValidaCnpj.isCNPJ(texto)){
            AlertaErro.showErro(parent, mensagemErro);
            return ""; //precisa retornar vazio para validaçao externa
        }
        return removeMascara(texto);
    }
    
    public static String getTelefone(JFormattedTextField campo, Component parent, String mensagemErro){
        String texto = campo.getText();
        if(texto.equals("")){
            AlertaErro.showErro(parent, mensagemErro);
        }
        return removeMascara(texto);
    }
    
    public static String removeMascara(String CNPJ){
        return CNPJ.replaceAll("[^\\d]", "");
    }
}
