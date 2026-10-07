package dao;

import model.Docente;
import java.util.List;

public interface DocenteDAO {

    void inserisci(Docente docente);

    Docente cercaPerLogin(String login);

    List<Docente> trovaTutti();

    void elimina(Docente docente);
}