/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.custom;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author João Vitor
 */
public class AlertaErro {
    public static void showErro(Component parent, String mensagem){
        JOptionPane.showMessageDialog(parent, mensagem);
    }
}
