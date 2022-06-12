/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gerTarefas.gerInterface.Constantes.Coordenadoria;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Professor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author João Vitor
 */
public class ProfessorDao extends GenericDao{

    @Override
    public List filtrar(Class classe, Object object) {
        List lista = null;
        Session sessao = null;
        Professor professor = (Professor) object;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Professor.class);
            
            Root tabela = consulta.from(Professor.class);
           
            Predicate restricoes = null;
            
            String siape = "%" + professor.getSiape().trim() + "%";
            String nome = "%" + professor.getNome().trim() + "%";
            Coordenadoria coordenadoria = professor.getCoordenadoria();
            String email = "%" + professor.getEmail() + "%";

            siape = siape.toLowerCase();
            nome = nome.toLowerCase();
            email = email.toLowerCase();
            
            
//            NO POSTGRES EXISTE A DIFERENÇA DE LIKE E ILIKE, NO MYSQL NÃO, PORTANTO É NECESSÁRIO FAZER A VALIDAÇAO DE CASE SENSITIVE (QUE O CRITERIA NÃO FAZ POR DEFAULT)
            restricoes = builder.and(
                builder.like(builder.lower(tabela.get("siape")), siape),
                builder.like(builder.lower(tabela.get("nome")), nome),
                builder.equal(tabela.get("coordenadoria"), coordenadoria.ordinal()),
                builder.like(builder.lower(tabela.get("email")), email)
            );
            
            consulta.where(restricoes);
            // EXECUTAR
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }
    
}
