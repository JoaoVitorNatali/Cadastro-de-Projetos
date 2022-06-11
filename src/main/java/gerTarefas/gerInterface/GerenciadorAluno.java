/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerInterface.TableModels.TableModelAluno;
import gerTarefas.gerDominio.GerDominAluno;
import gerTarefas.gerInterface.GerenciadorInterface;
import gerTarefas.gerInterface.comum.GenericGerenciador;
import interfaceGrafica.MainWindow;
import interfaceGrafica.Formularios.FormularioAluno;
import modelo.Aluno;


/**
 *
 * @author João Vitor
 */
public class GerenciadorAluno extends GenericGerenciador<Aluno>{

    public GerenciadorAluno(MainWindow janelaPrincipal, GerenciadorInterface gerInter) {
        super(janelaPrincipal, FormularioAluno.class, TableModelAluno.class, gerInter, GerDominAluno.class);
    }
}
