/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.AlunoDao;
import java.util.List;
import modelo.Aluno;

/**
 *
 * @author João Vitor
 */
public class GerDominAluno extends GenericGerenciadorDominio<Aluno>{

    public GerDominAluno() {
        super(new AlunoDao());
    }

    @Override
    public List<Aluno> listar() {
        return getGenericDao().listar(Aluno.class);
    }

    @Override
    public List<Aluno> filtrar(Aluno entidade) {
        return this.getGenericDao().filtrar(Aluno.class, entidade);
    }
}
