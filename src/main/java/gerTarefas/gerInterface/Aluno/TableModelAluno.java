/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Aluno;

import modelo.Aluno;
import gerTarefas.gerInterface.custom.CustomTableModel;
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
        
        criarArrayTesteAlunos();
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
    
    private void criarArrayTesteAlunos(){
        /**
        * Função criada para realizar os testes na montagem da tela. 
        * Quanodo tiver acesso ao banco, essa função irá sumir.
        */
        
        Aluno aluno1 = new Aluno("Joao Vitor Natali", "2019122760001", "Sistemas", "27999876501", "joao@gmail.com");
        Aluno aluno2 = new Aluno("Samuel Tessaro", "2019122760002", "Sistemas", "27999876502", "samuel@gmail.com");
        Aluno aluno3 = new Aluno("Gabriel Lasaro", "2019122760003", "Sistemas", "27999876503", "gabriel@gmail.com");
        Aluno aluno4 = new Aluno("Thalys Fabrete", "2019122760004", "Sistemas", "27999876504", "Thalys@gmail.com");
        Aluno aluno5 = new Aluno("Breno Luiz", "2019122760005", "Sistemas", "27999876505", "Breno@gmail.com");
        
        adicionar(aluno1);
        adicionar(aluno2);
        adicionar(aluno3);
        adicionar(aluno4);
        adicionar(aluno5);
        adicionar(aluno3);
        adicionar(aluno4);
        adicionar(aluno5);
    }
    
}
