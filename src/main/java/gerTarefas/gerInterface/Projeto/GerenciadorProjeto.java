/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import interfaceGrafica.MainWindow;
import interfaceGrafica.Projetos.DadosProjeto;
import interfaceGrafica.Projetos.FormularioProjeto;
import javax.swing.JTable;

/**
 *
 * @author João Vitor
 */
public class GerenciadorProjeto {
    private final FormularioProjeto formularioProjeto;
    private final DadosProjeto janelaProjeto;
    private final TableModelProjeto tabelaProjetos;
    

    public GerenciadorProjeto(MainWindow janelaPrincipal, JTable jTable) {
        formularioProjeto = new FormularioProjeto(janelaPrincipal, true);
        janelaProjeto = new DadosProjeto(janelaPrincipal, true);
        
        tabelaProjetos = new TableModelProjeto();
        jTable.setModel(tabelaProjetos);
    }
    
    public void abrirModalCriacao(){
        formularioProjeto.abrirModalCriacao();
    }
    
    public void abrirModalEdicao(int codigo){
        formularioProjeto.abrirModalEdicao(codigo);
    }
        
    public void abrirModalFiltragem(){
        formularioProjeto.abrirModalFiltragem();
    }
    
    public void abrirProjeto(){
        janelaProjeto.setVisible(true);
    }
}
