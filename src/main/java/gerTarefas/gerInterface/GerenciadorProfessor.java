/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerInterface.TableModels.TableModelProfessor;
import gerTarefas.gerDominio.GerDominProfessor;
import interfaceGrafica.MainWindow;
import interfaceGrafica.Formularios.FormularioProfessor;
import modelo.Professor;

/**
 *
 * @author João Vitor
 */
public class GerenciadorProfessor extends TemplateGerenciadorInterface<Professor>{

    public GerenciadorProfessor(MainWindow janelaPrincipal, GerenciadorInterface gerenciadorInterface) {
        super(
                janelaPrincipal,
                new TableModelProfessor(), 
                gerenciadorInterface, 
                new GerDominProfessor()
        );
        
        this.formulario = new FormularioProfessor(janelaPrincipal, true, this);
    }
}
