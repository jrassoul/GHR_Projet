package ghrAllemagne;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

public class MainAllemagne {

	public MainAllemagne() {

	}

	/**
	 * permet de renvoyer l'identifaint d'un employer grace au informations pass� en param�tres
	 * @param name
	 * @param lastName
	 * @param dateOfBirth
	 * @return result
	 */
	public String Id_employe(String name, String lastName, String dateOfBirth) {

		List<String> lines = null;
		String row;
		String[] data = new String[5];
		boolean find = false;
		String result = " ";

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			while ((row = csvReader.readLine()) != null && find == false) {
				data = row.split(",");
				/**
				 * si le nom, prenom et date de naissance pass� en param�tre sont �gale aux informations
				 * pass� en param�tre on sauvgarde son identifiant et on sort du while
				 */
				if (data[1].toUpperCase().equals(name.toUpperCase()) &&
						data[2].toUpperCase().equals(lastName.toUpperCase()) &&
						data[3].toUpperCase().equals(dateOfBirth.toUpperCase())) {
					find = true;
					result = data[0];
					//System.out.println(" result in if " + result);
				}
			}
			csvReader.close();

		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		System.out.println("result in return " + result);
		return result;
	}

	/**
	 * permet de renvoyer le salaire  de l'employer pass� en param�tre
	 * @param name
	 * @param lastName
	 * @param dateOfBirth
	 * @return result
	 * @throws NoSuchElementException
	 */

