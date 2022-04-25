/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import modelo.Professor;
import gerTarefas.gerInterface.custom.CustomTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Vitor
 */
public class TableModelProfessoresProjeto extends CustomTableModel<Professor>{
    public TableModelProfessoresProjeto() {
        ArrayList<String> nomeColunas = new ArrayList<>(
            List.of("Nome", "SIAPE")
        ); 
        this.setColunas(nomeColunas);
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.detalhar(rowIndex).getNome();
                
            case 1:
                return this.detalhar(rowIndex).getSiape();

            default:
                return this.detalhar(rowIndex);
        }
    }
}
