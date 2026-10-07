package gui;

import controller.Controller;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableStudente {
    private JPanel panelloStudente;
    private JTable tablestudent;
    public JScrollPane Scrollpane;
    private JButton buttonIndietro;
    public JFrame frame1;
    public final Controller controller;

    public TableStudente(JFrame frame,Controller controller, Studente studenteLoggato) {
        this.controller = controller;
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
        DefaultTableModel model = new DefaultTableModel(colonne,0);

        for (Lezione l : controller.getLezione()) {
            Insegnamento ins = l.getInsegnamento();
            if (ins.getAnnoCorso().equals(studenteLoggato.getAnnoCorso())
                    && ins.isCorsoAttivato()) {
                Object[] riga = {
                        ins.getNomeInsegnamento(),
                        ins.getDocente().getNome()+" "+ins.getDocente().getCognome(),
                        ins.getCfu(),
                        ins.getAnnoCorso(),
                        l.getGiornoSettimana(),
                        l.getOraInizio(),
                        l.getOraFine(),
                        l.getAula()
                };
                model.addRow(riga);
            }
        }
        frame1 = new JFrame("Schermata Studente");
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setSize(600,400);
        frame1.setContentPane(panelloStudente);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        tablestudent.setModel(model);
        frame1.setVisible(true);

        /**Bottone indietro*/
        buttonIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame1.setVisible(false);

            }
        });
    }
    }

