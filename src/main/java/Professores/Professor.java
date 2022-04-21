/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Professores;

/**
 *
 * @author João Vitor
 */
public class Professor {
    private String siape;
    private String nome;
    private int coordenadoria;
    private String email;

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
