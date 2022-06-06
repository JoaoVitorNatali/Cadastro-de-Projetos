/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import gerTarefas.gerDominio.GerDominAluno;
import gerTarefas.gerDominio.GerDominEmpresa;
import gerTarefas.gerDominio.GerDominProfessor;
import gerTarefas.gerDominio.GerDominProjeto;
import gerTarefas.gerInterface.Aluno.TableModelAluno;
import gerTarefas.gerInterface.Empresa.TableModelEmpresa;
import gerTarefas.gerInterface.GerenciadorInterface;
import gerTarefas.gerInterface.Professor.TableModelProfessor;
import gerTarefas.gerInterface.comum.GenericGerenciador;
import interfaceGrafica.Alunos.FormularioAluno;
import interfaceGrafica.Empresas.FormularioEmpresa;
import interfaceGrafica.MainWindow;
import interfaceGrafica.Professores.FormularioProfessor;
import interfaceGrafica.Projetos.DadosProjeto;
import interfaceGrafica.Projetos.FormularioProjeto;
import interfaceGrafica.Projetos.SelecionarAlunoProjeto;
import interfaceGrafica.Projetos.SelecionarEmpresaProjeto;
import interfaceGrafica.Projetos.SelecionarProfessorProjeto;
import java.util.Date;
import modelo.Aluno;
import modelo.Empresa;
import modelo.Professor;
import modelo.Projeto;
/**
 *
 * @author João Vitor
 */
public class GerenciadorProjeto extends GenericGerenciador<Projeto> {
    private Projeto projeto = null;
    private final DadosProjeto dadosProjeto;
    
    private final GerenciadorEntidadesProjeto professoresProjeto;
    private final GerenciadorEntidadesProjeto empresasProjeto;
    private final GerenciadorEntidadesProjeto alunosProjeto;
    
    
    public GerenciadorProjeto(MainWindow janelaPrincipal, GerenciadorInterface gerInter) {
        super(janelaPrincipal, FormularioProjeto.class, TableModelProjeto.class, gerInter, GerDominProjeto.class);
        
        
        professoresProjeto = new GerenciadorEntidadesProjeto<Professor>(
                janelaPrincipal,
                new TableModelProfessoresProjeto(),
                new TableModelProfessor(),
                SelecionarProfessorProjeto.class,
                FormularioProfessor.class,
                this,
                new GerDominProfessor()
        );
        
        empresasProjeto = new GerenciadorEntidadesProjeto<Empresa>(
                janelaPrincipal,
                new TableModelEmpresasProjeto(),
                new TableModelEmpresa(),
                SelecionarEmpresaProjeto.class,
                FormularioEmpresa.class,
                this,
                new GerDominEmpresa()
        );

        alunosProjeto = new GerenciadorEntidadesProjeto<Aluno>(
                janelaPrincipal,
                new TableModelAlunosProjeto(),
                new TableModelAluno(),
                SelecionarAlunoProjeto.class,
                FormularioAluno.class,
                this,
                new GerDominAluno()
        );
        
        dadosProjeto = new DadosProjeto(janelaPrincipal, true, this);
    }
    
    public void abrirProjeto(Projeto projeto){
        dadosProjeto.abrirProjeto(projeto);
        this.projeto = projeto;
    }

    public void listarAlunos() {
        this.getGerenciadorDominio().getGenericDao().get(Projeto.class, projeto.getCodigo());
    }
    
    public void adicionarAluno(Aluno aluno, Date dataEntrada, int cargaHoraria, double valorBolsa, boolean bolsista){
        this.projeto.setAluno(aluno, dataEntrada, cargaHoraria, valorBolsa, bolsista);
    }
    
    public void atualizarObjeto(){
        this.getGerenciadorDominio().alterar(this.projeto);
    }

    public GerenciadorEntidadesProjeto getProfessoresProjeto() {
        return professoresProjeto;
    }

    public GerenciadorEntidadesProjeto getEmpresasProjeto() {
        return empresasProjeto;
    }

    public GerenciadorEntidadesProjeto getAlunosProjeto() {
        return alunosProjeto;
    }
    
    
}
