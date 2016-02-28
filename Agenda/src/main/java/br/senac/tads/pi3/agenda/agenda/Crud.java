/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mauricio Gustavo
 * @author Leandro Rodrigues
 */
public class Crud {
    Connection c;
    String sql;
    PreparedStatement prepareStmt;
    ResultSet resSelect;
    
    //Metodo listar
    public void listarPessoas() throws SQLException, ClassNotFoundException {
        try {
            c = Conexao.obterConexao();
            sql = "SELECT * FROM TB_CONTATO";
            prepareStmt = c.prepareStatement(sql);
            resSelect = prepareStmt.executeQuery();

            while (resSelect.next()) {
                System.out.println("\nID_CONTATO: " + resSelect.getLong(1)
                        + " NM_CONTATO: " + resSelect.getString(2)
                        + " DT_NASCIMENTO: " + resSelect.getDate(3)
                        + " VL_TELEFONE: " + resSelect.getString(4)
                        + " VL_EMAIL: " + resSelect.getString(5)
                        + " DT_CADASTRO: " + resSelect.getTimestamp(6));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("\nErro: " + e);
        }
        finally{
            resSelect.close();
            prepareStmt.close();
            c.commit();
            c.close();
        }
    }
}