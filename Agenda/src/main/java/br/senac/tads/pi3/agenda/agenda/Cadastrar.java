/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.agenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class Cadastrar {

    public static Contato contato = new Contato();
    public static Connection c = null;
    public static PreparedStatement ps = null;
    public static String sql = null;
    public static ResultSet rs = null;
    public static Scanner ler = new Scanner(System.in);

    public static void cadastrarContato() throws SQLException {
        incerirDados();

        try {
            c = conexao1.abrirConexao();
            sql = "INSERT INTO TB_CONTATO (NM_CONTATO, DT_NASCIMENTO, "
                    + "VL_TELEFONE, VL_EMAIL)"
                    + "values (?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, contato.getNmContato());
            ps.setString(2, contato.getDtNascimento());
            ps.setInt(3, contato.getVlTelefone());
            ps.setString(4, contato.geteMail());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            fecharConexao();
        }
    }   

    public static void incerirDados() {
        System.out.println("informe Nome");
        contato.setNmContato(ler.next());
        System.out.println("informe Telefone");
        contato.setVlTelefone(ler.nextInt());
        System.out.println("infrome Data de Nascimento");
        contato.setDtNascimento(ler.next());
        System.out.println("informe E-Mail");
        contato.seteMail(ler.next());
    }

    public static void fecharConexao() throws SQLException {
        ps.close();
        c.commit();
        c.close();
    }

}
