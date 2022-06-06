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

    public void abrirModalEdicao(int codigo);

    public void abrirModalCriacao();

    public void abrirModalFiltragem();

    public void alterarTituloModal();
    
    public TipoFormulario getTipo();
    
    public void closeModal();
    
    public Entidade toObject();
}
