/* Programme Banque
 * date : 20/5/2020
 * auteur : grego
 * 
 * Le programme Banque permet de gestionner differants comptes 
 * 
 */
package banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Affichertype {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuCreer;
	private JMenuItem creerCompte;
	private JMenuItem fileQuitter;
	private JMenuItem fileAccueil;
	private JMenu menuAfficher;
	private JMenuItem afficherTypeCompte;
	private JMenuItem affichertToutCompte;
	private JMenu menuModifier;
	private JMenuItem supprimerCompte;
	private JButton btnRetour;
	private JScrollPane scrollPane;
	private JLabel lblAffichageDesComptes;
	@SuppressWarnings("rawtypes")
	private JComboBox typeDropdown;
	static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Affichertype window = new Affichertype();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Affichertype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 1200, 648);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/*
		 * Barre de Menu
		 */
		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setJMenuBar(menuBar);

		menuFile = new JMenu("Menu");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuFile);


		/*
		 * Option Quitter dans la barre de menu
		 */
		fileQuitter = new JMenuItem("Quitter");
		fileQuitter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fileQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("quitter");
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous r??element quitter l'appli banque?", "MoKass Bank",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(1);
				}
			}
		});
		menuFile.add(fileQuitter);
		
		/*
		 * Option Accueil dans la barre de menu
		 */
		fileAccueil = new JMenuItem("Accueil");
		fileAccueil.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fileAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("quitter");
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous r??element retourner a l'accueil?", "MoKass Bank",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					 Affichertype.this.frame.setVisible(false);
					 Banque.main(null);
				}
			}
		});
		menuFile.add(fileAccueil);

		menuCreer = new JMenu("Creer");
		menuCreer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCreer.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuCreer);
		/*
		 * Option Ajouter un nouveau compte dans la barre de menu
		 */
		creerCompte = new JMenuItem("Nouveau Compte");
		creerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affichertype.this.frame.setVisible(false);
				Add.main(null);
			}
		});

		creerCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCreer.add(creerCompte);

		menuAfficher = new JMenu("Afficher");
		menuAfficher.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAfficher.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuAfficher);

		/*
		 * Option affichage de tous les comptes dans la barre de menu
		 */

		affichertToutCompte = new JMenuItem("Tous les comptes");
		affichertToutCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affichertype.this.frame.setVisible(false);
				Affichertype.main(null);
			}
		});
		affichertToutCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAfficher.add(affichertToutCompte);

		/*
		 * Option affichage d'un type de compte dans la barre de menu
		 */
		afficherTypeCompte = new JMenuItem("Un type de compte / un compte sp??cifique");
		afficherTypeCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affichertype.this.frame.setVisible(false);
				Affichertype.main(null);
			}
		});
		afficherTypeCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAfficher.add(afficherTypeCompte);

		menuModifier = new JMenu("Modifier");
		menuModifier.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuModifier.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuModifier);
		/*
		 * Option suppression d'un compte dans la barre de menu
		 */
		supprimerCompte = new JMenuItem("Supprimer un compte");
		supprimerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affichertype.this.frame.setVisible(false);
				Delete.main(null);
			}
		});
		supprimerCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuModifier.add(supprimerCompte);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 69, 1158, 470);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NoCompte", "Id", "Nom", "Prenom",
				"D.O.B", "Adresse", "Sexe", "Type de Compte", "Solde", "ID 2 (C.joint)", "Taux(C.epargne)" }));
		scrollPane.setViewportView(table);

		CompteBancaire compte = new CompteBancaire();

		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affichertype.this.frame.setVisible(false);
				Banque.main(null);
			}
		});
		btnRetour.setBounds(432, 551, 98, 23);
		frame.getContentPane().add(btnRetour);

		lblAffichageDesComptes = new JLabel("Affichage des comptes");
		lblAffichageDesComptes.setFont(new Font("Dialog", Font.BOLD, 30));
		lblAffichageDesComptes.setBounds(432, 18, 500, 39);
		frame.getContentPane().add(lblAffichageDesComptes);

		typeDropdown = new JComboBox();
		typeDropdown.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				compte.affichertype(typeDropdown, table);
			}
		});
		typeDropdown.setBounds(992, 38, 178, 21);
		frame.getContentPane().add(typeDropdown);
		typeDropdown.addItem("COURANT");
		typeDropdown.addItem("JOINT");
		typeDropdown.addItem("EPARGNE");
	}
}
