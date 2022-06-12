/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.ProfessorDao;
import java.util.List;
import modelo.Professor;

/**
 *
 * @author João Vitor
 */
public class GerDominProfessor extends GenericGerenciadorDominio<Professor>{

    public GerDominProfessor() {
        super(new ProfessorDao());
    }
    
    @Override
    public List<Professor> listar() {
        return getGenericDao().listar(Professor.class);
    }

    @Override
    public List<Professor> filtrar(Professor entidade) {
        return getGenericDao().filtrar(Professor.class, entidade);
    }
    
}
