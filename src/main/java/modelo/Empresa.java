/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import java.io.Serializable;
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
public class Empresa implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int codigo;
    @Column(nullable=false, unique=true)
    private String razaoSocial;
    @Column(nullable=false)
    private String nomeFantasia;
    @Column(nullable=false, unique=true, length=14)
    private String cnpj;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String telefone;
    @Column(nullable=false)
    private String nomeContato;
    
    @OneToMany (mappedBy = "codigo.empresa", fetch = FetchType.LAZY)
    private List<EmpresaProjeto> projetos;

    public Empresa() {
    }

    public Empresa(String razaoSocial, String nomeFantasia, String cnpj, String email, String telefone, String nomeContato) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
    }

    public Empresa(int codigo, String razaoSocial, String nomeFantasia, String cnpj, String email, String telefone, String nomeContato) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
    }

    public Empresa(int codigo, String razaoSocial, String nomeFantasia, String cnpj, String email, String telefone, String nomeContato, List<EmpresaProjeto> projetos) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
        this.projetos = projetos;
    }

    public int getCodigo() {
        return codigo;
    }    
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNomeContato() {
        return nomeContato;
    }
    
    public List<EmpresaProjeto> getProjetos() {
        return projetos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public void setProjetos(List<EmpresaProjeto> projetos) {
        this.projetos = projetos;
    }
}
