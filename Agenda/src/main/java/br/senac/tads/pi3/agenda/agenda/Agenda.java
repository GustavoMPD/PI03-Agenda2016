/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.agenda;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Mauricio Gustavo
 * @author Leandro Rodrigues
 */
public class Agenda {
    public static Scanner ler = new Scanner(System.in);
    public static int menu;
    
    public static void main (String[] args) throws ClassNotFoundException, SQLException{
        Crud crud = new Crud();
        do{
            menu = opcao();
            switch (menu){
                case 0:
                    //SAIR DO APP
                    System.out.println("\nObrigado por usar o App Agenda!!");
                    System.out.println("teste"
                            + "");
                    break;
                case 1:
                    //CHAMAR METODO INSERIR, DESENVOLVER ABAIXO
                    System.out.println("Incerir novo contato");
                    break;
                case 2:
                    //CHAMAR METODO REMOVER, DESENVOLVER ABAIXO
                    System.out.println("Remover contato");
                    break;
                case 3:
                    //CHAMAR METODO ATUALIZAR, DESENVOLVER ABAIXO
                    System.out.println("Atualizar contato");
                    break;
                case 4:
                    crud.listarPessoas();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }            
        }
        while(menu != 0);        
    }
    
    public static int opcao(){
        System.out.println("\nDigite 1 para inserir um novo contato!"
                         + "\nDigite 2 para remover um contato!"
                         + "\nDigite 3 para atualizar um contato!"
                         + "\nDigite 4 para listar os contatos cadastrados!"
                         + "\nDigite 0 para encerrar o App Agenda!");
     
        return ler.nextInt();
    }
    
}







