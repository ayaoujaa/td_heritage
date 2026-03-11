package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class index extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    index window = new index();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public index() {
        initialize();
    }

    private void initialize() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JLabel Welcome = new JLabel("BIENVENUE");
        Welcome.setHorizontalAlignment(SwingConstants.CENTER);
        Welcome.setBounds(10, 11, 414, 14);
        getContentPane().add(Welcome);
        
        JButton btnNewButton = new JButton("Création client");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creation_client creationWindow = new creation_client();
                creationWindow.setVisible(true);
            }
        });
        btnNewButton.setBounds(20, 36, 125, 23);
        getContentPane().add(btnNewButton);
        
        JButton btnGestionClient = new JButton("Gestion clients");
        btnGestionClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestionClient gestionWindow = new gestionClient();
                gestionWindow.setVisible(true);
            }
        });
        btnGestionClient.setBounds(20, 70, 125, 23);
        getContentPane().add(btnGestionClient);
    }
}