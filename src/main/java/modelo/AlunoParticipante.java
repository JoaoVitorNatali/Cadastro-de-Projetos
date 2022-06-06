/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author João Vitor
 */
@Entity
@Table(name = "aluno_participante")
public class AlunoParticipante implements Serializable {
    @EmbeddedId
    private AlunoParticipantePk codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrada;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;
    @Column(nullable=false)
    private int cargaHorariaSemanal;
    @Column(nullable=true)
    private double valorBolsa;
    @Column(nullable=false)
    private boolean bolsista;

    public AlunoParticipante() {
    }

    public AlunoParticipante(Aluno aluno, Projeto projeto, Date dataEntrada, Date dataSaida, int cargaHorariaSemanal, double valorBolsa, boolean bolsista) {
        this.codigo = new AlunoParticipantePk(aluno, projeto);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.valorBolsa = valorBolsa;
        this.bolsista = bolsista;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public double getValorBolsa() {
        return valorBolsa;
    }

    public boolean isBolsista() {
        return bolsista;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public void setValorBolsa(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public void setBolsista(boolean bolsista) {
        this.bolsista = bolsista;
    }
    
    
}
