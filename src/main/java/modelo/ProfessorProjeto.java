/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author João Vitor
 */

@Entity
@Table(name = "professor_projeto")
public class ProfessorProjeto implements Serializable {
    @EmbeddedId
    private ProfessorProjetoPk codigo;

    public ProfessorProjeto() {
    }

    public ProfessorProjeto(Professor professor, Projeto projeto) {
        this.codigo = new ProfessorProjetoPk(professor, projeto);
    }

    public ProfessorProjetoPk getCodigo() {
        return codigo;
    }
}
