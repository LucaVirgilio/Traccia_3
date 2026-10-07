package dao;

import model.Utente;

import java.util.List;

public interface UtenteDAO {
        void inserisci(Utente utente);

        Utente cercaPerLogin(String login);

        List<Utente> trovaTutti();

        boolean esisteLogin(String login);

        void elimina(Utente utente);
}
