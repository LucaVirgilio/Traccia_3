package model;

public class Studente extends Utente {
    public String matricola;
    protected String annoCorso;

    public Studente(String nome, String cognome, String email, String login, String password, String matricola, String annoCorso) {
        super(nome, cognome, email, login, password);
        this.matricola = matricola;
        this.annoCorso = annoCorso;
    }

    public String getAnnoCorso() {
        return annoCorso;
    }
}
