/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Projeto;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
                if(!projeto.getProfessores().isEmpty()) projeto.getProfessores().get(0).getCodigo().getProfessor().getEmail();
                if(!projeto.getEmpresas().isEmpty()) projeto.getEmpresas().get(0).getCodigo().getEmpresa().getCnpj();
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

    @Override
    public List filtrar(Class classe, Object object) {
        List lista = null;
        Session sessao = null;
        Projeto projeto = (Projeto) object;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Projeto.class);
            
            Root tabela = consulta.from(Projeto.class);
           
            Predicate restricoes = null;
            
            String titulo = "%" + projeto.getTitulo().toLowerCase() + "%";
            String descricao = "%" + projeto.getDescricao().toLowerCase() + "%";
            Date dataInicio = projeto.getDateDataInicio();
            Date dataFim = projeto.getDateDataFim();

            if(dataInicio != null && dataFim != null){
                restricoes = builder.and(
                    builder.like(builder.lower(tabela.get("titulo")), titulo),
                    builder.equal(tabela.get("dataInicio"), dataInicio),
                    builder.equal(tabela.get("dataFim"), dataFim),
                    builder.like(builder.lower(tabela.get("descricao")), descricao)
                );
            } else if(dataInicio != null){
                restricoes = builder.and(
                    builder.like(builder.lower(tabela.get("titulo")), titulo),
                    builder.equal(tabela.get("dataInicio"), dataInicio),
                    builder.like(builder.lower(tabela.get("descricao")), descricao)
                );
            } else if(dataFim != null){
                restricoes = builder.and(
                    builder.like(builder.lower(tabela.get("titulo")), titulo),
                    builder.equal(tabela.get("dataFim"), dataFim),
                    builder.like(builder.lower(tabela.get("descricao")), descricao)
                );
            } else {
                restricoes = builder.and(
                    builder.like(builder.lower(tabela.get("titulo")), titulo),
                    builder.like(builder.lower(tabela.get("descricao")), descricao)
                );
            }

            
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