	public String salaire_employe(String name, String lastName, String dateOfBirth) throws NoSuchElementException {

		List<String> lines = null;
		String row;
		String[] data = new String[5];
		String[] salaire = new String[5];
		;
		boolean find = false;
		String result = "salaire_initial | salaire_montuel\n";

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));

			while ((row = csvReader.readLine()) != null && find == false) {
				data = row.split(",");
				/**
				 * si on a trouver l'employer on modifie l'information fint  pour ne pas continuer le parcours du fichier
				 */
				if (data[0].toUpperCase().equals(this.Id_employe(name, lastName, dateOfBirth))) {
					find = true;
					/**
					 * si il a plus de deux absence on soustrait de son salaire les jours absenter
					 */
					if (2 < parseInt(data[data.length - 2])) {
						int temp = parseInt(data[data.length - 3]);
						temp = temp - (temp / 30 * parseInt(data[data.length - 2]) - 3);
						result += data[data.length - 3] + " | " + String.valueOf(temp) + "\n";
						System.out.println(" result in if " + result);
					}
				}
			}
			csvReader.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("impossible de lire");
		}
		System.out.println("result in return " + result);
		return result;
	}

	/**
	 * permet de tous les pret d'un employer dans les informations sont donn�e en param�tre
	 * @param name
	 * @param lastName
	 * @param dateOfBirth
	 * @return result
	 * @throws NoSuchElementException
	 */

	public String search_pret_employe(String name, String lastName, String dateOfBirth) throws NoSuchElementException {

		List<String> lines = null;
		String row;
		String[] data = new String[5];
		boolean find = false;
		String result = " ";

		try {

			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
			row = txtReader.readLine();
			data = row.split(";");
			/**
			 * faire l'entete du tableau que on veut afficher
			 */
			for (int i = 1; i < data.length; i++)
				result += data[i] + "   ";
			result += "\n";
			/**
			 * parcours du fichier
			 */
			while (row != null && find == false) {
				/**
				 * si on trouve l'employer dans les infos ont �t� pass� en param�tre on modifie la variable find a vrai
				 */
				if (data[0].toUpperCase().equals(this.Id_employe(name, lastName, dateOfBirth))) {
					find = true;
					/**
					 * on ajoute toute la ligne a la variable result pour l'afficher
					 */
					for (int i = 1; i < data.length; i++)
						result += data[i] + "   ";

				}
				row = txtReader.readLine();
				data = row.split(";");
			}
			txtReader.close();

		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		//System.out.println("result in return " + result);
		return result;
	}

	/**
	 * permet d'avoir toutes les information de l'employer pass� en param�tre presentent dans les deux fichiers
	 * @param name
	 * @param lastName
	 * @param dateOfBirth
	 * @return result
	 * @throws NoSuchElementException
	 */

	public String infos_general_employe(String name, String lastName, String dateOfBirth) throws NoSuchElementException {

		List<String> lines = null;
		String row1 = null;
		String row2 = null;
		String[] data1 = new String[10];
		String[] data2 = new String[10];
		String result = " ";

		try {
			/**
			 * ouvertures des deux fichiers en mode lecture
			 */
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
			row1 = csvReader.readLine();
			row2 = txtReader.readLine();
			data1 = row1.split(",");
			data2 = row2.split(";");
			/**
			 * ajouter l'entet du premier fichier (Allemagne1.csv)
			 */
			for (int i = 1; i < data1.length; i++)
				result += data1[i] + "|";
			/**
			 * ajouet l'entet du deuxi�me fichier (Allemagne2.csv)
			 */

			for (int i = 1; i < data2.length; i++)
				result += data2[i] + "|";
			result += "\n";

			row1 = csvReader.readLine();
			boolean find = false;
			/**
			 * parcours du premier fichier
			 */
			while (row1 != null) {
				data1 = row1.split(",");
				/**
				 * parcours du deuxi�me fichier
				 */
				while (row2 != null) {
					data2 = row2.split(";");
					/**
					 * si l'employer est present dans le deuxi�me fichier
					 */
					if (data2[0].toUpperCase().equals(this.Id_employe(name, lastName, dateOfBirth))) {

						/**
						 * ajouter les informations de l'employer present dans le premier fichier
						 */
						for (int i = 1; i < data1.length; i++)
							result += data1[i] + "|";
						/**
						 * ajouter les informations de l'employer present dans le deuxi�me fichier
						 */

						for (int i = 1; i < data2.length; i++)
							result += data2[i] + "|";
						result += "\n";
					}
					row2 = txtReader.readLine();
				}
				row1 = csvReader.readLine();

			}
			/**
			 * fermeture des deux fichier
			 */
			txtReader.close();
			csvReader.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("impossible de lire");
		}
		//System.out.println("result in return " + result);
		/**
		 * renvoyer les informations de l'employer
		 */
		return result;
	}

	/**
	 * permet de calculer le nombre d'employer qui ont au plus 30 ans recruter entre deux ann�es et qui ont un statut
	 * donn� en param�tre
	 * @param annee
	 * @param annee1
	 * @param status
	 * @return compteur
	 */

	public  int nombre_employer_jeune_recruter_en(int annee, int annee1, String status) {

		/**
		 * convetir les ann�e pass� en param�tre en chaine de caract�res
		 */
		String annee_chaine = String.valueOf(annee);
		String annee1_chaine = String.valueOf(annee1);
		String row, row1;
		String[] data = new String[5];
		String[] date = new String[5];
		String[] naissance = new String[5];
		int compteur = 0;

		try {
			/**
			 * ouveture du premier fichier en mode l'ecture
			 */
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			row1 = csvReader.readLine();
			row = csvReader.readLine();
			/**
			 * en parcours le fichier
			 */
			while (row != null) {
				data = row.split(",");
				/**
				 * recuperation de la date de d�but du contrat de l'employer
				 */
				date = data[8].split("/");
				/**
				 * recuperation de la date de naissance de l'employer
				 */
				naissance = data[3].split("/");
				/**
				 * si l'ann�e de d�but du contrat de l'employer est entre les ann�es pass� en param�tre et
				 * il est n� apres l'ann�e 1991 et il a un statut cadre, on le compte
				 */
				if ((date[2].equals(annee_chaine) || date[2].equals(annee1_chaine)) &&
						1991 <= parseInt(naissance[2]) && data[5].equals(status)) {
					compteur += 1;

				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return compteur;

	}


	/**
	 * permet de calculer le nombre de pret d'un employer
	 * @param nom
	 * @param prenom
	 * @param dateOfBirth
	 * @return compteur
	 */

	public int nombre_de_pret_d_un_employer(String nom, String prenom, String dateOfBirth) {

		/**
		 * recuperer avec l'appel a la fonction identifier de l'employer pass� en param�tre
		 */
		String id_employer = this.Id_employe(nom, prenom, dateOfBirth);
		String row;
		String[] data;

		int compteur = 0;
		/**
		 * si l'identifier de l'employer existe
		 */
		if (id_employer != null) {
			try {
				/**
				 * ouveture du fichier en mode lecture
				 */
				BufferedReader txtReader = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
				row = txtReader.readLine();
				row = txtReader.readLine();
				/**
				 * parcours du fichier
				 */
				while (row != null) {
					data = row.split(";");
					/**
					 * si l'identifiant de l'employer est present dans le deuxi�me fichier qui contient
					 * que les prets on le compte
					 */
					if (data[0].toUpperCase().equals(id_employer)) {
						compteur += 1;
					}
					row = txtReader.readLine();
				}
				txtReader.close();
			} catch (Exception e) {
				System.out.println("impossible de lire");
			}
		}
		//System.out.println("nbr de pret de l'employer  " + id_employer + " est " + compteur);
		return compteur;
	}


	/**
	 * permet de calculer le nombre d'absence d'un employer
	 * @param nom
	 * @param prenom
	 * @param dateOfBirth
	 * @return absence
	 */

	public int nombre_absence_d_un_employer(String nom, String prenom, String dateOfBirth) {

		/**
		 * recuperer avec l'appel a la fonction identifier de l'employer pass� en param�tre
		 */
		String id_employer = this.Id_employe(nom, prenom, dateOfBirth);
		String row;
		String[] data;

		int absence = 0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			/**
			 * parcours du fichier
			 */
			while (row != null) {
				data = row.split(",");
				/**
				 * on recup�re le nombre d'absence de l'employer
				 */
				if (data[0].toUpperCase().equals(id_employer)) {
					absence = parseInt(data[10]);
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}

		//System.out.println("nbr d'absence de l'employer est " + absence);
		return absence;
	}

	/**
	 * permet de calculer la somme d'argent que l'entreprise va r�cuperer dans les prents
	 * @return somme
	 */

	public  int somme_argent_reste_a_recuperer_dans_les_prets() {

		String row;
		String[] data;
		String[] reste_a_regle;
		String[] montant_total;
		int somme = 0;
		try {
			/**
			 * ouverture du fichier en mode l'ecture
			 */
			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
			row = txtReader.readLine();
			row = txtReader.readLine();
			/**
			 * parcours du fichier (Allemagne2.txt)
			 */
			while (row != null) {
				data = row.split(";");
				/**
				 * on r�cup�re le montant total du pret
				 */
				montant_total = data[4].split(" ");
				/**
				 * on r�cup�re le montant que l'employer � d�ja r�gler
				 */
				reste_a_regle = data[3].split(" ");
				/**
				 * faire la soustraction (montant du pret - montant vers� par l'employer)
				 */
				somme += parseInt(montant_total[0]) - parseInt(reste_a_regle[0]);

				row = txtReader.readLine();
			}
			txtReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return somme;
	}

	/**
	 * permet de calculer le salaire moyen d'un employer ayant des ann�es d'experiance
	 * @param annee
	 * @return somme_salaire / nb_employer
	 */

	public  double le_salaire_moyen_des_employes_ayant_experience(int annee) {

		/**
		 * recuperer l'ann�e du d�but du contrat
		 */
		int annee_debut_contrat = 2021 - annee;
		String row;
		String[] data = new String[5];
		String[] date = new String[5];
		int nb_employer = 0;
		double somme_salaire = 0;

		try {
			/**
			 * ouverture du fichier en mode lecture
			 */
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			/**
			 * parcours du ichier
			 */
			while (row != null) {
				data = row.split(",");
				/**
				 * recuperer la date du contrat de l'employer
				 */
				date = data[8].split("/");
				/**
				 * si l'ann�e de d�but du contrat est �gale a l'ann�e calculer on le compte et on compte son salaire
				 */
				if (annee_debut_contrat == parseInt(date[2])) {
					nb_employer += 1;
					somme_salaire += Double.valueOf(data[9]);
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}

		return somme_salaire / nb_employer;
	}

	/**
	 * permet de calculer le nombre d'employer qui vont partir en retrait � une ann�e donn�e
	 * @param annee
	 * @return compteur
	 */

	public  int nombre_employer_qui_parttent_en_retraite_en(int annee) {

		/**
		 * convertir l'ann�e en une chaine de caracteres
		 */
		String annee_chaine = String.valueOf(annee);
		String row, row1;
		String[] data = new String[5];
		String[] naissance = new String[5];
		String[] date_debut_travail = new String[5];
		int age;
		int nb_annee_exp;
		int compteur = 0;

		try {
			/**
			 * ouveture du fichier en mode l'ecture
			 */
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			row1 = csvReader.readLine();
			row = csvReader.readLine();
			/**
			 * parcours du fichier
			 */
			while (row != null) {
				data = row.split(",");
				date_debut_travail = data[8].split("/");
				naissance = data[3].split("/");
				/**
				 * l'age que aura l'employer a l'ann�e donn�e en param�tre
				 */
				age = (2021 - parseInt(naissance[2])) + (annee - 2021);
				/**
				 * l'ann�e d'exp�riance que l'employer aura a l'ann�e donn�e en param�tre
				 */
				nb_annee_exp = (2021 - parseInt(date_debut_travail[2])) + (annee - 2021);

				/**
				 * si l'employer a au moins 42 d'ann�e d'exp�riance et il a au moins 62 ans
				 */
				if (nb_annee_exp >= 42 && 62 <= age) {
					compteur += 1;
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return compteur;

	}

	/**
	 * permet de calculer le nombre d'employer licencier
	 * @return compteur
	 */

	public  int nombre_employer_licencier() {

		String row;
		String[] data;
		String Licencier = "oui";
		int compteur = 0;

		try {
			/**
			 * ouverture du fichier en mode l'ecture
			 */
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			/**
			 * parcours du fichier
			 */
			while (row != null) {
				data = row.split(",");
				/**
				 * si l'employer est licencier on le compte
				 */
				if (data[11].equals(Licencier)) {
					compteur += 1;
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return compteur;
	}


	/**
	 * permet de calculer le montat que l'entreprise a d�bourser dans les avantages
	 * @return somme
	 */

	public  int montant_debourser_dans_avantages() {
		String row;
		String[] data;
		int somme = 0;

		try {
			/**
			 * ouverture du fichier en mode l'ecture
			 */
			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
			row = txtReader.readLine();
			row = txtReader.readLine();
			/**
			 * parcours du fichier
			 */
			while (row != null) {
				data = row.split(";");
				/**
				 * r�cuperer les montants des pret de chaque employer
				 */
				somme += parseInt(data[6]);

				row = txtReader.readLine();
			}
			txtReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return somme;

	}


	/**
	 * permet da calculer le nombre d'employer qui b�nifier d'un type d'un pret donn�
	 * @param type_pret
	 * @return somme
	 */

	public  int nb_employer_qui_beneficie_un_pret_de(String type_pret) {

		String row;
		String[] data;
		int somme = 0;
		try {
			/**
			 * ouverture du fichier en mode l'ecture
			 */
			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
			row = txtReader.readLine();
			row = txtReader.readLine();
			/**
			 * parcours du fichier
			 */
			while (row != null) {
				data = row.split(";");
				/**
				 * si le type du pret de l'employer est �gale � celui pass� en param�tre
				 */
				if (data[1].toUpperCase().equals(type_pret.toUpperCase())) {
					somme += 1;
				}
				row = txtReader.readLine();
			}
			txtReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return somme;
	}

	/**
	 * permet de calculer le montant de l'employer qui b�nificier de plus d'avantage
	 * @return montantMaxAvantage
	 */

	public  float montant_employes_benef_plus_avantages(){

		String row;
		String[] data;
		int nbmaxAvantage=0;
		float montantMaxAvantage=0;
		int idContact=0;
		int somme = 0;
		try {
			/**
			 * ouverture du fichier en mode l'ecture
			 */
			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
			row = txtReader.readLine();
			row = txtReader.readLine();

			/**
			 * parcours du fichier
			 */
			while (row != null) {
				data = row.split(";");
				/**
				 * data[7] case nombre d'avantage
				 * data[0] case ID
				 * data[6] montant avantage
				 */
				if (Integer.parseInt(data[7])>nbmaxAvantage) {
					nbmaxAvantage = Integer.parseInt(data[7]);
					idContact=Integer.parseInt(data[0]);
				}
				row = txtReader.readLine();
			}
			txtReader.close();

			BufferedReader txtReaderdeux = new BufferedReader(new FileReader("./csv/Allemagne2.txt"));
			row = txtReaderdeux.readLine();
			row = txtReaderdeux.readLine();
			/**
			 * parcours du fichier
			 */
			while (row != null) {
				data = row.split(";");
				if (montantMaxAvantage<Float.parseFloat(data[6])){
					montantMaxAvantage=Float.parseFloat(data[6]);
				}
				//System.out.println(data[21]);
				row = txtReaderdeux.readLine();
			}
			txtReaderdeux.close();

		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return montantMaxAvantage;
	}

	/**
	 * permet de calculer le pourcentage des employer etrang�
	 * @return (nb_employer_etrang�/nb_emplyer_de_entreprise)*100
	 */

	public  float  poucentage_des_employes_etrange() {

		String row;
		String[] data;
		int compteur = 0;
		int nb_employer=0;

		try {
			/**
			 * l'ouverture du fichier (Allegmagne1.csv) en mode l'ecture
			 */
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			/**
			 * le parcours du fichier
			 */
			while (row != null) {
				nb_employer+=1;
				data = row.split(",");
				/**
				 * si la nationelite de l'employer est diff�rente de Allemagne on compte l'employer
				 */
				if (!data[6].equals("Allemagne")) {
					compteur += 1;
				}
				row = csvReader.readLine();
			}
			/**
			 * fermeture du fichier ouvert
			 */
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}

		return ((float) compteur/(float) nb_employer)*100;
	}

	/**
	 * permet de calculer le pourcentage des employer qui travail � temps plein
	 * @return (nb_employer_temps_plein/nb_emplyer_de_entreprise)*100
	 */

	public  float  poucentage_des_employes_travail_temps_pleine() {

		String row;
		String[] data;
		int compteur = 0;
		int nb_employer=0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/Allemagne1.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			/**
			 * faire le parcours du fichier csv
			 */
			while (row != null) {
				nb_employer+=1;
				data = row.split(",");

				if (data[12].equals("temps_pleine")) {  /**   si le type du contrat de l'employer est a temps plein  */
					compteur += 1;
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		/**
		 * retourner le pourcentage
		 */
		return ((float) compteur/(float) nb_employer)*100;
	}

	/**
	 * la fonction main qui test les fonction
	 */


	public static void main(String[] args) {
	}

}

