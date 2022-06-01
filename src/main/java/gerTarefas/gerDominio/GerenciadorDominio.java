/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.ConexaoHibernate;
import dao.GenericDao;
import java.util.List;
import modelo.Empresa;

/**
 *
 * @author João Vitor
 */
public class GerenciadorDominio {
    private GenericDao genericDao = null;

    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();   
        genericDao = new GenericDao();
    }
    
    public List<Empresa> listarEmpresa(){
        return genericDao.listar(Empresa.class);
    }
    
    public void inserirEmpresa(Empresa empresa){
        genericDao.inserir(empresa);
    }
}
