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
    protected GenericDao genericDao = null;

    public GenericGerenciadorDominio() {
        genericDao = new GenericDao();
    }
    
    public GenericDao getGenericDao(){
        return this.genericDao;
    }
    
    public abstract List<Entidade> listar();
    
    public void inserir(Entidade entidade){
        genericDao.inserir(entidade);
    }
    
    public void alterar(Entidade entidade) throws HibernateException, PersistenceException{
        genericDao.alterar(entidade);
    }
    
    public void excluir(Entidade entidade) {
        genericDao.excluir(entidade);
    }
}
