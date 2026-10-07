package gui;

import controller.Controller;
import model.Docente;
import model.Insegnamento;
import model.Responsabile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraDocente {
    private JPanel RegistraDocenti;
    private JTextField textNome;
    private JTextField textCognome;
    private JTextField textEmail;
    private JTextField textLogin;
    private JTextField textPassword;
    private JTextField textInsegnamento;
    public JLabel Insegnamento;
    private JButton RegisterButton;
    private JRadioButton RbSI;
    public JFrame frame;
    private JTextField CFU;
    private JComboBox<String> AnnoBox;
    public final ButtonGroup gruppoResponsabile;
    public final Controller controller;

    public RegistraDocente(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        this.AnnoBox.addItem("I");
        this.AnnoBox.addItem("II");
        this.AnnoBox.addItem("III");

        frame = new JFrame("Registra Docente");
        frame.setContentPane(RegistraDocenti);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        gruppoResponsabile = new ButtonGroup();
        gruppoResponsabile.add(RbSI);

        /**Bottone Registra Docente*/
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = textNome.getText().trim();
                    String cognome = textCognome.getText().trim();
                    String email = textEmail.getText().trim();
                    String login = textLogin.getText().trim();
                    String password = textPassword.getText().trim();
                    String insegnamento = textInsegnamento.getText().trim();

                   /** Nel caso in cui non si compili uno dei campi dia errore*/
                    if (nome.isEmpty() || cognome.isEmpty() || email.isEmpty()
                            || login.isEmpty() || password.isEmpty()
                            || insegnamento.isEmpty())
                    { throw new Exception("Compila tutti i campi");}


                    /**Messaggio se l'Utente esiste già*/
                    if (controller.utenteEsistente(login)) {
                        JOptionPane.showMessageDialog(frame, "Utente già registrato");
                        return;
                    }


                    /** Per scegliere se il docente è responsabile*/
                    if (RbSI.isSelected()) {
                        Responsabile r = new Responsabile(nome,cognome,email,login,password,insegnamento);
                        controller.aggiungiUtente(r);
                        int cfu = Integer.parseInt(CFU.getText());
                        String annoCorso = AnnoBox.getSelectedItem().toString();
                        Insegnamento ins = new Insegnamento(insegnamento,r,cfu,annoCorso);
                        controller.aggiungiInsegnamento(ins);
                    }
                    else {
                        Docente d = new Docente(nome,cognome,email,login,password,insegnamento);
                        controller.aggiungiUtente(d);
                        int cfu = Integer.parseInt(CFU.getText());
                        String annoCorso = AnnoBox.getSelectedItem().toString();
                        Insegnamento ins = new Insegnamento(insegnamento,d,cfu,annoCorso);
                        controller.aggiungiInsegnamento(ins);
                    }

                    /**Messaggio Registrazione riuscita con successo*/
                    JOptionPane.showMessageDialog(null,
                            "Registrazione completata");
                    frame.dispose();

                    frameChiamante.setVisible(true);



            } catch (Exception ex) {
                    //Messaggio Errore
                    JOptionPane.showMessageDialog(frame,
                            ex.getMessage());
                }
    }
});
    }
}
