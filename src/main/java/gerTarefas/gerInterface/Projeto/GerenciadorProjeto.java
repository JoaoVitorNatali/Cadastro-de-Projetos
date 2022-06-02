/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import gerTarefas.gerDominio.GerDominProjeto;
import gerTarefas.gerInterface.GerenciadorInterface;
import gerTarefas.gerInterface.custom.GenericGerenciador;
import interfaceGrafica.MainWindow;
import interfaceGrafica.Projetos.FormularioProjeto;
import modelo.Projeto;
/**
 *
 * @author João Vitor
 */
public class GerenciadorProjeto extends GenericGerenciador<Projeto>{
    
    public GerenciadorProjeto(MainWindow janelaPrincipal, GerenciadorInterface gerInter) {
        super(janelaPrincipal, FormularioProjeto.class, TableModelProjeto.class, gerInter, GerDominProjeto.class);
    }
}
