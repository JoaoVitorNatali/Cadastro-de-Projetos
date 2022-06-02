/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Professor;

import gerTarefas.gerDominio.GerDominProfessor;
import gerTarefas.gerInterface.GerenciadorInterface;
import gerTarefas.gerInterface.custom.GenericGerenciador;
import interfaceGrafica.MainWindow;
import interfaceGrafica.Professores.FormularioProfessor;
import modelo.Professor;

/**
 *
 * @author João Vitor
 */
public class GerenciadorProfessor extends GenericGerenciador<Professor>{

    public GerenciadorProfessor(MainWindow janelaPrincipal, GerenciadorInterface gerInter) {
        super(janelaPrincipal, FormularioProfessor.class, TableModelProfessor.class, gerInter, GerDominProfessor.class);
    }
}
