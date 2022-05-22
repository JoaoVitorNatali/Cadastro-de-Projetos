/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @Column()
    private String descricao;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Empresa_Projeto",
        joinColumns = {@JoinColumn(name="projeto")},
        inverseJoinColumns = {@JoinColumn(name="empresa")}
    )
    private List<Empresa> empresas;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Professor_Projeto",
        joinColumns = {@JoinColumn(name="projeto")},
        inverseJoinColumns = {@JoinColumn(name="professor")}
    )
    private List<Professor> professores;
    
    @OneToMany (mappedBy = "codigo.projeto", fetch = FetchType.LAZY)
    private List<AlunoParticipante> alunos;

    public Projeto() {
    }

    public Projeto(String titulo, Date dataInicio, Date dataFim, String descricao) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<Professor> getProfessores() {
        return professores;
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

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    
    
}
