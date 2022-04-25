/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Empresa;

import interfaceGrafica.Empresas.FormularioEmpresa;
import interfaceGrafica.MainWindow;
import javax.swing.JTable;

/**
 *
 * @author João Vitor
 */
public class GerenciadorEmpresa {
    private final FormularioEmpresa formularioEmpresa;
    private TableModelEmpresa tabelaEmpresas;

    public GerenciadorEmpresa(MainWindow janelaPrincipal, JTable jTable) {
        formularioEmpresa = new FormularioEmpresa(janelaPrincipal, true);
        
        tabelaEmpresas = new TableModelEmpresa();
        jTable.setModel(tabelaEmpresas);
    }
    
    public void abrirModalCriacao(){
        formularioEmpresa.abrirModalCriacao();
    }
    
    public void abrirModalEdicao(int codigo){
        formularioEmpresa.abrirModalEdicao(codigo);
    }
        
    public void abrirModalFiltragem(){
        formularioEmpresa.abrirModalFiltragem();
    }
}
