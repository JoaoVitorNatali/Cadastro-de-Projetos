/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import gerTarefas.gerInterface.comum.FormataData;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author João Vitor
 */
@Entity
public class Projeto implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int codigo;
    @Column(nullable=false, unique=true)
    private String titulo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @Column(nullable=false)
    private String descricao;
    
    @OneToMany (mappedBy = "codigo.projeto", cascade = CascadeType.ALL)
    private List<EmpresaProjeto> empresas;
    
    @OneToMany (mappedBy = "codigo.projeto", cascade = CascadeType.ALL)
    private List<ProfessorProjeto> professores;
    
    @OneToMany (mappedBy = "codigo.projeto", cascade = CascadeType.ALL)
    private List<AlunoParticipante> alunos;

    public Projeto() {
    }

    public Projeto(String titulo, Date dataInicio, Date dataFim, String descricao) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
    }
    
    public Projeto(String titulo, String dataInicio, String dataFim, String descricao) {
        this.titulo = titulo;
        this.dataInicio = stringToDate(dataInicio);
        this.dataFim = stringToDate(dataFim);
        this.descricao = descricao;
    }
    
    public Projeto(int codigo, String titulo, String dataInicio, String dataFim, String descricao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataInicio = stringToDate(dataInicio);
        this.dataFim = stringToDate(dataFim);
        this.descricao = descricao;
    }
    
    public Projeto(String titulo, Date dataInicio, Date dataFim, String descricao, List<ProfessorProjeto> professores, List<EmpresaProjeto> empresas) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.professores = professores;
        this.empresas = empresas;
    }

    public Projeto(int codigo, String titulo, Date dataInicio, Date dataFim, String descricao, List<EmpresaProjeto> empresas, List<ProfessorProjeto> professores, List<AlunoParticipante> alunos) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.empresas = empresas;
        this.professores = professores;
        this.alunos = alunos;
    }
    
    public Projeto(int codigo, String titulo, String dataInicio, String dataFim, String descricao, List<EmpresaProjeto> empresas, List<ProfessorProjeto> professores, List<AlunoParticipante> alunos) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataInicio = stringToDate(dataInicio);
        this.dataFim = stringToDate(dataFim);
        this.descricao = descricao;
        this.empresas = empresas;
        this.professores = professores;
        this.alunos = alunos;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        System.out.println("getting information projeto");
        return titulo;
    }

    public String getDataInicio() {
        return dateToString(dataInicio);
    }

    public String getDataFim() {
        return dateToString(dataFim);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<EmpresaProjeto> getEmpresas() {
        return empresas;
    }

    public List<ProfessorProjeto> getProfessores() {
        return professores;
    }
    
    public List<AlunoParticipante> getAlunosParticipantes() {
        return alunos;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEmpresas(List<EmpresaProjeto> empresas) {
        this.empresas = empresas;
    }

    public void setProfessores(List<ProfessorProjeto> professores) {
        this.professores = professores;
    }

    public void setAlunos(List<AlunoParticipante> alunos) {
        this.alunos = alunos;
    }
    
    public void setAlunoParticipante(AlunoParticipante aluno) {
        this.alunos.add(aluno);
    }
    
    public void addAluno(Aluno aluno, Date dataEntrada, int cargaHorariaSemanal, double valorBolsa, boolean bolsista){    
        AlunoParticipante alunoParticipante = new AlunoParticipante(aluno, this, dataEntrada, cargaHorariaSemanal, valorBolsa, bolsista);
        this.setAlunoParticipante(alunoParticipante);
    }
    
    public void addEmpresa(Empresa empresa) {
        EmpresaProjeto empProj = new EmpresaProjeto(empresa, this);
        this.empresas.add(empProj);
    }
    
    public void addProfessor(Professor professor) {
        ProfessorProjeto prof = new ProfessorProjeto(professor, this);
        this.professores.add(prof);
    }
    
    private String dateToString(Date data){
        return FormataData.dateToString(data);
    }
    
    private Date stringToDate(String dataString){
        return FormataData.stringToDate(dataString);
    }

    public void removeAluno(AlunoParticipante entidade) {
        this.alunos.remove(entidade);
    }

    public void removeProfessor(ProfessorProjeto entidade) {
        this.professores.remove(entidade);
    }

    public void removeEmpresa(EmpresaProjeto entidade) {
        this.empresas.remove(entidade);
    }
}
