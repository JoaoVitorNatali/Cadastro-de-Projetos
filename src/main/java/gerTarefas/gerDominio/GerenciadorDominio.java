/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerDominio;

import dao.ConexaoHibernate;

/**
 *
 * @author João Vitor
 */
public class GerenciadorDominio {

    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();   
    }
}
