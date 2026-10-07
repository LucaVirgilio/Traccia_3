package gui;

import controller.Controller;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TableDocente {
    private JPanel panelloDocente;
    private JTable tabellaDocenti;
    public JScrollPane srollpane1;
    private JButton buttonSpostamento;
    private JButton indietroButton;
    public JFrame frame2;
    public final Controller controller;
    public Docente docenteLoggato;


    public TableDocente(JFrame frame,Controller controller,Docente docenteLoggato) {
        this.controller = controller;
        this.docenteLoggato = docenteLoggato;
        String[] colonne = {
                "Insegnamento",
                "Docente",
                "CFU",
                "Anno",
                "Giorno",
                "Ora Inizio",
                "Ora Fine",
                "Aula",
        };
        DefaultTableModel model = new DefaultTableModel(colonne, 0);
        ArrayList<Lezione> lezioniDocente = new ArrayList<>();
        for (Lezione l : controller.getLezione()) {
            if (l.getInsegnamento().getDocente().equals(docenteLoggato)) {
                lezioniDocente.add(l);
                Object[] riga = {
                        l.getInsegnamento().getNomeInsegnamento(),
                        l.getInsegnamento().getDocente(),
                        l.getInsegnamento().getCfu(),
                        l.getInsegnamento().getAnnoCorso(),
                        l.getGiornoSettimana(),
                        l.getOraInizio(),
                        l.getOraFine(),
                        l.getAula()
                };
                model.addRow(riga);
            }
        }
        tabellaDocenti.setModel(model);
        frame2 = new JFrame("Schermata Docente");
        frame2.setSize(600, 400);
        frame2.setContentPane(panelloDocente);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

        /**Bottone Richiesta Spostamento*/
        buttonSpostamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = tabellaDocenti.getSelectedRow();
                if (riga == -1) {
                    JOptionPane.showMessageDialog(null, "Selezione una Lezione");
                    return;
                }
                Lezione lezione = lezioniDocente.get(riga);
                RichiestaSpostamenti richiestaSpostamenti= new RichiestaSpostamenti(controller,frame2,lezione);

            }
        });

        /**Bottone torna Indietro*/
        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame2.setVisible(false);
            }
        });
    }
    }


