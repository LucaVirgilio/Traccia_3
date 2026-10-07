package model;

public class Docente extends Utente {
    public String insegnamentoPrincipale;


    public Docente(String nome, String cognome, String email, String login, String password, String insegnamentoPrincipale) {
        super(nome, cognome, email, login, password);
        this.insegnamentoPrincipale = insegnamentoPrincipale;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
        }


