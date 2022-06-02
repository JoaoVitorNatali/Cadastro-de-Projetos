/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import java.util.List;
import modelo.Empresa;

/**
 *
 * @author João Vitor
 */
public class GerDominEmpresa extends GenericGerenciadorDominio<Empresa> {

    @Override
    public List<Empresa> listar(){
        return getGenericDao().listar(Empresa.class);
    }
}
