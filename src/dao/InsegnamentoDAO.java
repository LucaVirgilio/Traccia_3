package dao;

import model.Insegnamento;
import java.util.List;

public interface InsegnamentoDAO {

    void inserisci(Insegnamento insegnamento);

    Insegnamento cercaPerNome(String nomeInsegnamento);

    List<Insegnamento> trovaTutti();

    void aggiorna(Insegnamento insegnamento);

    void elimina(Insegnamento insegnamento);
}