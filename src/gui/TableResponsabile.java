package gui;

import controller.Controller;
import model.Insegnamento;
import model.Responsabile;
import model.Lezione;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableResponsabile {
    private JPanel panelResponsabile;
    private JTable tableresponsabile1;
    private JButton CreaLezione;
    public JScrollPane scrollresponabile;
    private JButton buttonattivazione;
    private JButton buttonAulacrea;
    private JButton buttonSpostamenti;
    private JButton indietroButton;
    public JFrame frame4;
    public Controller controller;
    private DefaultTableModel model;
    private static TableResponsabile instance;

    public TableResponsabile(JFrame frame, Controller controller, Responsabile responsabileLoggato) {
        this.controller = controller;
        instance = this;

        String[] colonne = {
                "Insegnamento",
                "Docente",
                "CFU",
                "Anno",
                "Giorno",
                "Ora Inizio",
                "Ora Fine",
                "Aula",
                "Attivo",

        };
        model = new DefaultTableModel(colonne, 0);
        for (Lezione l : controller.getLezione()) {
            Insegnamento ins = l.getInsegnamento();
            Object[] riga = {
                    ins.getNomeInsegnamento(),
                    ins.getDocente().getNome() + " " + ins.getDocente().getCognome(),
                    ins.getCfu(),
                    ins.getAnnoCorso(),
                    l.getGiornoSettimana(),
                    l.getOraInizio(),
                    l.getOraFine(),
                    l.getAula().toString(),
                    ins.isCorsoAttivato() ? "Si" : "No",
            };
            model.addRow(riga);

        }
        tableresponsabile1.setModel(model);
        frame4 = new JFrame("Tabella Responsabile");
        frame4.setSize(400, 400);
        frame4.setContentPane(panelResponsabile);
        frame4.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame4.setVisible(true);

        /**Bottone Crea Lezione*/
        CreaLezione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreaLezione crealezione = new CreaLezione(controller, frame4,TableResponsabile.this);
                crealezione.frame.setVisible(true);
            }
        });

        /**Bottone Attiva Lezione*/
        buttonattivazione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = tableresponsabile1.getSelectedRow();

                if (riga == -1) {
                    JOptionPane.showMessageDialog(null,
                            "Seleziona un insegnamento");
                    return;
                }
                Lezione lezione = controller.getLezione().get(riga);
                Insegnamento ins = lezione.getInsegnamento();
                ins.setCorsoAttivato(!ins.isCorsoAttivato());
                aggiornaTabella();
            }
        });
        /**Bottone Crea Aula*/
        buttonAulacrea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreaAula creaAula = new CreaAula(controller,frame4);
                creaAula.framecreaAula.setVisible(true);

            }
        });

        /**Bottone spostastamenti*/
        buttonSpostamenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    GestioneRichieste gestionerichieste = new GestioneRichieste(controller);
            }
        });

        /**Bottone Indietro*/
        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame4.setVisible(false);
            }
        });
    }
    /**Aggiorna Tabella dopo aver aggiunto una lezione*/
    public void aggiornaTabella() {

        model.setRowCount(0);

        for (Lezione l : controller.getLezione()) {
            Object[] riga = {
                        l.getInsegnamento().getNomeInsegnamento(),
                        l.getInsegnamento().getDocente().getNome() + " " + l.getInsegnamento().getDocente().getCognome(),
                        l.getInsegnamento().getCfu(),
                        l.getInsegnamento().getAnnoCorso(),
                        l.getGiornoSettimana(),
                        l.getOraInizio(),
                        l.getOraFine(),
                        l.getAula().toString(),
                        l.getInsegnamento().isCorsoAttivato() ? "SI" : "NO"
                };

                model.addRow(riga);


            }
        }
    public static void refreshGlobal() {
        if (instance != null) {
            instance.aggiornaTabella();
        }
    }
    }


