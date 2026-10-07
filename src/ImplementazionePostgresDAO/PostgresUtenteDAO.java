package ImplementazionePostgresDAO;

import dao.UtenteDAO;
import java.util.Collections;
import model.Utente;

import java.util.List;

public class PostgresUtenteDAO implements UtenteDAO {

    @Override
    public void inserisci(Utente utente) {
    }

    @Override
    public Utente cercaPerLogin(String login) {
        return null;
    }

    @Override
    public List<Utente> trovaTutti() {
        return Collections.emptyList();
    }

    @Override
    public boolean esisteLogin(String login) {
        return false;
    }

    @Override
    public void elimina(Utente utente) {
    }
}