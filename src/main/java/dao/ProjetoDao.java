/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.ListAttribute;
import modelo.Aluno;
import modelo.AlunoParticipante;
import modelo.Empresa;
import modelo.Professor;
import modelo.Projeto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.sql.Update;

/**
 *
 * @author João Vitor
 */
public class ProjetoDao extends GenericDao{

    public ProjetoDao() {
    }
    
    @Override
    public Object get(Class classe, int id){
        List<Projeto> lista = null;
        Session sessao = null;
        Projeto objReturn = null;
        Projeto projeto = null;
        
        try{
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            objReturn = (Projeto) sessao.get(classe, id);
            
            if(objReturn != null) {
                
                projeto = new Projeto(
                    objReturn.getCodigo(), objReturn.getTitulo(), objReturn.getDataInicio(), objReturn.getDataFim(), objReturn.getDescricao(), objReturn.getEmpresas(), objReturn.getProfessores(), objReturn.getAlunosParticipantes()
                );
                
                if(!projeto.getAlunosParticipantes().isEmpty())projeto.getAlunosParticipantes().get(0).getCodigo().getAluno();
                if(!projeto.getProfessores().isEmpty()) projeto.getProfessores().get(0).getEmail();
                if(!projeto.getEmpresas().isEmpty()) projeto.getEmpresas().get(0).getCnpj();
            }

            sessao.getTransaction().commit();
            sessao.close();
        } catch(HibernateException ex){
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        
        return projeto;
    }
}
