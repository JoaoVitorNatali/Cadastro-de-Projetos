/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Projeto;

import modelo.Aluno;
import gerTarefas.gerInterface.comum.CustomTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Vitor
 */
public class TableModelAlunosProjeto extends CustomTableModel<Aluno>{

    public TableModelAlunosProjeto(){
        ArrayList<String> nomeColunas = new ArrayList<>(
                List.of("Nome", "Matricula")
        ); 
        this.setColunas(nomeColunas);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.detalhar(rowIndex).getNome();
            
            case 1:
                return this.detalhar(rowIndex).getMatricula();
                
            default:
                return this.detalhar(rowIndex);
        }
    }
}
