/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.TableModels;

import gerTarefas.gerInterface.TableModels.CustomTableModel;
import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;

/**
 *
 * @author João Vitor
 */
public class TableModelEmpresasProjeto extends CustomTableModel<Empresa>{
    public TableModelEmpresasProjeto(){
        ArrayList<String> nomeColunas = new ArrayList<>(
                List.of("Nome", "CNPJ")
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
                
            default:
                return this.detalhar(rowIndex);
        }
    }
}
