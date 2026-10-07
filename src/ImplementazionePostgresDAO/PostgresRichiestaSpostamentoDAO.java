package ImplementazionePostgresDAO;

import dao.RichiestaSpostamentoDAO;
import java.util.Collections;
import model.RichiestaSpostamento;

import java.util.List;

public class PostgresRichiestaSpostamentoDAO implements RichiestaSpostamentoDAO {

    @Override
    public void inserisci(RichiestaSpostamento richiesta) {
    }

    @Override
    public List<RichiestaSpostamento> trovaTutte() {
        return Collections.emptyList();
    }

    @Override
    public List<RichiestaSpostamento> trovaInAttesa() {
        return Collections.emptyList();
    }

    @Override
    public void aggiorna(RichiestaSpostamento richiesta) {
    }

    @Override
    public void elimina(RichiestaSpostamento richiesta) {
    }
}
