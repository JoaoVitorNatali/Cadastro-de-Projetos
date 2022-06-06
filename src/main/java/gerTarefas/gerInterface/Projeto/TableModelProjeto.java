/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import modelo.Projeto;
import gerTarefas.gerInterface.comum.CustomTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Vitor
 */
public class TableModelProjeto extends CustomTableModel<Projeto>{

    public TableModelProjeto() {
        ArrayList<String> nomeColunas = new ArrayList<>(
            List.of("Título", "Data de Início", "Data de Finalização")
        ); 
        this.setColunas(nomeColunas);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.detalhar(rowIndex).getTitulo();
            
            case 1:
                return this.detalhar(rowIndex).getDataInicio();
                
            case 2:
                return this.detalhar(rowIndex).getDataFim();
                
            default:
                return this.detalhar(rowIndex);
        }
    }
}
