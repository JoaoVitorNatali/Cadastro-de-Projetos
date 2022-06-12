/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
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
}
