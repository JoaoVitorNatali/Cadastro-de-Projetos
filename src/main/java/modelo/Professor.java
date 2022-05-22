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
    private int Codigo;
    @Column(nullable=false, unique=true)
    private String siape;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=false)
    private int coordenadoria;
    @Column(nullable=false, unique=true)
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Professor_Projeto",
        joinColumns = {@JoinColumn(name="professor")},
        inverseJoinColumns = {@JoinColumn(name="projeto")}
    )
    private List<Projeto> projetos;

    public Professor() {
    }

    public Professor(String siape, String nome, int coordenadoria, String email) {
        this.siape = siape;
        this.nome = nome;
        this.coordenadoria = coordenadoria;
        this.email = email;
    }

    public String getSiape() {
        return siape;
    }

    public String getNome() {
        return nome;
    }

    public int getCoordenadoria() {
        return coordenadoria;
    }

    public String getEmail() {
        return email;
    }
    
    
}
