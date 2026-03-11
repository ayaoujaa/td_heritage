package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import model.client;
import model.compteBancaire;
import model.gestionnaireClient;

public class creation_client extends JFrame {
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldGenre;
    private JTextField textFieldDateN;
    private JTextField textFieldCateg;
    private JTextField textFieldAdresse;
    private JTextField textFieldTel;
    private JTextField textFieldEmail;

    public creation_client() {
        initialize();
    }

    private void initialize() {
        setTitle("Création de client");
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JLabel lblTitre = new JLabel("NOUVEAU CLIENT");
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setBounds(10, 11, 464, 14);
        getContentPane().add(lblTitre);
        
        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(20, 50, 100, 14);
        getContentPane().add(lblNom);
        
        textFieldNom = new JTextField();
        textFieldNom.setBounds(150, 47, 200, 20);
        getContentPane().add(textFieldNom);
        textFieldNom.setColumns(10);
        
        JLabel lblPrenom = new JLabel("Prénom :");
        lblPrenom.setBounds(20, 80, 100, 14);
        getContentPane().add(lblPrenom);
        
        textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(150, 77, 200, 20);
        getContentPane().add(textFieldPrenom);
        textFieldPrenom.setColumns(10);
        
        JLabel lblGenre = new JLabel("Genre (1=M, 2=F) :");
        lblGenre.setBounds(20, 110, 120, 14);
        getContentPane().add(lblGenre);
        
        textFieldGenre = new JTextField();
        textFieldGenre.setBounds(150, 107, 50, 20);
        getContentPane().add(textFieldGenre);
        textFieldGenre.setColumns(10);
        
        JLabel lblDateN = new JLabel("Date de naissance :");
        lblDateN.setBounds(20, 140, 120, 14);
        getContentPane().add(lblDateN);
        
        textFieldDateN = new JTextField();
        textFieldDateN.setBounds(150, 137, 100, 20);
        getContentPane().add(textFieldDateN);
        textFieldDateN.setColumns(10);
        
        JLabel lblCateg = new JLabel("Catégorie :");
        lblCateg.setBounds(20, 170, 100, 14);
        getContentPane().add(lblCateg);
        
        textFieldCateg = new JTextField();
        textFieldCateg.setBounds(150, 167, 200, 20);
        getContentPane().add(textFieldCateg);
        textFieldCateg.setColumns(10);
        
        JLabel lblAdresse = new JLabel("Adresse :");
        lblAdresse.setBounds(20, 200, 100, 14);
        getContentPane().add(lblAdresse);
        
        textFieldAdresse = new JTextField();
        textFieldAdresse.setBounds(150, 197, 200, 20);
        getContentPane().add(textFieldAdresse);
        textFieldAdresse.setColumns(10);
        
        JLabel lblTel = new JLabel("Téléphone :");
        lblTel.setBounds(20, 230, 100, 14);
        getContentPane().add(lblTel);
        
        textFieldTel = new JTextField();
        textFieldTel.setBounds(150, 227, 150, 20);
        getContentPane().add(textFieldTel);
        textFieldTel.setColumns(10);
        
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(20, 260, 100, 14);
        getContentPane().add(lblEmail);
        
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(150, 257, 200, 20);
        getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);
        
        JButton btnCreer = new JButton("Créer le client");
        btnCreer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creerClient();
            }
        });
        btnCreer.setBounds(150, 300, 120, 30);
        getContentPane().add(btnCreer);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnAnnuler.setBounds(280, 300, 80, 30);
        getContentPane().add(btnAnnuler);
    }
    
    private void creerClient() {
        try {
            String nom = textFieldNom.getText();
            String prenom = textFieldPrenom.getText();
            int genre = Integer.parseInt(textFieldGenre.getText());
            String dateN = textFieldDateN.getText();
            String categ = textFieldCateg.getText();
            String adresse = textFieldAdresse.getText();
            String tel = textFieldTel.getText();
            String email = textFieldEmail.getText();
            
            if (nom.isEmpty() || prenom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom et le prénom sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            ArrayList<compteBancaire> listeComptes = new ArrayList<>();
            client nouveauClient = new client(nom, prenom, genre, dateN, categ, adresse, tel, email, listeComptes);
            
            gestionnaireClient.ajouterClient(nouveauClient);
            
            JOptionPane.showMessageDialog(this, 
                "Client créé avec succès!\n" +
                "Nom: " + nouveauClient.getNom() + "\n" +
                "Prénom: " + nouveauClient.getPrenom() + "\n" +
                "Email: " + nouveauClient.getEmail(), 
                "Succès", 
                JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Le genre doit être un nombre (1 pour homme, 2 pour femme)", "Erreur de format", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la création du client: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   
}