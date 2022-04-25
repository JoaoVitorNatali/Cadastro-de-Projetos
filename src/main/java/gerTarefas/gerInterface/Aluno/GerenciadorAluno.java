/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Aluno;

import interfaceGrafica.MainWindow;
import interfaceGrafica.Alunos.FormularioAluno;
import javax.swing.JTable;


/**
 *
 * @author João Vitor
 */
public class GerenciadorAluno {
    private final FormularioAluno formularioAluno;
    private TableModelAluno tabelaAlunos;

    public GerenciadorAluno(MainWindow janelaPrincipal, JTable jTable) {
        formularioAluno = new FormularioAluno(janelaPrincipal, true);
        tabelaAlunos = new TableModelAluno();
        jTable.setModel(tabelaAlunos);
    }
    
    public void abrirModalCriacao(){
        formularioAluno.abrirModalCriacao();
    }
    
    public void abrirModalEdicao(int codigo){
        formularioAluno.abrirModalEdicao(codigo);
    }
        
    public void abrirModalFiltragem(){
        formularioAluno.abrirModalFiltragem();
    }
}
