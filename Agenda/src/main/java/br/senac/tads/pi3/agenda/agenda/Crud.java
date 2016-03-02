/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.agenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Mauricio Gustavo
 * @author Leandro Rodrigues
 */
public class Crud {
    Connection c;
    String sql;
    PreparedStatement prepareStmt;
    ResultSet resSelect;
    Statement state;
    Scanner ler = new Scanner(System.in);
    
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
    
    //metodo Atualizar
    public void atualizar() throws ParseException, SQLException{
        DateFormat dt = DateFormat.getInstance();
        String nome, telefone, email;
        Date date;
        
        System.out.println("\nDigite o nome que deseja atualizar: ");
        nome = ler.next();
        System.out.println("\nDigite o telefone: ");
        telefone = ler.next();
        System.out.println("\nDigite o email: ");
        email = ler.next();
        System.out.println("\nDigite a data de nascimento no formato dd/mm/yyyy: ");
        date = (Date) dt.parse(ler.next());
                
        try{
            c = Conexao.obterConexao();
            sql = "UPDATE TB_CONTATO "
                    + "SET NM_CONTATO = " + nome
                    + "DT_NASCIMENTO = " + date
                    + "VL_TELEFONE = " + telefone
                    + "VL_EMAIL = " + email
                    + "WHERE TB_CONTATO.NM_CONTATO = " + nome;
            state = c.createStatement();
            state.execute(sql);
            state.close();
        }
        catch(SQLException | ClassNotFoundException e){
            System.out.println("\nErro: " + e);
        }
        finally{
            c.commit();
            c.close();
        }
    }
}