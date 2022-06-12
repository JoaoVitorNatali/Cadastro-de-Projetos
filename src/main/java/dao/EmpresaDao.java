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
import modelo.Empresa;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author João Vitor
 */
public class EmpresaDao extends GenericDao{

    @Override
    public List filtrar(Class classe, Object object) {
        List lista = null;
        Session sessao = null;
        Empresa empresa = (Empresa) object;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Empresa.class);
            
            Root tabela = consulta.from(Empresa.class);
           
            Predicate restricoes = null;
            
            String razaoSocial = "%" + empresa.getRazaoSocial() + "%";
            String nomeFantasia = "%" + empresa.getNomeFantasia().trim() + "%";
            String cnpj = "%" + empresa.getCnpj().trim() + "%";
            String email = "%" + empresa.getEmail() + "%";
            String telefone = "%" + empresa.getTelefone().trim() + "%";
            String nomeContato = "%" + empresa.getEmail() + "%";

            razaoSocial = razaoSocial.toLowerCase();
            nomeFantasia = nomeFantasia.toLowerCase();
            email = email.toLowerCase();
            nomeContato = nomeContato.toLowerCase();
            
            System.out.println(telefone);
            System.out.println(cnpj);
            
            
//            NO POSTGRES EXISTE A DIFERENÇA DE LIKE E ILIKE, NO MYSQL NÃO, PORTANTO É NECESSÁRIO FAZER A VALIDAÇAO DE CASE SENSITIVE (QUE O CRITERIA NÃO FAZ POR DEFAULT)
            restricoes = builder.and(
                builder.like(builder.lower(tabela.get("razaoSocial")), razaoSocial),
                builder.like(builder.lower(tabela.get("nomeFantasia")), nomeFantasia),
                builder.like(builder.lower(tabela.get("cnpj")), cnpj),
                builder.like(builder.lower(tabela.get("email")), email),
                builder.like(builder.lower(tabela.get("telefone")), telefone),
                builder.like(builder.lower(tabela.get("nomeContato")), nomeContato)
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
