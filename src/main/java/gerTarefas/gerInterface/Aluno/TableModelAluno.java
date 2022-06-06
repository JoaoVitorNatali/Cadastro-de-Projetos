/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Aluno;

import modelo.Aluno;
import gerTarefas.gerInterface.comum.CustomTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Vitor
 */
public class TableModelAluno extends CustomTableModel<Aluno>{
    
    public TableModelAluno(){
        ArrayList<String> nomeColunas = new ArrayList<>(
                List.of("Nome", "E-mail", "Matricula", "Curso", "Telefone")
        ); 
        this.setColunas(nomeColunas);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.detalhar(rowIndex).getNome();
            
            case 1:
                return this.detalhar(rowIndex).getEmail();
                
            case 2:
                return this.detalhar(rowIndex).getMatricula();
                
            case 3:
                return this.detalhar(rowIndex).getCurso();
                
            case 4:
                return this.detalhar(rowIndex).getTelefone();
                
            default:
                return this.detalhar(rowIndex);
        }
    }    
}
