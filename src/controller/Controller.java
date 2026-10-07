package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    /**Costruttore**/
    public Controller() {
        listaLezioni = new ArrayList<>();
        listaUtente = new ArrayList<>();
        listaInsegnamenti = new ArrayList<>();
        richieste = new ArrayList<>();
        listaAule = new ArrayList<>();
    }

    /**Aula**/
    private final ArrayList<Aula> listaAule;

    public List<Aula> getAule() {
        return listaAule;
    }

    public void aggiungiAula(Aula a) {
        listaAule.add(a);
    }

    /**LEZIONE*/
    private final ArrayList<Lezione> listaLezioni;

    public void aggiungiLezione(Lezione l) {
        if (esisteConflitto(l, null)) {
            throw new IllegalArgumentException(
                    "L'aula è già occupata in questo orario"
            );
        }

        listaLezioni.add(l);
    }

    public List<Lezione> getLezione() {
        return listaLezioni;
    }

    /**Docente**/
    public List<Docente> getDocenti() {
        List<Docente> docenti = new ArrayList<>();
        for (Utente u : listaUtente) {
            if (u instanceof Docente) {
                docenti.add((Docente) u);
            }
        }
        return docenti;
    }

    /**UTENTE*/
    private final ArrayList<Utente> listaUtente;

    public void aggiungiUtente(Utente u) {
        listaUtente.add(u);
    }

    /**LOGIN*/
    public Utente login(String login, String password) {
        for (Utente u : listaUtente) {
            if (u.getLogin().equals(login)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    //CHECK LOGIN
    public boolean utenteEsistente(String login) {
        for (Utente u : listaUtente) {
            if (u.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    //INSEGNAMENTI
    private final ArrayList<Insegnamento> listaInsegnamenti;

    public void aggiungiInsegnamento(Insegnamento i) {
        this.listaInsegnamenti.add(i);
    }

    public List<Insegnamento> getInsegnamenti() {
        return listaInsegnamenti;
    }

    //Gestione Conflitti
    public boolean esisteConflitto(Lezione nuovaLezione, Lezione daIgnorare) {
        for (Lezione l : listaLezioni) {

            // Ignora la lezione che stiamo spostando
            if (l == daIgnorare) {
                continue;
            }

            if (!l.getGiornoSettimana().equals(
                    nuovaLezione.getGiornoSettimana())) {
                continue;
            }

            boolean orarioConflitto =
                    nuovaLezione.getOraInizio().compareTo(l.getOraFine()) < 0
                            &&
                            nuovaLezione.getOraFine().compareTo(l.getOraInizio()) > 0;

            if (!orarioConflitto) {
                continue;
            }

            boolean stessaAula =
                    l.getAula().getNomeAula().equals(
                            nuovaLezione.getAula().getNomeAula()
                    );

            boolean stessoInsegnamento =
                    l.getInsegnamento().equals(
                            nuovaLezione.getInsegnamento()
                    );

            if (stessaAula || stessoInsegnamento) {
                return true;
            }
        }

        return false;
    }

    private final ArrayList<RichiestaSpostamento> richieste;

    public void aggiungiRichiesta(RichiestaSpostamento r) {
        richieste.add(r);
    }

    public List<RichiestaSpostamento> getRichieste() {
        return richieste;
    }

    public void approvaRichiesta(RichiestaSpostamento r) {
        Lezione l = r.getLezione();

        Lezione prova = new Lezione(
                l.getInsegnamento(),
                r.getNuovoGiorno(),
                r.getNuovaOraInizio(),
                r.getNuovaOraFine(),
                l.getAula()
        );

        if (esisteConflitto(prova, l)) {
            throw new IllegalArgumentException(
                    "Conflitto: spostamento non possibile"
            );
        }

        l.setgiornoSettimana(r.getNuovoGiorno());
        l.setOraInizio(r.getNuovaOraInizio());
        l.setOraFine(r.getNuovaOraFine());

        r.setApprovata(true);
    }
}



