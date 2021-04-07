package ghrChine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class MainChine {

	public MainChine() {

	}
	public Boolean existProfile(String lastName,String name,String dateOfBirth) throws NoSuchElementException {
		List<String> lines = null;
		String row;
		String[] data = new String[0];
		Boolean find = false;
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			while ((row = csvReader.readLine()) != null && find == false) {
				data = row.split(";");

				if (data[0].toUpperCase().equals(lastName.toUpperCase()) &&
						data[1].toUpperCase().equals(name.toUpperCase()) &&
						data[3].toUpperCase().equals(dateOfBirth.toUpperCase())) {
					find = true;
				}
			}
			csvReader.close();

		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return find;
	}

	public Map searchProfile(String lastName,String name,String dateOfBirth) throws NoSuchElementException {
		List<String> lines = null;
		String row;
		String[] data = new String[0];
		Boolean find = false;
		Map<String, String> infogeneral = new HashMap<String, String>();

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			while ((row = csvReader.readLine()) != null && find == false) {
				data = row.split(";");

				if (data[0].toUpperCase().equals(lastName.toUpperCase()) &&
				    data[1].toUpperCase().equals(name.toUpperCase()) &&
					data[3].toUpperCase().equals(dateOfBirth.toUpperCase())) {
					find = true;
				}
			}
			csvReader.close();

		} catch (Exception e) {
			System.out.println("impossible de lire");
		}

		if (find == true){
			infogeneral.put("lastname",data[0]);
			infogeneral.put("name",data[1]);
			infogeneral.put("dateOfbirth",data[3]);
			infogeneral.put("dateDebut",data[9]);
			infogeneral.put("contrat",data[7]);
			infogeneral.put("mail",data[5]);
			infogeneral.put("telephone",data[6]);
		}else{
			infogeneral.put("lastname","");
			infogeneral.put("name","");
			infogeneral.put("dateOfbirth","");
			infogeneral.put("dateDebut","");
			infogeneral.put("contrat","");
			infogeneral.put("mail","");
			infogeneral.put("telephone","");
		}
		return infogeneral;

	}

	public Object[][] RetraitéContats(ArrayList listContrat) throws NoSuchElementException, FileNotFoundException {
		List<String> lines = null;
		Object[][] objet = new Object[listContrat.size()][6];
		String row;
		String[] data = new String[0];
		Boolean find = false;
		Map<String, String> infogeneral = new HashMap<String, String>();

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));



				while ((row = csvReader.readLine()) != null) {
					for (int index=0;index<listContrat.size();index++){
					data = row.split(";");
					if (data[7].equals(listContrat.get(index))){
								objet[index][0]=data[7];
								objet[index][1]=data[0];
								objet[index][2]=data[1];
								objet[index][3]=data[9];
								objet[index][4]=data[5];
								objet[index][5]=data[6];
						}
				}


				}
			csvReader.close();

		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return objet;

	}

	public ArrayList<String> employer_qui_parttent_en_retraite_en(int annee){
		// convertir l'année en une chaine de caracteres

		ArrayList<String> employeRetraiteMap=new ArrayList<String>();
		String annee_chaine=String.valueOf(annee);
		String row,row1;
		String[] data = new String[5];
		String[] naissance = new String[5];
		String[] date_debut_travail = new String[5];
		int age;
		int nb_annee_exp;
		int compteur=0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				data = row.split(";");
				date_debut_travail = data[9].split("/");
				naissance = data[3].split("/");
				age=(2021-Integer.parseInt(naissance[2]))+(annee-2021);
				//System.out.println("age "+age);
				nb_annee_exp=(2021-Integer.parseInt(date_debut_travail[2]))+(annee-2021);
				//System.out.println("nb annee exp "+nb_annee_exp);
				if ( nb_annee_exp >=42  && 62<=age) {
					employeRetraiteMap.add(data[7]);
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return employeRetraiteMap;
	}

	//nb d'employées qui partent en retraite en 2030
	public int getNbEmployesRetraiteChine() {
		return employer_qui_parttent_en_retraite_en(2030).size();
	}
	// nb de jeune cadre qui ont été recrutés entre 2019-2020



	public int nombre_employer_qui_parttent_en_retraite_en(int annee){
		// convertir l'année en une chaine de caracteres
		String annee_chaine=String.valueOf(annee);
		String row,row1;
		String[] data = new String[5];
		String[] naissance = new String[5];
		String[] date_debut_travail = new String[5];
		int age;
		int nb_annee_exp;
		int compteur=0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				data = row.split(";");
				date_debut_travail = data[9].split("/");
				naissance = data[3].split("/");
				age=(2021-Integer.parseInt(naissance[2]))+(annee-2021);
				//System.out.println("age "+age);
				nb_annee_exp=(2021-Integer.parseInt(date_debut_travail[2]))+(annee-2021);
				//System.out.println("nb annee exp "+nb_annee_exp);
				if ( nb_annee_exp >=42  && 62<=age) {

					compteur+=1;

				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return compteur;
	}


	public double le_salaire_moyen_des_employes_ayant_experience_et_un_status(int annee,String status){

		int annee_debut_contrat=2021-annee;
		String row;
		String[] data = new String[5];
		String[] date = new String[5];
		int nb_employer=0;
		double somme_salaire=0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				data = row.split(";");
				date = data[9].split("/");
				if (annee_debut_contrat==Integer.parseInt(date[2]) && data[8].equals(status)) {
					nb_employer+=1;
					somme_salaire+=Double.valueOf(data[12]);
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return somme_salaire/nb_employer;
	}


	public int nombre_employer_jeune_recruter_en(int annee, int annee1, String status) {

		// convertir l'année en une chaine de caracteres

		String annee_chaine = String.valueOf(annee);
		String annee1_chaine = String.valueOf(annee1);
		String row, row1;
		String[] data = new String[5];
		String[] date = new String[5];
		String[] naissance = new String[5];
		int compteur = 0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row1 = csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				data = row.split(";");
				date = data[9].split("/");
				naissance = data[3].split("/");
				if ((date[2].equals(annee_chaine) || date[2].equals(annee1_chaine)) &&
						1998 <= Integer.parseInt(naissance[2]) && data[8].equals(status)) {
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


	public double le_salaire_moyen_des_employes_ayant_experience(int annee) {

		int annee_debut_contrat = 2021 - annee;
		String row;
		String[] data = new String[5];
		String[] date = new String[5];
		int nb_employer = 0;
		double somme_salaire = 0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				data = row.split(";");
				date = data[9].split("/");
				if (annee_debut_contrat == Integer.parseInt(date[2])) {
					nb_employer += 1;
					somme_salaire += Double.valueOf(data[12]);
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}

		return somme_salaire / nb_employer;
	}


	public int montant_debourse_avantage(){
		int montantTotal=0;
		String row;
		String[] data = new String[5];
		String montant = "";
		int nb_employer = 0;
		double somme_salaire = 0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));

			csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				data = row.split(";");
				montant = data[13];

				montantTotal+=Integer.valueOf(montant);

				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return montantTotal;
	}

	public int nb_de_personne_a_licencier(){
		int montantTotal=0;
		String row;
		String[] data = new String[5];
		String montant ="";
		int compteur = 0;
		String motif="";
		double somme_salaire = 0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));

			csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				data = row.split(";");
				montant =data[19];
				motif = data[20];

				if (Integer.valueOf(montant)>5 && motif.equals("sans")){
					compteur++;
				}

				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return compteur;
	}

	public  int nb_employer_qui_beneficie_un_pret_de(String type_pret) {

		String row;
		String[] data;
		int somme = 0;
		try {
			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = txtReader.readLine();
			row = txtReader.readLine();
			while (row != null) {
				data = row.split(";");


			if(data[15].toUpperCase().equals(type_pret.toUpperCase()) ){

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



	public  int somme_argent_reste_a_recuperer_dans_les_prets() {
		String row;
		String[] data;
		int montant_regle;
		int montant_total;
		int somme = 0;
		try {
			BufferedReader txtReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = txtReader.readLine();
			row = txtReader.readLine();
			while (row != null) {
				data = row.split(";");
				montant_total = Integer.parseInt(data[17]);
				montant_regle = Integer.parseInt(data[21]);
				somme += montant_total - montant_regle;

				//System.out.println(data[21]);
				row = txtReader.readLine();
			}
			txtReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		return somme;
	}


	 public  float montant_employes_benef_plus_avantages(){
		 String row;
		 String[] data;
		 int nbmaxAvantage=0;
		 float montantMaxAvantage=0;
		 int idContact=0;
		 int somme = 0;
		 try {
			 BufferedReader txtReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			 row = txtReader.readLine();
			 row = txtReader.readLine();

			 while (row != null) {
				 data = row.split(";");
					if (Integer.parseInt(data[23])>nbmaxAvantage) {
						nbmaxAvantage = Integer.parseInt(data[23]);
						idContact=Integer.parseInt(data[7]);
					}
				 row = txtReader.readLine();
			 }
			 txtReader.close();

		 	 BufferedReader txtReaderdeux = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
		 	 row = txtReaderdeux.readLine();
		 	 row = txtReaderdeux.readLine();
		 	 while (row != null) {
		 		 data = row.split(";");
		 			if (idContact==Integer.parseInt(data[7])) {
		 				if (montantMaxAvantage<Float.parseFloat(data[17])){
		 					montantMaxAvantage=Float.parseFloat(data[17]);
		 				}
		 			}
	 	 		 row = txtReaderdeux.readLine();
	 	 	 }
	 	 	 txtReaderdeux.close();

	 	 } catch (Exception e) {
	 	 	 System.out.println("impossible de lire");
	 	 }
	 	 return montantMaxAvantage;
	 }


	public  float poucentage_des_employes_etrange() {

		String row;
		String[] data;
		String nationalite = "Chine";
		int compteur = 0;
		int nb_employer=0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				nb_employer+=1;
				data = row.split(";");
	//			System.out.println("nationalites chaque employer "+data[4]);
				if (!data[4].equals("Chine")) {
	//				System.out.println(" in if ");
					compteur += 1;
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
	//	System.out.println("nb employer "+nb_employer);
	//	System.out.println("nb nationalites etrangères "+compteur);
		return ((float) compteur/(float) nb_employer)*100;
	}


	public double pourcentage_tempsPlein() {

		String row;
		String[] data;
		double[] pourcentage = new double[2];
		double nb_employesTempsPlein = 0.0;
		double nb_employes=0.0;
		double pourcentageTempsPlein=0.0;
		double pourcentageTempsPartiel=0.0;

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			row = csvReader.readLine();
			row = csvReader.readLine();
			while (row != null) {
				nb_employes+=1;
				data = row.split(";");
				//			System.out.println("nationalites chaque employer "+data[4]);
				if (data[10].equals("tempsPlein")) {
					nb_employesTempsPlein += 1;
				}
				row = csvReader.readLine();
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		pourcentageTempsPlein = (nb_employesTempsPlein/nb_employes)*100;

		return pourcentageTempsPlein;
	}




	public static void main(String[] args) throws FileNotFoundException {
			MainChine t=new MainChine();
			System.out.println(t.nombre_employer_jeune_recruter_en(2019,2020,"cadre"));
//			System.out.println(t.le_salaire_moyen_des_employes_ayant_experience(3));
//			System.out.println(t.montant_debourse_avantage());
//			System.out.println(t.nb_de_personne_a_convoquer());
//			System.out.println(t.employer_qui_parttent_en_retraite_en(2070).size());

//		System.out.println(nb_employer_qui_beneficie_un_pret_de("voiture"));
//		System.out.println(somme_argent_reste_a_recuperer_dans_les_prets());
//		System.out.println("le montant benef est: "+montant_employes_benef_plus_avantages());
//		System.out.println("poucentage_des_employes_etrange :"+poucentage_des_employes_etrange());
//			System.out.println(pourcentage_tempsPlein());
//			System.out.println(t.nb_de_personne_a_licencier());

	}
}

