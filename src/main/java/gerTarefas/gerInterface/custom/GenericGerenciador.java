/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.custom;

import gerTarefas.gerDominio.GenericGerenciadorDominio;
import gerTarefas.gerInterface.GerenciadorInterface;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 *
 * @author João Vitor
 * @param <Entidade>
 */
public class GenericGerenciador<Entidade> {
    
    private JDialog formulario = null;
    private CustomTableModel tabela = null;
    private GenericGerenciadorDominio gerenciadorDominio = null;

    // Contador de horas gastas aqui: 5
    // Caso for alterar, aumente o contador
    public GenericGerenciador(
            java.awt.Frame janelaPrincipal, 
            Class formularioGenerico, 
            Class tableModelGenerico, 
            GerenciadorInterface gerInter, 
            Class genericGerenciadorDominio
    ) {
        // Instanciando dinamicamente um JDialog de formulario generico
        try {
            formulario = (JDialog) formularioGenerico.getConstructor(
                    Frame.class,
                    boolean.class,
                    GerenciadorInterface.class
            ).newInstance(janelaPrincipal, true, gerInter);
        } catch (
                NoSuchMethodException | SecurityException | InvocationTargetException | IllegalArgumentException | IllegalAccessException | InstantiationException ex
                ) {
            Logger.getLogger(GenericGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Instanciando dinamicamente uma tableModel generica
        try {
            tabela = (CustomTableModel) tableModelGenerico.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(GenericGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciando dinamicamente um gerenciador de dominio
        try {
            gerenciadorDominio = (GenericGerenciadorDominio) genericGerenciadorDominio.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(GenericGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public GenericGerenciadorDominio getGerenciadorDominio(){
        return this.gerenciadorDominio;
    }
    
    public void setTableModel(JTable tabelaEntidade){
        tabelaEntidade.setModel(tabela);
    }
    
    public void abrirModalCriacao(){
        ((CustomFormularioInterface) formulario).abrirModalCriacao();
    }
    
    public void abrirModalEdicao(int codigo){
        ((CustomFormularioInterface) formulario).abrirModalEdicao(codigo);
    }
        
    public void abrirModalFiltragem(){
        ((CustomFormularioInterface) formulario).abrirModalFiltragem();
    }
    
    public void listar() {
        ArrayList<Entidade> lista = (ArrayList) gerenciadorDominio.listar();
        tabela.adicionar(lista);
    }
}
