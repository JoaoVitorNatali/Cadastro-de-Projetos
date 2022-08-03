/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.ProjetoDao;
import java.util.List;
import modelo.AlunoParticipante;
import modelo.EmpresaProjeto;
import modelo.ProfessorProjeto;
import modelo.Projeto;

/**
 *
 * @author João Vitor
 */
public class GerDominProjeto extends TemplateGerenciadorDominio<Projeto>{
    
    public GerDominProjeto() {
        super(new ProjetoDao());
    }

    @Override
    public List<Projeto> listar() {
        return getGenericDao().listar(Projeto.class);
    }
    
    public void removerAluno(AlunoParticipante aluno){
        this.getGenericDao().excluir(aluno);
    }
    
    public void removerProfessor(ProfessorProjeto professor){
        this.getGenericDao().excluir(professor);
    }
    
    public void removerEmpresa(EmpresaProjeto empresa){
        this.getGenericDao().excluir(empresa);
    }

    @Override
    public List<Projeto> filtrar(Projeto entidade) {
        return this.getGenericDao().filtrar(Projeto.class, entidade);
    }
}
