/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package gerTarefas.gerInterface.Constantes;

import java.io.Serializable;

/**
 *
 * @author João Vitor
 */
public enum Coordenadoria implements Serializable {
    ADMINISTRACAO, ARQUITETURA, SISTEMAS;
    
    @Override
    public String toString(){
        switch(this){
            case ADMINISTRACAO:
                return "Administração";
            case ARQUITETURA:
                return "Arquitetura e Urbanismo";
            case SISTEMAS:
                return "Sistemas de Informação";
        }
        return null;
    }
}
