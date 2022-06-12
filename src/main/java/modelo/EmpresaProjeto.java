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
@Table(name = "empresa_projeto")
public class EmpresaProjeto implements Serializable {
    @EmbeddedId
    private EmpresaProjetoPk codigo;

    public EmpresaProjeto() {
    }

    public EmpresaProjeto(Empresa empresa, Projeto projeto) {
        this.codigo = new EmpresaProjetoPk(empresa, projeto);
    }

    public EmpresaProjetoPk getCodigo() {
        return codigo;
    }
}
