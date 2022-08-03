/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceGrafica.Formularios;

import gerTarefas.gerInterface.Constantes.TipoFormulario;

/**
 *
 * @author João Vitor
 * @param <ENTITY>
 */
public interface InterfaceFormulario<ENTITY> {
    public void alterarTituloModal();
    
    public TipoFormulario getTipo();
    
    public void setTipo(TipoFormulario tipo);
    
    public void setEntidadeSelecionada(ENTITY entidade);
    
    public void closeModal();
    
    public void showModal();
    
    public ENTITY toObject();
    
    public void setCamposFormulario(ENTITY entidade);
    
    public void limparCampos();
}
