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
import modelo.Aluno;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author João Vitor
 */
public class AlunoDao extends GenericDao{

    @Override
    public List filtrar(Class classe, Object object) {
        List lista = null;
        Session sessao = null;
        Aluno aluno = (Aluno) object;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Aluno.class);
            
            Root tabela = consulta.from(Aluno.class);
           
            Predicate restricoes = null;
            
            String nome = "%" + aluno.getNome() + "%";
            String matricula = "%" + aluno.getMatricula().trim() + "%";
            Coordenadoria curso = aluno.getCurso();
            String telefone = "%" + aluno.getTelefone().trim() + "%";
            String email = "%" + aluno.getEmail() + "%";

            nome = nome.toLowerCase();
            matricula = matricula.toLowerCase();
            email = email.toLowerCase();
            
            System.out.println(curso);
            
//            NO POSTGRES EXISTE A DIFERENÇA DE LIKE E ILIKE, NO MYSQL NÃO, PORTANTO É NECESSÁRIO FAZER A VALIDAÇAO DE CASE SENSITIVE (QUE O CRITERIA NÃO FAZ POR DEFAULT)
            restricoes = builder.and(
                builder.like(builder.lower(tabela.get("nome")), nome),
                builder.like(builder.lower(tabela.get("matricula")), matricula),
                builder.equal(tabela.get("curso"), curso.ordinal()),
                builder.like(tabela.get("telefone"), telefone),
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
