/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.GenericDao;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.HibernateException;

/**
 *
 * @author João Vitor
 * @param <ENTITY>
 */
public abstract class TemplateGerenciadorDominio<ENTITY> {
    protected GenericDao dao = null;

    public TemplateGerenciadorDominio(GenericDao gerenciador) {
        dao = gerenciador;
    }
    
    public GenericDao getGenericDao(){
        return this.dao;
    }
    
    public abstract List<ENTITY> listar();
    
    public abstract List<ENTITY> filtrar(ENTITY entidade);
    
    public void inserir(ENTITY entidade){
        dao.inserir(entidade);
    }
    
    public void alterar(ENTITY entidade) throws HibernateException, PersistenceException{
        dao.alterar(entidade);
    }
    
    public void excluir(ENTITY entidade) {
        dao.excluir(entidade);
    }
}
