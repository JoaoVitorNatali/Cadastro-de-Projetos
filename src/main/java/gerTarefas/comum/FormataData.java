/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.comum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Projeto;

/**
 *
 * @author João Vitor
 */
public class FormataData {
    public static String dateToString(Date data){
        if(data == null) return "";
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String dataString = df.format(data);
        return dataString;
    }
    
    public static Date stringToDate(String dataString){
        if(dataString.equals("")) return null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            Date dataFormatada = formato.parse(dataString);
            return dataFormatada;
        } catch (ParseException ex) {
            Logger.getLogger(Projeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
