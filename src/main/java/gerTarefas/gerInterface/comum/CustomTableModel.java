package gerTarefas.gerInterface.comum;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
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
    private List<Model> entidades = new ArrayList<>();
    private ArrayList<String> colunas;
    private JTable tabela;
    
    public void CustomTableModel(){
        this.colunas = new ArrayList<>();
    }
    
    public void setColunas(ArrayList<String> colunas){
        this.colunas = colunas;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
    
    public Model getSelected(){
        int linha = this.tabela.getSelectedRow();
        if(linha == -1) return null;
        return detalhar(linha);
    }
    
    public int getSelectedRow(){
        return this.tabela.getSelectedRow();
    }
    
    public Model detalhar(int rowIndex){
        return this.entidades.get(rowIndex);
    }
    
    public void adicionar(Model entidade){
        this.entidades.add(entidade);
        fireTableDataChanged();   
    }
    
    public void adicionar(List<Model> entidades){
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
