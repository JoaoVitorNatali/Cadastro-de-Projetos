/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author João Vitor
 */
public class GenericDao {
    public List listar(Class classe) throws HibernateException{
        Session sessao = null;
        List lista = null;
        
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            CriteriaQuery consulta = sessao.getCriteriaBuilder().createQuery(classe);
            consulta.from(classe);
            lista = sessao.createQuery(consulta).getResultList();
            
            System.out.println(lista.get(0).toString());

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if( sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }
    
    public Object inserir(Object object) throws HibernateException{
        Session sessao = null;
        Serializable ser = null;
        
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            
            ser = sessao.save(object);
            System.out.println(ser);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if( sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return ser;
    }
    
    public void excluir(Object object) throws HibernateException{
        Session sessao = null;
        
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            
            sessao.delete(object);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if( sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
    }
    
    public void alterar(Object object) throws HibernateException{
        Session sessao = null;
        
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();
            
            sessao.update(object);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if( sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
    }
    
    public Object get(Class classe, int id){
        Session sessao = null;
        Object objReturn = null;
        
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            objReturn = sessao.get(classe, id);

            sessao.getTransaction().commit();
            sessao.close();
        } catch(HibernateException ex){
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        
        return objReturn;
    }
}
