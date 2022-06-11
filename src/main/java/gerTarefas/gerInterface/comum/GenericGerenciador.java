/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.comum;

import gerTarefas.gerDominio.GenericGerenciadorDominio;
import gerTarefas.gerInterface.Constantes.TipoFormulario;
import gerTarefas.gerInterface.GerenciadorInterface;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.hibernate.HibernateException;

/**
 *
 * @author João Vitor
 * @param <Entidade>
 */
public class GenericGerenciador<Entidade> implements InterfGerenciadorInterface {
    
    private CustomFormularioInterface<Entidade> formulario = null;
    private CustomTableModel tableModel = null;
    private GenericGerenciadorDominio gerenciadorDominio = null;
    private Frame framePrincipal;

    // Contador de horas gastas aqui: 5
    // Caso for alterar, aumente o contador
    public GenericGerenciador(
            java.awt.Frame janelaPrincipal, 
            Class formularioGenerico, 
            Class tableModelGenerico, 
            GerenciadorInterface gerInter, 
            Class genericGerenciadorDominio
    ) {
        this.framePrincipal = janelaPrincipal;
        // Instanciando dinamicamente um JDialog de formulario generico
        try {
            formulario = (CustomFormularioInterface) formularioGenerico.getConstructor(
                    Frame.class,
                    boolean.class,
                    InterfGerenciadorInterface.class
            ).newInstance(janelaPrincipal, true, this);
        } catch (
                NoSuchMethodException | SecurityException | InvocationTargetException | IllegalArgumentException | IllegalAccessException | InstantiationException ex
                ) {
            Logger.getLogger(GenericGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Instanciando dinamicamente uma tableModel generica
        try {
            tableModel = (CustomTableModel) tableModelGenerico.getConstructor().newInstance();
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
        formulario.abrirModalCriacao();
    }
    
    public void abrirModalEdicao(){
        Entidade entidade = (Entidade) tableModel.getSelected();
        if(entidade != null) formulario.abrirModalEdicao(entidade);
        else AlertaErro.showErro(framePrincipal, "Primeiro selecione uma linha da tabela");
    }

    public void abrirModalFiltragem(){
        formulario.abrirModalFiltragem();
    }
    
    public void fecharModal(){
        formulario.closeModal();
        formulario.limparCampos();
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
                break;
            default:
                break;
        }
    }
}
