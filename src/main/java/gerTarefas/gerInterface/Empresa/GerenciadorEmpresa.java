/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface.Empresa;

import gerTarefas.gerDominio.GerDominEmpresa;
import gerTarefas.gerInterface.GerenciadorInterface;
import gerTarefas.gerInterface.comum.GenericGerenciador;
import interfaceGrafica.Empresas.FormularioEmpresa;
import interfaceGrafica.MainWindow;
import modelo.Empresa;

/**
 *
 * @author João Vitor
 */
public class GerenciadorEmpresa extends GenericGerenciador<Empresa>{
    
    public GerenciadorEmpresa(MainWindow janelaPrincipal, GerenciadorInterface gerInter) {
        super(janelaPrincipal, FormularioEmpresa.class, TableModelEmpresa.class, gerInter, GerDominEmpresa.class);
    }
}
