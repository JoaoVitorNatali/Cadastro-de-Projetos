package gerTarefas.gerInterface.custom;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author João Vitor
 * @param <Model>
 */
public abstract class CustomTableModel<Model> extends AbstractTableModel{
    private ArrayList<Model> entidades = new ArrayList<>();
    private ArrayList<String> colunas;
    
    public void CustomTableModel(){
        this.colunas = new ArrayList<>();
    }
    
    public void setColunas(ArrayList<String> colunas){
        this.colunas = colunas;
    }
    
    public Model detalhar(int rowIndex){
        return this.entidades.get(rowIndex);
    }
    
    public void adicionar(Model entidade){
        this.entidades.add(entidade);
        fireTableDataChanged();   
    }
    
    public void adicionar(ArrayList<Model> entidades){
        this.entidades = entidades;
        fireTableDataChanged();
    }
    
    public void removerEntidade(int rowIndex){
        this.entidades.remove(rowIndex);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.entidades.size() ;
    }

    @Override
    public int getColumnCount() {
        return this.colunas.size();
    }

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas.get(columnIndex);
    }
}
