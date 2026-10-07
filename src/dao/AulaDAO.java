package dao;

import model.Aula;
import java.util.List;

public interface AulaDAO {

    void inserisci(Aula aula);

    Aula cercaPerNome(String nomeAula);

    List<Aula> trovaTutte();

    boolean esisteNome(String nomeAula);

    void elimina(Aula aula);
}