package gui;

import javax.swing.*;
import model.Aula;
import controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaAula {
    public final Controller controller;
    private JPanel pannelloCreaAula;
    private JButton buttonCreaAula;
    private JTextField txtcreaAula;
    public JFrame framecreaAula;

    public CreaAula(Controller controller, JFrame frame4) {
        this.controller = controller;
        framecreaAula = new JFrame("Crea aula");
        framecreaAula.setSize(300, 300);
        framecreaAula.setContentPane(pannelloCreaAula);
        framecreaAula.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        framecreaAula.setVisible(true);

       /**Pulsante Crea Aula. Controlla anche che non esista già un aula con lo stesso nome*/
        buttonCreaAula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nomeAula = txtcreaAula.getText().trim();

                    if (nomeAula.isEmpty()) {
                        throw new Exception("Inserisci nome aula");
                    }

                    for (Aula a : controller.getAule()) {
                        if (a.getNomeAula().equalsIgnoreCase(nomeAula)) {
                            throw new Exception("Esiste già un'aula con questo nome");
                        }
                    }

                    Aula aula = new Aula(nomeAula);
                    controller.aggiungiAula(aula);

                    JOptionPane.showMessageDialog(
                            null,
                            "Aula creata con successo"
                    );

                    framecreaAula.dispose();
                    frame4.setVisible(true);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage()
                    );
                }
            }

        });
    }
    }

