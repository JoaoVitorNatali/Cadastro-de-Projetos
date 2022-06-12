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
public class ProfessorProjetoPk implements Serializable {
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "professor")
    private Professor professor;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "projeto")
    private Projeto projeto;

    public ProfessorProjetoPk() {
    }

    public ProfessorProjetoPk(Professor professor, Projeto projeto) {
        this.professor = professor;
        this.projeto = projeto;
    }

    public Professor getProfessor() {
        return professor;
    }
}
