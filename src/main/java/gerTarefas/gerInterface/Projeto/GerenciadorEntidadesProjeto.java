/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import gerTarefas.gerDominio.GenericGerenciadorDominio;
import gerTarefas.gerInterface.comum.CustomFormularioInterface;
import gerTarefas.gerInterface.comum.CustomTableModel;
import gerTarefas.gerInterface.comum.InterfGerenciadorInterface;
import interfaceGrafica.MainWindow;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTable;
import modelo.Aluno;


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
    GenericGerenciadorDominio gerenciadorDominio;
    GerenciadorProjeto gerenciadorProjeto;

    GerenciadorEntidadesProjeto(
            MainWindow janelaPrincipal,
            CustomTableModel tableModelProjeto,
            CustomTableModel tableModelPesquisa,
            Class listagemEntidades,
            Class formularioFiltro,
            GerenciadorProjeto gerenciador,
            GenericGerenciadorDominio gerenciadorDominio
    ) {
        this.tableModelProjeto = tableModelProjeto;
        this.tableModelPesquisa = tableModelPesquisa;
        this.gerenciadorDominio = gerenciadorDominio;
        this.gerenciadorProjeto = gerenciador;
        
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
    
    public void listarEntidades(){
        ArrayList<Entidade> entidades = (ArrayList) this.gerenciadorDominio.listar();
        this.tableModelPesquisa.adicionar(entidades);
    }
    
    public void fecharListagem(){
        listagemEntidades.setVisible(false);
    }
    
    public void adicionarAluno(Date dataEntrada, int cargaHoraria, boolean bolsista, double valorBolsa){
        Aluno entidade = (Aluno) this.tableModelPesquisa.getSelected();
        this.gerenciadorProjeto.adicionarAluno(entidade, dataEntrada, cargaHoraria, valorBolsa, bolsista);
    }
    
    public void adicionarEmpresa(){
        
    }
        
    public void adicionarProfessor(){
        
    }
    
    public void adicionarEntidade(){

    }
    
    public void abrirFiltro(){
        formularioFiltro.abrirModalFiltragem();
    }
    
    public void setTabelaPesquisa(JTable tabela){
        tabela.setModel(tableModelPesquisa);
        this.tableModelPesquisa.setTabela(tabela);
    }

    @Override
    public void concluir() {
        // funcao chamada pelo modal de filtro das entidades do projeto
        // formularioFiltro.toObject();
        // objter dados para filtrar
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
