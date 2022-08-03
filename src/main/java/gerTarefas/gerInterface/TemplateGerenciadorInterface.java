/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerInterface.TableModels.CustomTableModel;
import gerTarefas.gerDominio.GenericGerenciadorDominio;
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
 * @param <Entidade>
 */
public abstract class TemplateGerenciadorInterface<Entidade> implements InterfGerenciadorInterface {
    
    protected CustomFormularioInterface<Entidade> formulario = null;
    private final CustomTableModel tableModel;
    private final GenericGerenciadorDominio gerenciadorDominio;
    private final Frame framePrincipal;

    // Contador de horas gastas aqui: 6
    // Caso for alterar, aumente o contador
    public TemplateGerenciadorInterface(
            java.awt.Frame janelaPrincipal,
            CustomTableModel tableModel,
            GerenciadorInterface gerInter,
            GenericGerenciadorDominio gerenciadorDominio
    ) {
        this.framePrincipal = janelaPrincipal;
        this.tableModel = tableModel;
        this.gerenciadorDominio = gerenciadorDominio;
    }

    public Frame getFramePrincipal() {
        return framePrincipal;
    }
    
    public GenericGerenciadorDominio getGerenciadorDominio(){
        return this.gerenciadorDominio;
    }
    
    public void setTabela(JTable tabelaEntidade){
        tabelaEntidade.setModel(tableModel);
        tableModel.setTabela(tabelaEntidade);
    }
    
    public CustomTableModel getTableModel(){
        return this.tableModel;
    }
    
    public void abrirModalCriacao(){
        formulario.setTipo(TipoFormulario.INSERIR);
        formulario.alterarTituloModal();
        formulario.showModal();
    }
    
    public void abrirModalEdicao(){
        Entidade entidade = (Entidade) tableModel.getSelected();
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
        ArrayList<Entidade> lista = (ArrayList) gerenciadorDominio.listar();
        tableModel.adicionar(lista);
    }
    
    private void inserir(Entidade entidade){
        gerenciadorDominio.inserir(entidade);
        fecharModal();
    }
    
    private void alterar(Entidade entidade){
        try{
            gerenciadorDominio.alterar(entidade);
            fecharModal();
        } catch (HibernateException ex){
            AlertaErro.showErro(framePrincipal, ex.getCause().toString());
        } catch (PersistenceException ex){
            AlertaErro.showErro(framePrincipal, "Erro ao editar. Verifique se está tentando inserir um valor repetido no banco de dados");
        }
    }
    
    private void filtrar(Entidade entidade){
        ArrayList<Entidade> lista = (ArrayList) gerenciadorDominio.filtrar(entidade);
        tableModel.adicionar(lista);
        this.formulario.closeModal();
        this.formulario.limparCampos();
    }
    
    public void excluir(){
        Entidade entidade = (Entidade) tableModel.getSelected();
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
        Entidade entidade = formulario.toObject();
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
