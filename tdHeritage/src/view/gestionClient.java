package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.client;
import model.gestionnaireClient;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionClient extends JFrame {
    private JTable tableClients;
    private DefaultTableModel tableModel;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldGenre;
    private JTextField textFieldDateN;
    private JTextField textFieldCateg;
    private JTextField textFieldAdresse;
    private JTextField textFieldTel;
    private JTextField textFieldEmail;
    private client clientSelectionne = null;

    public gestionClient() {
        initialize();
        chargerClients();
    }

    private void initialize() {
        setTitle("Gestion des clients");
        setBounds(100, 100, 900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        // Panel principal avec BorderLayout
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        
        // Titre
        JLabel lblTitre = new JLabel("GESTION DES CLIENTS");
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblTitre, BorderLayout.NORTH);
        
        // Panel pour le tableau
        JPanel panelTableau = new JPanel();
        panelTableau.setLayout(new BorderLayout());
        panelPrincipal.add(panelTableau, BorderLayout.CENTER);
        
        // Création du tableau
        String[] colonnes = {"Nom", "Prénom", "Genre", "Date Naiss.", "Catégorie", "Adresse", "Téléphone", "Email"};
        tableModel = new DefaultTableModel(colonnes, 0) {
            
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableClients = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableClients);
        panelTableau.add(scrollPane, BorderLayout.CENTER);
        
        // Panel pour les boutons
        JPanel panelBoutons = new JPanel();
        panelPrincipal.add(panelBoutons, BorderLayout.SOUTH);
        
        JButton btnModifier = new JButton("Modifier le client sélectionné");
        btnModifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifierClientSelectionne();
            }
        });
        panelBoutons.add(btnModifier);
        
        JButton btnActualiser = new JButton("Actualiser la liste");
        btnActualiser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chargerClients();
            }
        });
        panelBoutons.add(btnActualiser);
        
        JButton btnFermer = new JButton("Fermer");
        btnFermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelBoutons.add(btnFermer);
        
        // Panel pour les détails du client (en bas)
        JPanel panelDetails = new JPanel();
        panelDetails.setLayout(null);
        panelPrincipal.add(panelDetails, BorderLayout.NORTH);
        
        // Titre section modification
        JLabel lblModification = new JLabel("MODIFICATION DES COORDONNÉES - Sélectionnez un client dans le tableau");
        lblModification.setHorizontalAlignment(SwingConstants.CENTER);
        lblModification.setBounds(10, 10, 864, 14);
        panelDetails.add(lblModification);
        
        // Nom
        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(20, 40, 80, 14);
        panelDetails.add(lblNom);
        
        textFieldNom = new JTextField();
        textFieldNom.setBounds(100, 37, 150, 20);
        panelDetails.add(textFieldNom);
        textFieldNom.setColumns(10);
        
        // Prénom
        JLabel lblPrenom = new JLabel("Prénom :");
        lblPrenom.setBounds(260, 40, 80, 14);
        panelDetails.add(lblPrenom);
        
        textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(340, 37, 150, 20);
        panelDetails.add(textFieldPrenom);
        textFieldPrenom.setColumns(10);
        
        // Genre
        JLabel lblGenre = new JLabel("Genre (1=M, 2=F) :");
        lblGenre.setBounds(500, 40, 100, 14);
        panelDetails.add(lblGenre);
        
        textFieldGenre = new JTextField();
        textFieldGenre.setBounds(610, 37, 50, 20);
        panelDetails.add(textFieldGenre);
        textFieldGenre.setColumns(10);
        
        // Date de naissance
        JLabel lblDateN = new JLabel("Date Naiss. :");
        lblDateN.setBounds(20, 70, 80, 14);
        panelDetails.add(lblDateN);
        
        textFieldDateN = new JTextField();
        textFieldDateN.setBounds(100, 67, 100, 20);
        panelDetails.add(textFieldDateN);
        textFieldDateN.setColumns(10);
        
        // Catégorie
        JLabel lblCateg = new JLabel("Catégorie :");
        lblCateg.setBounds(210, 70, 80, 14);
        panelDetails.add(lblCateg);
        
        textFieldCateg = new JTextField();
        textFieldCateg.setBounds(290, 67, 200, 20);
        panelDetails.add(textFieldCateg);
        textFieldCateg.setColumns(10);
        
        // Adresse
        JLabel lblAdresse = new JLabel("Adresse :");
        lblAdresse.setBounds(20, 100, 80, 14);
        panelDetails.add(lblAdresse);
        
        textFieldAdresse = new JTextField();
        textFieldAdresse.setBounds(100, 97, 390, 20);
        panelDetails.add(textFieldAdresse);
        textFieldAdresse.setColumns(10);
        
        // Téléphone
        JLabel lblTel = new JLabel("Téléphone :");
        lblTel.setBounds(500, 100, 80, 14);
        panelDetails.add(lblTel);
        
        textFieldTel = new JTextField();
        textFieldTel.setBounds(580, 97, 150, 20);
        panelDetails.add(textFieldTel);
        textFieldTel.setColumns(10);
        
        // Email
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(20, 130, 80, 14);
        panelDetails.add(lblEmail);
        
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(100, 127, 390, 20);
        panelDetails.add(textFieldEmail);
        textFieldEmail.setColumns(10);
        
        // Bouton pour appliquer les modifications
        JButton btnAppliquer = new JButton("Appliquer les modifications");
        btnAppliquer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appliquerModifications();
            }
        });
        btnAppliquer.setBounds(500, 127, 200, 23);
        panelDetails.add(btnAppliquer);
        
        // Écouteur de sélection sur le tableau
        tableClients.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableClients.getSelectedRow() != -1) {
                afficherDetailsClient(tableClients.getSelectedRow());
            }
        });
        
        // Ajuster la taille du panel de détails
        panelDetails.setPreferredSize(new java.awt.Dimension(900, 170));
    }
    
    private void chargerClients() {
        tableModel.setRowCount(0); // Vider le tableau
        
        for (client CLIENT : gestionnaireClient.getListeClients()) {
            Object[] ligne = {
                CLIENT.getNom(),
                CLIENT.getPrenom(),
                CLIENT.getGenre(),
                CLIENT.getDateN(),
                CLIENT.getCateg(),
                CLIENT.getAdresse(),
                CLIENT.getTel(),
                CLIENT.getEmail()
            };
            tableModel.addRow(ligne);
        }
    }
    
    private void afficherDetailsClient(int indexLigne) {
        if (indexLigne >= 0 && indexLigne < gestionnaireClient.getListeClients().size()) {
            clientSelectionne = gestionnaireClient.getListeClients().get(indexLigne);
            
            textFieldNom.setText(clientSelectionne.getNom());
            textFieldPrenom.setText(clientSelectionne.getPrenom());
            textFieldGenre.setText(String.valueOf(clientSelectionne.getGenre()));
            textFieldDateN.setText(clientSelectionne.getDateN());
            textFieldCateg.setText(clientSelectionne.getCateg());
            textFieldAdresse.setText(clientSelectionne.getAdresse());
            textFieldTel.setText(clientSelectionne.getTel());
            textFieldEmail.setText(clientSelectionne.getEmail());
        }
    }
    
    private void modifierClientSelectionne() {
        int selectedRow = tableClients.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un client à modifier", "Aucun client sélectionné", JOptionPane.WARNING_MESSAGE);
            return;
        }
        afficherDetailsClient(selectedRow);
    }
    
    private void appliquerModifications() {
        if (clientSelectionne == null) {
            JOptionPane.showMessageDialog(this, "Aucun client sélectionné", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Récupération des nouvelles valeurs
            String nom = textFieldNom.getText();
            String prenom = textFieldPrenom.getText();
            int genre = Integer.parseInt(textFieldGenre.getText());
            String dateN = textFieldDateN.getText();
            String categ = textFieldCateg.getText();
            String adresse = textFieldAdresse.getText();
            String tel = textFieldTel.getText();
            String email = textFieldEmail.getText();
            
            // Validation
            if (nom.isEmpty() || prenom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom et le prénom sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Mise à jour du client
            clientSelectionne.setNom(nom);
            clientSelectionne.setPrenom(prenom);
            clientSelectionne.setGenre(genre);
            clientSelectionne.setDateN(dateN);
            clientSelectionne.setCateg(categ);
            clientSelectionne.setAdresse(adresse);
            clientSelectionne.setTel(tel);
            clientSelectionne.setEmail(email);
            
            // Mise à jour du tableau
            chargerClients();
            
            JOptionPane.showMessageDialog(this, "Client modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Le genre doit être un nombre (1 pour homme, 2 pour femme)", "Erreur de format", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la modification: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}