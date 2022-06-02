/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import java.util.List;
import modelo.Projeto;

/**
 *
 * @author João Vitor
 */
public class GerDominProjeto extends GenericGerenciadorDominio<Projeto>{

    @Override
    public List<Projeto> listar() {
        return getGenericDao().listar(Projeto.class);
    }
    
}
