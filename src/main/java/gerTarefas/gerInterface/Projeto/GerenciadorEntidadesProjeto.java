/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import gerTarefas.gerInterface.comum.CustomFormularioInterface;
import gerTarefas.gerInterface.comum.CustomTableModel;
import gerTarefas.gerInterface.comum.InterfGerenciadorInterface;
import interfaceGrafica.MainWindow;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTable;


/**
 *
 * @author João Vitor
 * @param <Entidade>
 */
public class GerenciadorEntidadesProjeto<Entidade> implements InterfGerenciadorInterface {
    CustomTableModel tableModelProjeto;
    CustomTableModel tableModelPesquisa;
    JDialog listagemEntidades;
    CustomFormularioInterface<Entidade> formularioFiltro;

    GerenciadorEntidadesProjeto(
            MainWindow janelaPrincipal,
            CustomTableModel tableModelProjeto,
            CustomTableModel tableModelPesquisa,
            Class listagemEntidades,
            Class formularioFiltro,
            GerenciadorProjeto gerenciador
    ) {
        this.tableModelProjeto = tableModelProjeto;
        this.tableModelPesquisa = tableModelPesquisa;
        
        
        try {
            this.listagemEntidades = (JDialog) listagemEntidades.getConstructor(
                    Frame.class,
                    boolean.class,
                    GerenciadorEntidadesProjeto.class
            ).newInstance(janelaPrincipal, true, this);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GerenciadorEntidadesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.formularioFiltro = (CustomFormularioInterface<Entidade>) formularioFiltro.getConstructor(
                    Frame.class,
                    boolean.class,
                    InterfGerenciadorInterface.class
            ).newInstance(janelaPrincipal, true, this);
        } catch ( InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(GerenciadorEntidadesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTabelaProjeto(JTable tabela){
        tabela.setModel(tableModelProjeto);
    }

    public void abrirListagem(){
        listagemEntidades.setVisible(true);
    }
    
    public void fecharListagem(){
        listagemEntidades.setVisible(false);
    }
    
    public void abrirFiltro(){
        formularioFiltro.abrirModalFiltragem();
    }
    
    public void setTabelaPesquisa(JTable tabela){
        tabela.setModel(tableModelPesquisa);
    }

    @Override
    public void concluir() {
        //funcao chamada pelo modal de filtro
//        formularioFiltro.toObject();
        // objter dados para filtrar
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
