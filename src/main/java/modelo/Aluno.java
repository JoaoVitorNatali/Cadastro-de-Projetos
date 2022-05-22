/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author João Vitor
 */
@Entity
public class Aluno implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int codigo;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=false, unique=true)
    private String matricula;
    @Column(nullable=false)
    private String curso;
    @Column()
    private String telefone;
    @Column(unique=true)
    private String email;
    
    @OneToMany (mappedBy = "codigo.aluno", fetch = FetchType.LAZY)
    private List<AlunoParticipante> alunos;

    public Aluno() {
    }

    public Aluno(String nome, String matricula, String curso, String telefone, String email){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Object[] toArray(){
        return new Object[] {nome, email, matricula, curso, telefone};
    }
    
    public Object[] getCamposAluno(){
        return new Object[] {"Nome", "E-mail", "Matrícula", "Curso", "Telefone"};
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public String getCurso(){
        return this.curso;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public String getEmail(){
        return this.email;
    }
}
