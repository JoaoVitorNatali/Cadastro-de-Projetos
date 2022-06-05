/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Professor;

import modelo.Professor;
import gerTarefas.gerInterface.custom.CustomTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Vitor
 */
public class TableModelProfessor extends CustomTableModel<Professor>{

    public TableModelProfessor() {
        ArrayList<String> nomeColunas = new ArrayList<>(
            List.of("SIAPE", "Nome", "Coordenadoria", "E-mail")
        ); 
        this.setColunas(nomeColunas);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.detalhar(rowIndex).getSiape();
            
            case 1:
                return this.detalhar(rowIndex).getNome();
                
            case 2:
                return this.detalhar(rowIndex).getCoordenadoria();
            
            case 3:
                return this.detalhar(rowIndex).getEmail();
                
            default:
                return this.detalhar(rowIndex);
        }
    }
    
}
