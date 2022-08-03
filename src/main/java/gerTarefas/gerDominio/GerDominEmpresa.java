/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.EmpresaDao;
import java.util.List;
import modelo.Empresa;

/**
 *
 * @author João Vitor
 */
public class GerDominEmpresa extends TemplateGerenciadorDominio<Empresa> {

    public GerDominEmpresa() {
        super(new EmpresaDao());
    }
    
    @Override
    public List<Empresa> listar(){
        return getGenericDao().listar(Empresa.class);
    }

    @Override
    public List<Empresa> filtrar(Empresa entidade) {
        return getGenericDao().filtrar(Empresa.class, entidade);
    }
}
