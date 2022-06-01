/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Empresa;

import gerTarefas.gerDominio.GerenciadorDominio;
import interfaceGrafica.Empresas.FormularioEmpresa;
import interfaceGrafica.MainWindow;
import java.util.ArrayList;
import javax.swing.JTable;
import modelo.Empresa;

/**
 *
 * @author João Vitor
 */
public class GerenciadorEmpresa {
    private final FormularioEmpresa formularioEmpresa;
    private TableModelEmpresa tabelaEmpresas;
    private GerenciadorDominio gerDom = null;

    public GerenciadorEmpresa(MainWindow janelaPrincipal, JTable jTable) {
        formularioEmpresa = new FormularioEmpresa(janelaPrincipal, true, this);
        
        tabelaEmpresas = new TableModelEmpresa();
        jTable.setModel(tabelaEmpresas);
        gerDom = new GerenciadorDominio();
    }
    
    public void abrirModalCriacao(){
        formularioEmpresa.abrirModalCriacao();
    }
    
    public void abrirModalEdicao(int codigo){
        formularioEmpresa.abrirModalEdicao(codigo);
    }
        
    public void abrirModalFiltragem(){
        formularioEmpresa.abrirModalFiltragem();
    }

    public void listar() {
        ArrayList<Empresa> lista = (ArrayList) gerDom.listarEmpresa();
        tabelaEmpresas.adicionar(lista);
    }

    public void inserir(String razaoSocial, String nomeFantasia, String cnpj, String telefone, String nomeContato, String email) {
        Empresa empresa = new Empresa(razaoSocial, nomeFantasia, cnpj, email, telefone, nomeContato);
        gerDom.inserirEmpresa(empresa);
        formularioEmpresa.closeModal();
    }
}
