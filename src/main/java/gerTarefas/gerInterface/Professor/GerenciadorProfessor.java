/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Professor;

import interfaceGrafica.MainWindow;
import interfaceGrafica.Professores.FormularioProfessor;
import javax.swing.JTable;

/**
 *
 * @author João Vitor
 */
public class GerenciadorProfessor {
    private final FormularioProfessor formularioProfessor;
    private TableModelProfessor tabelaProfessores;

    public GerenciadorProfessor(MainWindow janelaPrincipal, JTable jTable) {
        formularioProfessor = new FormularioProfessor(janelaPrincipal, true);
        
        tabelaProfessores = new TableModelProfessor();
        jTable.setModel(tabelaProfessores);
    }

    public void abrirModalCriacao(){
        formularioProfessor.abrirModalCriacao();
    }

    public void abrirModalEdicao(int codigo){
        formularioProfessor.abrirModalEdicao(codigo);
    }

    public void abrirModalFiltragem(){
        formularioProfessor.abrirModalFiltragem();
    }
}
