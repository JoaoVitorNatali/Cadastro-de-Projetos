/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gerTarefas.gerInterface.comum;

import gerTarefas.gerInterface.Constantes.TipoFormulario;

/**
 *
 * @author João Vitor
 * @param <ENTIDADE>
 */
public interface CustomFormularioInterface<ENTIDADE> {
    public void alterarTituloModal();
    
    public TipoFormulario getTipo();
    
    public void setTipo(TipoFormulario tipo);
    
    public void setEntidadeSelecionada(ENTIDADE entidade);
    
    public void closeModal();
    
    public void showModal();
    
    public ENTIDADE toObject();
    
    public void setCamposFormulario(ENTIDADE entidade);
    
    public void limparCampos();
}
