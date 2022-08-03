/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerInterface.TableModels.TableModelEmpresasProjeto;
import gerTarefas.gerInterface.TableModels.TableModelProfessoresProjeto;
import gerTarefas.gerInterface.TableModels.TableModelAlunosProjeto;
import gerTarefas.gerInterface.TableModels.TableModelProjeto;
import gerTarefas.gerDominio.GerDominAluno;
import gerTarefas.gerDominio.GerDominEmpresa;
import gerTarefas.gerDominio.GerDominProfessor;
import gerTarefas.gerDominio.GerDominProjeto;
import gerTarefas.gerInterface.TableModels.TableModelAluno;
import gerTarefas.gerInterface.TableModels.TableModelEmpresa;
import gerTarefas.gerInterface.TableModels.TableModelProfessor;
import gerTarefas.comum.AlertaErro;
import interfaceGrafica.Formularios.FormularioAluno;
import interfaceGrafica.Formularios.FormularioEmpresa;
import interfaceGrafica.MainWindow;
import interfaceGrafica.Formularios.FormularioProfessor;
import interfaceGrafica.Projetos.DadosProjeto;
import interfaceGrafica.Formularios.FormularioProjeto;
import interfaceGrafica.Projetos.SelecionarAlunoProjeto;
import interfaceGrafica.Projetos.SelecionarEmpresaProjeto;
import interfaceGrafica.Projetos.SelecionarProfessorProjeto;
import java.util.Date;
import modelo.Aluno;
import modelo.AlunoParticipante;
import modelo.Empresa;
import modelo.EmpresaProjeto;
import modelo.Professor;
import modelo.ProfessorProjeto;
import modelo.Projeto;
import org.hibernate.HibernateException;
/**
 *
 * @author João Vitor
 */
public class GerenciadorProjeto extends TemplateGerenciadorInterface<Projeto> {
    private Projeto projeto = null;
    private final DadosProjeto dadosProjeto;
    
    private final GerenciadorEntidadeProjeto professoresProjeto;
    private final GerenciadorEntidadeProjeto empresasProjeto;
    private final GerenciadorEntidadeProjeto alunosProjeto;
    
    public GerenciadorProjeto(MainWindow janelaPrincipal, GerenciadorInterface gerenciadorInterface) {
        super(
                janelaPrincipal,
                new TableModelProjeto(),
                gerenciadorInterface,
                new GerDominProjeto()
        );
        
        this.formulario = new FormularioProjeto(janelaPrincipal, true, this);
        
        professoresProjeto = new GerenciadorEntidadeProjeto<Professor>(
                janelaPrincipal,
                new TableModelProfessoresProjeto(),
                new TableModelProfessor(),
                SelecionarProfessorProjeto.class,
                FormularioProfessor.class,
                this,
                new GerDominProfessor()
        );
        
        empresasProjeto = new GerenciadorEntidadeProjeto<Empresa>(
                janelaPrincipal,
                new TableModelEmpresasProjeto(),
                new TableModelEmpresa(),
                SelecionarEmpresaProjeto.class,
                FormularioEmpresa.class,
                this,
                new GerDominEmpresa()
        );

        alunosProjeto = new GerenciadorEntidadeProjeto<AlunoParticipante>(
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
        this.projeto = this.getProjeto(projeto.getCodigo());
        dadosProjeto.abrirProjeto(projeto);
    }
    
    public Projeto getProjeto(int codigo){
        return (Projeto) this.getGerenciadorDominio().getGenericDao().get(Projeto.class, codigo);
    }
    
    public void listarTabelas(){
        this.projeto = (Projeto) this.getGerenciadorDominio().getGenericDao().get(Projeto.class, projeto.getCodigo());
        this.professoresProjeto.listarEntidadesProjeto(this.projeto.getProfessores());
        this.alunosProjeto.listarEntidadesProjeto(this.projeto.getAlunosParticipantes());
        this.empresasProjeto.listarEntidadesProjeto(this.projeto.getEmpresas());
    }
    
    public void adicionarAluno(Aluno aluno, Date dataEntrada, int cargaHoraria, double valorBolsa, boolean bolsista){
        
        this.projeto.addAluno(aluno, dataEntrada, cargaHoraria, valorBolsa, bolsista);
        try{
            atualizarObjeto();
            this.getAlunosProjeto().fecharListagem();
        } catch (HibernateException ex){
            AlertaErro.showErro(this.getFramePrincipal(), "Esse aluno já está cadastrado no projeto");
            this.projeto = this.getProjeto(this.projeto.getCodigo()); // ajustar objeto de objeto para não repetir os dados
        }   
    }
    
    public void adicionarEmpresa(Empresa entidade) {
        this.projeto.addEmpresa(entidade);
        try{
            atualizarObjeto();
            this.getEmpresasProjeto().fecharListagem();
        } catch (HibernateException ex){
            AlertaErro.showErro(this.getFramePrincipal(), "Essa empresa já está cadastrada no projeto");
            this.projeto = this.getProjeto(this.projeto.getCodigo()); // ajustar objeto de objeto para não repetir os dados
        }
    }
    
    public void adicionarProfessor(Professor entidade) {
        this.projeto.addProfessor(entidade);
        try{
            atualizarObjeto();
            this.getProfessoresProjeto().fecharListagem();
        } catch (HibernateException ex){
            AlertaErro.showErro(this.getFramePrincipal(), "Esse professor já está cadastrado no projeto");
            this.projeto = this.getProjeto(this.projeto.getCodigo()); // ajustar objeto de objeto para não repetir os dados
        }
    }
    
    public void atualizarObjeto() throws HibernateException{
        this.getGerenciadorDominio().alterar(this.projeto);
    }

    public GerenciadorEntidadeProjeto getProfessoresProjeto() {
        return professoresProjeto;
    }

    public GerenciadorEntidadeProjeto getEmpresasProjeto() {
        return empresasProjeto;
    }

    public GerenciadorEntidadeProjeto getAlunosProjeto() {
        return alunosProjeto;
    }

    void removerAluno(AlunoParticipante entidade) {
        ((GerDominProjeto) this.getGerenciadorDominio()).removerAluno(entidade);
    }

    void removerProfessor(ProfessorProjeto entidade) {
        ((GerDominProjeto) this.getGerenciadorDominio()).removerProfessor(entidade);
    }

    void removerEmpresa(EmpresaProjeto entidade) {
        ((GerDominProjeto) this.getGerenciadorDominio()).removerEmpresa(entidade);
    }
}
