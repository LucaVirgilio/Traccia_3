package model;

public class RichiestaSpostamento {

    private final Lezione lezione;
    private final String nuovoGiorno;
    private final String nuovaOraInizio;
    private final String nuovaOraFine;
    private boolean approvata;

    public RichiestaSpostamento(
            Lezione lezione,
            String nuovoGiorno,
            String nuovaOraInizio,
            String nuovaOraFine
    ) {
        this.lezione = lezione;
        this.nuovoGiorno = nuovoGiorno;
        this.nuovaOraInizio = nuovaOraInizio;
        this.nuovaOraFine = nuovaOraFine;
        this.approvata = false;
    }

    public Lezione getLezione() {
        return lezione;
    }
    public String getNuovoGiorno() {
        return nuovoGiorno;
    }
    public String getNuovaOraInizio() {
        return nuovaOraInizio;
    }
    public String getNuovaOraFine() {
        return nuovaOraFine;
    }
    public boolean isApprovata() {
        return approvata;
    }
    public void setApprovata(boolean approvata) {
        this.approvata = approvata;
    }
}
