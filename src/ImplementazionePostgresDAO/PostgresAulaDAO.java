package ImplementazionePostgresDAO;

import dao.AulaDAO;
import java.util.Collections;
import model.Aula;

import java.util.List;

public class PostgresAulaDAO implements AulaDAO {

    @Override
    public void inserisci(Aula aula) {}

    @Override
    public Aula cercaPerNome(String nomeAula) {
        return null;
    }

    @Override
    public List<Aula> trovaTutte() {
        return Collections.emptyList();
    }

    @Override
    public boolean esisteNome(String nomeAula) {
        return false;
    }

    @Override
    public void elimina(Aula aula) {

    }
}