/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author João Vitor
 */
@Embeddable
public class AlunoParticipantePk implements Serializable {
   
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno")
    private Aluno aluno;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "projeto")
    private Projeto projeto;
    

    public AlunoParticipantePk() {
    }

    public AlunoParticipantePk(Aluno aluno, Projeto projeto) {
        this.aluno = aluno;
        this.projeto = projeto;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
