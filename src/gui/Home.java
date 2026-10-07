package gui;
import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel Panelhome;
    private JButton StudenteR;
    private JButton DocenteR;
    private JButton Login;
    public JFrame frameChiamante;
    public final Controller controller;

    public Home(JFrame frame,Controller controller) {
        this.frameChiamante = frame;
        this.controller = controller;

        /**Pulsante Registrazione Studente*/
        StudenteR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistraStudente registraStudente = new RegistraStudente(frameChiamante,controller);
                frameChiamante.setVisible(false);
                registraStudente.frame.setVisible(true);
            }
        });

        /**Pulsante Registrazione Docente*/
        DocenteR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistraDocente registraDocente = new RegistraDocente(frameChiamante,controller);
                frameChiamante.setVisible(false);
                registraDocente.frame.setVisible(true);
            }
        });

        /**Pulsante Accesso*/
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accesso accesso = new Accesso(frameChiamante,controller);
                frameChiamante.setVisible(false);
                accesso.frame.setVisible(true);
            }
        });
    }

    /**Main*/
    public static void main(String[] args) {
            Controller controller = new Controller();
            JFrame frameChiamante = new JFrame("Home");
            frameChiamante.setSize(600,600);
            frameChiamante.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frameChiamante.setContentPane(new Home(frameChiamante, controller).Panelhome);
            frameChiamante.pack();
            frameChiamante.setVisible(true);
    }
}