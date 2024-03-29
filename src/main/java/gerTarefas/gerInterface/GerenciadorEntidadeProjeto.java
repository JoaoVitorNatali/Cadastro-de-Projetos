/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerDominio.TemplateGerenciadorDominio;
import gerTarefas.gerInterface.Constantes.TipoFormulario;
import gerTarefas.gerInterface.TableModels.TemplateTableModel;
import interfaceGrafica.MainWindow;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTable;
import modelo.Aluno;
import modelo.AlunoParticipante;
import modelo.Empresa;
import modelo.EmpresaProjeto;
import modelo.Professor;
import modelo.ProfessorProjeto;
import interfaceGrafica.Formularios.InterfaceFormulario;


/**
 *
 * @author João Vitor
 * @param <ENTITY>
 */
public class GerenciadorEntidadeProjeto<ENTITY> implements IGerenciadorInterface{
    TemplateTableModel tableModelProjeto;
    TemplateTableModel tableModelPesquisa;
    JDialog listagemEntidades;
    InterfaceFormulario<ENTITY> formularioFiltro;
    TemplateGerenciadorDominio gerenciadorDominio;
    GerenciadorProjeto gerenciadorProjeto;

    GerenciadorEntidadeProjeto(
            MainWindow janelaPrincipal,
            TemplateTableModel tableModelProjeto,
            TemplateTableModel tableModelPesquisa,
            Class listagemEntidades,
            Class formularioFiltro,
            GerenciadorProjeto gerenciador,
            TemplateGerenciadorDominio gerenciadorDominio
    ) {
        this.tableModelProjeto = tableModelProjeto;
        this.tableModelPesquisa = tableModelPesquisa;
        this.gerenciadorDominio = gerenciadorDominio;
        this.gerenciadorProjeto = gerenciador;
        
        try {
            this.listagemEntidades = (JDialog) listagemEntidades.getConstructor(Frame.class,
                    boolean.class,
                    GerenciadorEntidadeProjeto.class
            ).newInstance(janelaPrincipal, true, this);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GerenciadorEntidadeProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.formularioFiltro = (InterfaceFormulario<ENTITY>) formularioFiltro.getConstructor(Frame.class,
                    boolean.class,
                    IGerenciadorInterface.class
            ).newInstance(janelaPrincipal, true, this);
        } catch ( InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(GerenciadorEntidadeProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTabelaProjeto(JTable tabela){
        tabela.setModel(tableModelProjeto);
        tableModelProjeto.setTabela(tabela);
    }

    public void abrirListagem(){
        listagemEntidades.setVisible(true);
    }
    
    public void listarEntidadesPesquisa(){
        ArrayList<ENTITY> entidades = (ArrayList) this.gerenciadorDominio.listar();
        this.tableModelPesquisa.adicionar(entidades);
    }
    
    public void listarEntidadesProjeto(List<ENTITY> entidades){
        this.tableModelProjeto.adicionar(entidades);
    }
    
    public void fecharListagem(){
        listagemEntidades.setVisible(false);
        this.gerenciadorProjeto.listarTabelas();
    }
    
    public void adicionarAluno(Date dataEntrada, int cargaHoraria, boolean bolsista, double valorBolsa){
        if(this.tableModelPesquisa.getSelectedRow() != -1){
            Aluno entidade = (Aluno) this.tableModelPesquisa.getSelected();
            this.gerenciadorProjeto.adicionarAluno(entidade, dataEntrada, cargaHoraria, valorBolsa, bolsista);
        }
    }
    
    public void adicionarEmpresa(){
        if(this.tableModelPesquisa.getSelectedRow() != -1){
            Empresa entidade = (Empresa) this.tableModelPesquisa.getSelected();
            this.gerenciadorProjeto.adicionarEmpresa(entidade);
        }
    }

    public void adicionarProfessor(){
        if(this.tableModelPesquisa.getSelectedRow() != -1){
            Professor entidade = (Professor) this.tableModelPesquisa.getSelected();
            this.gerenciadorProjeto.adicionarProfessor(entidade);
        }
    }
    
    public void abrirFiltro(){
        formularioFiltro.setTipo(TipoFormulario.FILTRAR);
        formularioFiltro.alterarTituloModal();
        formularioFiltro.showModal();
    }
    
    public void setTabelaPesquisa(JTable tabela){
        tabela.setModel(tableModelPesquisa);
        this.tableModelPesquisa.setTabela(tabela);
    }

    @Override
    public void concluir() {
        // função chamada pelo botao de concluir do filtro da listagem usada para inserir entidades no projeto
        ENTITY entidade = this.formularioFiltro.toObject();
        List<ENTITY> entidades = this.gerenciadorDominio.filtrar(entidade);
        this.formularioFiltro.closeModal();
        this.tableModelPesquisa.adicionar(entidades);
    }

    @Override
    public void fecharFormulario() {
        this.formularioFiltro.closeModal();
    }

    public void removerAluno() {
        if(this.tableModelProjeto.getSelectedRow() != -1){
            AlunoParticipante entidade = (AlunoParticipante) this.tableModelProjeto.getSelected();
            this.gerenciadorProjeto.removerAluno(entidade);
            this.fecharListagem();
        }
    }

    public void removerProfessor() {
        if(this.tableModelProjeto.getSelectedRow() != -1){
            ProfessorProjeto entidade = (ProfessorProjeto) this.tableModelProjeto.getSelected();
            this.gerenciadorProjeto.removerProfessor(entidade);
            this.fecharListagem();
        }
    }

    public void removerEmpresa() {
        if(this.tableModelProjeto.getSelectedRow() != -1){
            EmpresaProjeto entidade = (EmpresaProjeto) this.tableModelProjeto.getSelected();
            this.gerenciadorProjeto.removerEmpresa(entidade);
            this.fecharListagem();
        }
    }
}
