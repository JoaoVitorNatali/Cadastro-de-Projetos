/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Empresa;

import modelo.Empresa;
import gerTarefas.gerInterface.custom.CustomTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Vitor
 */
public class TableModelEmpresa extends CustomTableModel<Empresa>{

    public TableModelEmpresa() {
        ArrayList<String> nomeColunas = new ArrayList<>(
            List.of("Empresa", "CNPJ", "E-mail")
        ); 
        this.setColunas(nomeColunas);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.detalhar(rowIndex).getNomeFantasia();
            
            case 1:
                return this.detalhar(rowIndex).getCnpj();
                
            case 2:
                return this.detalhar(rowIndex).getEmail();
            
            default:
                return this.detalhar(rowIndex);
        }
    }
    
}
