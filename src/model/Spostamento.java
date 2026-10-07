package model;

public class Spostamento {
    protected String giorno;
    protected double orario;
    protected String stato;
    protected String lezione;


    public Spostamento(String giorno, int orario, String stato, String lezione) {
        this.giorno = giorno;
        this.orario = orario;
        this.stato = stato;
        this.lezione = lezione;
    }
}