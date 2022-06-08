/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import gerTarefas.gerInterface.Constantes.Coordenadoria;
import java.io.Serializable;
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

/**
 *
 * @author João Vitor
 */
@Entity
public class Professor implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int codigo;
    @Column(nullable=false, unique=true, length=9)
    private String siape;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=false)
    private Coordenadoria coordenadoria;
    @Column(nullable=false, unique=true)
    private String email;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Professor_Projeto",
        joinColumns = {@JoinColumn(name="professor")},
        inverseJoinColumns = {@JoinColumn(name="projeto")}
    )
    private List<Projeto> projetos;

    public Professor() {
    }

    public Professor(String siape, String nome, Coordenadoria coordenadoria, String email) {
        this.siape = siape;
        this.nome = nome;
        this.coordenadoria = coordenadoria;
        this.email = email;
    }
    
    public Professor(String siape, String nome, Coordenadoria coordenadoria, String email, List<Projeto> projetos) {
        this.siape = siape;
        this.nome = nome;
        this.coordenadoria = coordenadoria;
        this.email = email;
        this.projetos = projetos;
    }

    public Professor(int codigo, String siape, String nome, Coordenadoria coordenadoria, String email, List<Projeto> projetos) {
        this.codigo = codigo;
        this.siape = siape;
        this.nome = nome;
        this.coordenadoria = coordenadoria;
        this.email = email;
        this.projetos = projetos;
    }

    public String getSiape() {
        return siape;
    }

    public String getNome() {
        return nome;
    }

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public String getEmail() {
        return email;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
