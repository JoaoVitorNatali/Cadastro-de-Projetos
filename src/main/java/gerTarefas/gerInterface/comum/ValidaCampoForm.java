/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.comum;

import interfaceGrafica.Professores.FormularioProfessor;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author João Vitor
 */
public class ValidaCampoForm {
    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public static String getTexto(JTextField campo, Component parent, String mensagemErro){
        String texto = campo.getText();
        if(texto.equals("")){
            AlertaErro.showErro(parent, mensagemErro);
        }
        return texto;
    }
    
    public static String getTexto(JTextArea campo, Component parent, String mensagemErro){
        String texto = campo.getText();
        if(texto.equals("")){
            AlertaErro.showErro(parent, mensagemErro);
        }
        return texto;
    }
    
    public static String getTexto(JComboBox<String> select, Component parent, String mensagemErro) {
        return select.getSelectedItem().toString();
    }
    
    public static Object getValue(JComboBox<Object> select, Component parent){
        return select.getSelectedItem();
    }
    
    public static String getEmail(JTextField campo, Component parent, String mensagemErro){
        String texto = campo.getText();
        if(texto.equals("")){
            AlertaErro.showErro(parent, mensagemErro);
        }else if ( !isEmail(texto)){
            AlertaErro.showErro(parent, "Formato de E-mail inválido");
            texto = "";
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
    
    public static String removeMascara(String texto){
        return texto.replaceAll("[^\\d]", "");
    }
    
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    
    public static boolean isEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
