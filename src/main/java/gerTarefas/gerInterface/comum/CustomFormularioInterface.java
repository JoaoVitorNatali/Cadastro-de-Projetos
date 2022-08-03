/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gerTarefas.gerInterface.comum;

import gerTarefas.gerInterface.Constantes.TipoFormulario;

/**
 *
 * @author João Vitor
 * @param <Entidade>
 */
public interface CustomFormularioInterface<Entidade> {
    public void alterarTituloModal();
    
    public TipoFormulario getTipo();
    
    public void setTipo(TipoFormulario tipo);
    
    public void setEntidadeSelecionada(Entidade entidade);
    
    public void closeModal();
    
    public void showModal();
    
    public Entidade toObject();
    
    public void setCamposFormulario(Entidade entidade);
    
    public void limparCampos();
}
