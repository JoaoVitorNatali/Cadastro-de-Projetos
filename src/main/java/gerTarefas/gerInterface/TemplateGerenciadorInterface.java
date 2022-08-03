/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerInterface.TableModels.TemplateTableModel;
import gerTarefas.gerDominio.TemplateGerenciadorDominio;
import gerTarefas.gerInterface.Constantes.TipoFormulario;
import gerTarefas.gerInterface.comum.AlertaErro;
import gerTarefas.gerInterface.comum.CustomFormularioInterface;
import gerTarefas.gerInterface.comum.InterfGerenciadorInterface;
import java.awt.Frame;
import java.util.ArrayList;
import javax.persistence.PersistenceException;
import javax.swing.JTable;
import org.hibernate.HibernateException;

/**
 *
 * @author João Vitor
 * @param <ENTITY>
 */
public abstract class TemplateGerenciadorInterface<ENTITY> implements InterfGerenciadorInterface {
    
    protected CustomFormularioInterface<ENTITY> formulario = null;
    private final TemplateTableModel tableModel;
    private final TemplateGerenciadorDominio gerenciadorDominio;
    private final Frame framePrincipal;

    public TemplateGerenciadorInterface(
            java.awt.Frame janelaPrincipal,
            TemplateTableModel tableModel,
            GerenciadorInterface gerInter,
            TemplateGerenciadorDominio gerenciadorDominio
    ) {
        this.framePrincipal = janelaPrincipal;
        this.tableModel = tableModel;
        this.gerenciadorDominio = gerenciadorDominio;
    }

    public Frame getFramePrincipal() {
        return framePrincipal;
    }
    
    public TemplateGerenciadorDominio getGerenciadorDominio(){
        return this.gerenciadorDominio;
    }
    
    public void setTabela(JTable tabelaEntidade){
        tabelaEntidade.setModel(tableModel);
        tableModel.setTabela(tabelaEntidade);
    }
    
    public TemplateTableModel getTableModel(){
        return this.tableModel;
    }
    
    public void abrirModalCriacao(){
        formulario.setTipo(TipoFormulario.INSERIR);
        formulario.alterarTituloModal();
        formulario.showModal();
    }
    
    public void abrirModalEdicao(){
        ENTITY entidade = (ENTITY) tableModel.getSelected();
        if(entidade != null) {
            formulario.setTipo(TipoFormulario.EDITAR);
            formulario.setEntidadeSelecionada(entidade);
            formulario.setCamposFormulario(entidade);
            formulario.alterarTituloModal();
            formulario.showModal();
        }
        else AlertaErro.showErro(framePrincipal, "Primeiro selecione uma linha da tabela");
    }

    public void abrirModalFiltragem(){
        formulario.setTipo(TipoFormulario.FILTRAR);
        formulario.alterarTituloModal();
        formulario.showModal();
    }
    
    public void fecharModal(){
        formulario.closeModal();
        formulario.limparCampos();
        formulario.setEntidadeSelecionada(null);
        listar();
    }
    
    public void listar() {
        ArrayList<ENTITY> lista = (ArrayList) gerenciadorDominio.listar();
        tableModel.adicionar(lista);
    }
    
    private void inserir(ENTITY entidade){
        gerenciadorDominio.inserir(entidade);
        fecharModal();
    }
    
    private void alterar(ENTITY entidade){
        try{
            gerenciadorDominio.alterar(entidade);
            fecharModal();
        } catch (HibernateException ex){
            AlertaErro.showErro(framePrincipal, ex.getCause().toString());
        } catch (PersistenceException ex){
            AlertaErro.showErro(framePrincipal, "Erro ao editar. Verifique se está tentando inserir um valor repetido no banco de dados");
        }
    }
    
    private void filtrar(ENTITY entidade){
        ArrayList<ENTITY> lista = (ArrayList) gerenciadorDominio.filtrar(entidade);
        tableModel.adicionar(lista);
        this.formulario.closeModal();
        this.formulario.limparCampos();
    }
    
    public void excluir(){
        ENTITY entidade = (ENTITY) tableModel.getSelected();
        if(entidade == null){
            AlertaErro.showErro(framePrincipal, "Primeiro selecione uma linha da tabela");
        } else {
            try{
                gerenciadorDominio.excluir(entidade);
                listar();
            } catch (PersistenceException ex){
                AlertaErro.showErro(framePrincipal, "Verifique se essa entidade que tentou excluir está cadastrada em algum projeto");
            }
        }
    }
    
    @Override
    public void concluir(){
        ENTITY entidade = formulario.toObject();
        if(entidade == null) return;
        
        TipoFormulario tipo = formulario.getTipo();
        
        if(null != tipo) switch (tipo) {
            case INSERIR:
                inserir(entidade);
                break;
            case EDITAR:
                alterar(entidade);
                break;
            case FILTRAR:
                filtrar(entidade);
                break;
            default:
                break;
        }
    }
}
