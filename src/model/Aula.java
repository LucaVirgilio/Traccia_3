package model;

public class Aula {
    protected String nomeAula;

    public Aula(String nomeAula) {
        this.nomeAula = nomeAula;
    }
    public String getNomeAula()
    {
        return nomeAula;
    }

    @Override
    public String toString() {
        return nomeAula;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Aula altraAula = (Aula) o;

        return nomeAula.equals(altraAula.nomeAula);
    }

    @Override
    public int hashCode() {
        return nomeAula.hashCode();
    }
}
