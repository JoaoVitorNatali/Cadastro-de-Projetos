/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alunos;

/**
 *
 * @author João Vitor
 */
public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private String telefone;
    private String email;

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
