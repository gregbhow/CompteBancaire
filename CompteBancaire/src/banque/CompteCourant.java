/* Programme Banque
 * date : 20/5/2020
 * auteur : grego
 * 
 * Le programme Banque permet de gestionner differants comptes 
 * 
 */
package banque;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

////////compte courant classe fille de compte bancaire
public class CompteCourant extends CompteBancaire {
	/*
	 * declaration des variables
	 */
	private JFrame frame;
	public String prenom;
	public String nom;
	public long id;
	public String dob;
	public String adresse;
	public String sexe;

////////////methode creation compte
	public String[] creerCompte(String id, String Nom, String Prenom, String dob, String sexe, String adresse,
			String typeCompte, String solde) {
		
		frame = new JFrame();
		String[] split;
		String idConvert = id;
		String noCompteConvert = "000" + idConvert;
		int jj, mm, aaaa;
	    long noCompte = Long.valueOf(noCompteConvert);
		solde = "0";
		typeCompte = "COURANT";
		CompteCourant client = new CompteCourant();

		try {

			client.id = Long.parseLong(id);
			client.setNoCompte(noCompte);
			client.nom = Nom;
			client.prenom = Prenom;
			client.adresse = adresse;
			client.sexe = sexe;
			client.setTypeCompte(typeCompte);
			client.setSolde(Double.parseDouble(solde));

			split = dob.split("-");
			jj = Integer.parseInt(split[0]);
			mm = Integer.parseInt(split[1]);
			aaaa = Integer.parseInt(split[2]);

			if (jj < 0 || mm < 0 || aaaa < 1900) {
				JOptionPane.showMessageDialog(frame, "date invalide...veuillez réesayer");
			}

			if (jj > 31 || mm > 12 || aaaa > 2100) {
				JOptionPane.showMessageDialog(frame, "date invalide...veuillez réesayer");
			}

			client.dob = dob;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Erreur caractères invalides détecté...veuillez réesayer");
		}



		String[] tabJoint = { "000" + String.valueOf(client.getNoCompte()), " ", String.valueOf(client.id), " ",
				client.nom, " ", client.prenom, " ", client.dob, " ", client.adresse, " ", client.sexe, " ",
				client.getTypeCompte(), " ", String.valueOf(client.getSolde()), " ", "-", " ", "-", " ", "\n" };

		return tabJoint;

	}
};
