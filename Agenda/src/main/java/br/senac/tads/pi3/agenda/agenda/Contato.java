/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.agenda;

/**
 *
 * @author Mauricio
 */
public class Contato {

    private int idContato, vlTelefone;
    private String nmContato, dtNascimento, eMail;

    public Contato() {

    }

    public Contato(int idContato, int vlTelefone, String nmContato,
            String dtNascimento, String eMail) {
        this.idContato = idContato;
        this.vlTelefone = vlTelefone;
        this.nmContato = nmContato;
        this.dtNascimento = dtNascimento;
        this.eMail = eMail;
    }

    /**
     * @return the idContato
     */
    public int getIdContato() {
        return idContato;
    }

    /**
     * @return the vlTelefone
     */
    public int getVlTelefone() {
        return vlTelefone;
    }

    /**
     * @return the nmContato
     */
    public String getNmContato() {
        return nmContato;
    }

    /**
     * @return the dtNascimento
     */
    public String getDtNascimento() {
        return dtNascimento;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param idContato the idContato to set
     */
    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    /**
     * @param vlTelefone the vlTelefone to set
     */
    public void setVlTelefone(int vlTelefone) {
        this.vlTelefone = vlTelefone;
    }

    /**
     * @param nmContato the nmContato to set
     */
    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    /**
     * @param dtNascimento the dtNascimento to set
     */
    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

}
