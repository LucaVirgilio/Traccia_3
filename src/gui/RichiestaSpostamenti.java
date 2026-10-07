package gui;

import controller.Controller;
import model.Lezione;
import model.RichiestaSpostamento;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class RichiestaSpostamenti {
    private JPanel panlSpostamento;
    private JComboBox giornocombobox;
    private JTextField txtnewinizio;
    private JTextField textnewfine;
    private JButton buttonInvia;
    public JFrame frameSpostamento;
    private Controller controller;
    private TableResponsabile tableResponsabile;

    public RichiestaSpostamenti(Controller controller, JFrame frame2, Lezione lezione) {
        this.controller = controller;
        frameSpostamento = new JFrame("Richiesta Spostamenti");
        frameSpostamento.setContentPane(panlSpostamento);
        frameSpostamento.setSize(500, 500);
        frameSpostamento.setLocationRelativeTo(null);
        frameSpostamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSpostamento.pack();
        frameSpostamento.setVisible(true);

        giornocombobox.addItem("Lunedì");
        giornocombobox.addItem("Martedì");
        giornocombobox.addItem("Mercoledì");
        giornocombobox.addItem("Giovedì");
        giornocombobox.addItem("Venerdì");

        /**bottone Crea Spostamento*/
        buttonInvia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (giornocombobox.getSelectedItem() == null) {
                        throw new Exception("Seleziona un giorno");
                    }
                    String nuovoGiorno = giornocombobox.getSelectedItem().toString();
                    String nuovaOraInizio = txtnewinizio.getText();
                    String nuovaOraFine = textnewfine.getText();
                    LocalTime inizio = LocalTime.parse(nuovaOraInizio);
                    LocalTime fine = LocalTime.parse(nuovaOraFine);
                    if (!fine.isAfter(inizio)) {
                        throw new Exception("Orario non valido");
                    }

                    RichiestaSpostamento r = new RichiestaSpostamento(lezione, nuovoGiorno, nuovaOraInizio, nuovaOraFine);
                    controller.aggiungiRichiesta(r);
                    JOptionPane.showMessageDialog(null, "Richiesta Spostamento aggiunto");
                    frameSpostamento.dispose();
                    if (tableResponsabile != null) {
                        tableResponsabile.aggiornaTabella();
                    }
                 /**Obbligo del formato orario*/
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato orario: HH:mm");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }

        });


    }

    public void setTableResponsabile(TableResponsabile tableResponsabile) {
        this.tableResponsabile = tableResponsabile;

    }
}

