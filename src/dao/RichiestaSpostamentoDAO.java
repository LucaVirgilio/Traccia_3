package dao;

import model.RichiestaSpostamento;
import java.util.List;

public interface RichiestaSpostamentoDAO {

    void inserisci(RichiestaSpostamento richiesta);

    List<RichiestaSpostamento> trovaTutte();

    List<RichiestaSpostamento> trovaInAttesa();

    void aggiorna(RichiestaSpostamento richiesta);

    void elimina(RichiestaSpostamento richiesta);
}