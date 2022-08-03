/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;

import gerTarefas.gerInterface.TableModels.TableModelEmpresa;
import gerTarefas.gerDominio.GerDominEmpresa;
import interfaceGrafica.Formularios.FormularioEmpresa;
import interfaceGrafica.MainWindow;
import modelo.Empresa;

/**
 *
 * @author João Vitor
 */
public class GerenciadorEmpresa extends TemplateGerenciadorInterface<Empresa>{
    
    public GerenciadorEmpresa(MainWindow janelaPrincipal, GerenciadorInterface gerenciadorInterface) {
        super(
                janelaPrincipal, 
                new TableModelEmpresa(),
                gerenciadorInterface, 
                new GerDominEmpresa()
        );
        
        this.formulario = new FormularioEmpresa(janelaPrincipal, true, this);
    }
}
