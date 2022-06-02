/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.GenericDao;
import java.util.List;

/**
 *
 * @author João Vitor
 * @param <Entidade>
 */
public abstract class GenericGerenciadorDominio<Entidade> {
    private GenericDao genericDao = null;

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
}
