/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.agenda;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Mauricio
 */
public class conexao1 {
    
    public static Connection abrirConexao() {
        Connection conn;
            
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(
            "jdbc:sqlite:C:\\Users\\Mauricio\\Documents\\Git\\PI03-Agenda2016-master\\agendabd.sqlite");
            conn.setAutoCommit(false);
            System.out.println("Conectado com banco");
            return conn;
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.out.println("nao conectado com banco");
            System.out.println("conexao \n"+e);
            return null;
        }

    }
    
}
