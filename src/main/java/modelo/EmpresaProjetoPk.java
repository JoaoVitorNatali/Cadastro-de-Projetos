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
public class EmpresaProjetoPk implements Serializable {
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa")
    private Empresa empresa;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "projeto")
    private Projeto projeto;

    public EmpresaProjetoPk() {
    }

    public EmpresaProjetoPk(Empresa empresa, Projeto projeto) {
        this.empresa = empresa;
        this.projeto = projeto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
