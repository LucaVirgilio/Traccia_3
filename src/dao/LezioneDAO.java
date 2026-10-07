package dao;

import model.Lezione;
import java.util.List;

public interface LezioneDAO {

    void inserisci(Lezione lezione);

    List<Lezione> trovaTutte();

    List<Lezione> trovaPerGiorno(String giorno);

    void aggiorna(Lezione lezione);

    void elimina(Lezione lezione);
}