/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.custom;

import gerTarefas.gerDominio.GerenciadorDominio;
import gerTarefas.gerInterface.Empresa.TableModelEmpresa;
import interfaceGrafica.Empresas.FormularioEmpresa;
import interfaceGrafica.MainWindow;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 *
 * @author João Vitor
 * @param <TableModel>
 */
public class GenericGerenciador<TableModel> {
    
    private final CustomFormularioInterface formulario;
    private CustomTableModel tabela;
    private GerenciadorDominio gerDom = null;

    public GenericGerenciador(MainWindow janelaPrincipal, JTable jTable) {
        formulario = (CustomFormularioInterface) new JDialog(janelaPrincipal, true);
        
        tabela = (CustomTableModel<TableModel>) new Object();
        
        jTable.setModel(tabela);
        gerDom = new GerenciadorDominio();
    }
    
    public void abrirModalCriacao(){
        formulario.abrirModalCriacao();
    }
    
    public void abrirModalEdicao(int codigo){
        formulario.abrirModalEdicao(codigo);
    }
        
    public void abrirModalFiltragem(){
        formulario.abrirModalFiltragem();
    }
}
