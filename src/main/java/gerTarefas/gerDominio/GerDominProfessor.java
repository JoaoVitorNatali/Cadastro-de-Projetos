/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import java.util.List;
import modelo.Professor;

/**
 *
 * @author João Vitor
 */
public class GerDominProfessor extends GenericGerenciadorDominio<Professor>{

    @Override
    public List<Professor> listar() {
        return getGenericDao().listar(Professor.class);
    }
    
}
