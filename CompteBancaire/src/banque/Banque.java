/* Accueil Banque
 * Le programme Banque permet de gerer differants comptes 
 * @author gregory Bhowany
 * @version 2.0
 * 
 */
package banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Banque {

	private JFrame frame;
	private JPanel panel;
	private JButton btnQuitter;
	private JLabel lblCopyright;
	private JLabel lblTitre;
	private JLabel lblSubTitre;
	private JButton btnAjouter;
	private JButton btnAfficher;
	private JButton btnSupprimer;
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

	/**
	 * Launch the application.
	 */
	//////////// classe main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banque window = new Banque();
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
	public Banque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 444, 518);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(308, 416, 110, 26);
		panel.add(btnQuitter);

		lblCopyright = new JLabel("Copyright MoKass Inc");
		lblCopyright.setBounds(122, 423, 180, 14);
		panel.add(lblCopyright);
		lblCopyright.setBackground(SystemColor.inactiveCaptionBorder);
		lblCopyright.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 10));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);

		lblTitre = new JLabel("Mokass Bank Inc.");
		lblTitre.setBounds(24, 12, 383, 74);
		panel.add(lblTitre);
		lblTitre.setBackground(SystemColor.inactiveCaptionBorder);
		lblTitre.setForeground(new Color(0, 102, 204));
		lblTitre.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);

		lblSubTitre = new JLabel("pour un avenir radieux à vos cotés !");
		lblSubTitre.setBounds(102, 73, 214, 16);
		panel.add(lblSubTitre);
		lblSubTitre.setForeground(new Color(255, 204, 0));
		lblSubTitre.setHorizontalAlignment(SwingConstants.RIGHT);
		/*
		 * Redirection sur la page création de comptes en banque
		 */
		btnAjouter = new JButton("créer un nouveau compte");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Banque.this.frame.setVisible(false);
				Add.main(null);
			}
		});
		btnAjouter.setBounds(102, 156, 226, 26);
		panel.add(btnAjouter);
		/*
		 * Redirection sur la page affichage des comptes en banque.
		 */
		btnAfficher = new JButton("Afficher l'ensemble des comptes");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Banque.this.frame.setVisible(false);
				Affichertout.main(null);
			}
		});
		btnAfficher.setBounds(102, 224, 226, 26);
		panel.add(btnAfficher);
		/*
		 * Redirection sur la page suppression de comptes en banque
		 */
		btnSupprimer = new JButton("Supprimer un compte");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Banque.this.frame.setVisible(false);
				Delete.main(null);
			}
		});
		btnSupprimer.setBounds(102, 294, 226, 26);
		panel.add(btnSupprimer);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement quitter l'appli banque?", "MoKass Bank",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(1);
				}
			}
		});

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
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement quitter l'appli banque?", "MoKass Bank",
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
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement retourner a l'acceuil?", "MoKass Bank",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					 Banque.this.frame.setVisible(false);
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
				Banque.this.frame.setVisible(false);
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
				Banque.this.frame.setVisible(false);
				Affichertout.main(null);
			}
		});
		affichertToutCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAfficher.add(affichertToutCompte);

		/*
		 * Option affichage d'un type de compte dans la barre de menu
		 */
		afficherTypeCompte = new JMenuItem("Un type de compte / un compte spécifique");
		afficherTypeCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Banque.this.frame.setVisible(false);
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
				Banque.this.frame.setVisible(false);
				Delete.main(null);
			}
		});
		supprimerCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuModifier.add(supprimerCompte);
	}
}
