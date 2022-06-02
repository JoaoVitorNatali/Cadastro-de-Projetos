/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import java.util.List;
import modelo.Aluno;

/**
 *
 * @author João Vitor
 */
public class GerDominAluno extends GenericGerenciadorDominio<Aluno>{

    @Override
    public List<Aluno> listar() {
        return getGenericDao().listar(Aluno.class);
    }
}
