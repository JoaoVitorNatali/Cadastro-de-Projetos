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
//    private ConexaoHibernate conn = null;

    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();
    }
    
//    public ConexaoHibernate getConn() {
//        return conn;
//    }
}
