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
 * @param <Entidade>
 */
public abstract class GenericGerenciadorDominio<Entidade> {
    protected GenericDao dao = null;

    public GenericGerenciadorDominio(GenericDao gerenciador) {
        dao = gerenciador;
    }
    
    public GenericDao getGenericDao(){
        return this.dao;
    }
    
    public abstract List<Entidade> listar();
    
    public abstract List<Entidade> filtrar(Entidade entidade);
    
    public void inserir(Entidade entidade){
        dao.inserir(entidade);
    }
    
    public void alterar(Entidade entidade) throws HibernateException, PersistenceException{
        dao.alterar(entidade);
    }
    
    public void excluir(Entidade entidade) {
        dao.excluir(entidade);
    }
}
