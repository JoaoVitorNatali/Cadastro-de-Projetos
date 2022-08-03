/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerInterface.TableModels.TableModelAluno;
import gerTarefas.gerDominio.GerDominAluno;
import interfaceGrafica.MainWindow;
import interfaceGrafica.Formularios.FormularioAluno;
import modelo.Aluno;


/**
 *
 * @author João Vitor
 */
public class GerenciadorAluno extends TemplateGerenciadorInterface<Aluno>{

    public GerenciadorAluno(MainWindow janelaPrincipal, GerenciadorInterface gerenciadorInterface) {
        super(
                janelaPrincipal,
                new TableModelAluno(), 
                gerenciadorInterface,
                new GerDominAluno()
        );
        
        this.formulario = new FormularioAluno(janelaPrincipal, true, this);
    }
}
