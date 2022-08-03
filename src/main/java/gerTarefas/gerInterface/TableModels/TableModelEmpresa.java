/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.TableModels;

import modelo.Empresa;
import gerTarefas.gerInterface.TableModels.TemplateTableModel;
import gerTarefas.comum.ValidaCnpj;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Vitor
 */
public class TableModelEmpresa extends TemplateTableModel<Empresa>{

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
                return this.detalhar(rowIndex).getRazaoSocial();
            
            case 1:
                return ValidaCnpj.imprimeCNPJ(this.detalhar(rowIndex).getCnpj());
                
            case 2:
                return this.detalhar(rowIndex).getEmail();
            
            default:
                return this.detalhar(rowIndex);
        }
    }
    
}
