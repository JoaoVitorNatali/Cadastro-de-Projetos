/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
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

            Criteria consulta = sessao.createCriteria(classe);
            lista = consulta.list();

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
}
