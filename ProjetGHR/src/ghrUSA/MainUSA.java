package ghrUSA;

import java.sql.*;


public class MainUSA {

	/**
	 * Permet de calculer le Nombre de jeunes cadres recrutés entre 2019 et 2020
	 * @return nbr_jeun_cadre
	 */
	public int nbr_jeune_cadre(){

		int nbr_jeun_cadre=0;
		try {// établire la Connexion à la base de données Postgresql
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			// récuprération de résultat de requete sql
			ResultSet result1 = statement.executeQuery("select count(nom_emp) as jeun from employe "
					+ " where statut_emp='cadre' "
					+ "and age_emp<30 and date_debut_travail_emp between '01-01-2019' and '31-12-2020';");
			while (result1.next()) {
				nbr_jeun_cadre = result1.getInt("jeun");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return nbr_jeun_cadre;
	}


	/**
	 * Permet de calculer le Nombre d'employés licenciés
	 * @return nbr_emp_licen_pi
	 */
	public int nbr_emp_lic(){

		int nbr_emp_licen_pi=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();

			ResultSet result3 = statement.executeQuery("select  count(nom_emp ) as employe_licencié from employe inner join"
					+ " absence on employe.id_emp=\r\n"
					+ "absence.id_emp  where motif_abs='sans_motif' and dure_abs>=7 and "
					+ "date_abs-date_debut_travail_emp<60;");
			while (result3.next()) {
				nbr_emp_licen_pi=result3.getInt("employe_licencié");


			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return nbr_emp_licen_pi;
	}


	/**
	 * permet de calculer le Montant global déboursé par l'entreprise dans les différents avantages
	 * @return total_avantage
	 */

	public int mont_glob_avantage(){

		int total_avantage=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();

			ResultSet result4 = statement.executeQuery("select SUM(montant_carnet)as tot_avantage from carnet_avantage;");
			while (result4.next()) {
				total_avantage=result4.getInt("tot_avantage");


			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return total_avantage;
	}

	/**
	 * Permet de calculer le Salaire moyen d'un employé ayant au moins 3ans d'expérience
	 * @return salaire_mo
	 */

	public int salaire_moy(){

		int salaire_moy=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();

			ResultSet result5 = statement.executeQuery("select avg(salaire_base_empl) as salaire_moyen from "
					+ "employe where"
					+ " DATE(NOW())-date_debut_travail_emp>1095 ;");
			while (result5.next()) {
				salaire_moy=result5.getInt("salaire_moyen");


			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return salaire_moy;
	}


	/**
	 * Permet de calculer le Nombre d'employés qui ont bénéficiés d'un pret immobilier
	 * @return nb_emp_IMOB
	 */
	public int pret_immob(){

		int nb_emp_IMOB=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();

			ResultSet result6 = statement.executeQuery("select count(nom_emp)as nb_emp_IMOB ,sum(montant_pret)as"
					+ " total_pret_IMOB from \r\n"
					+ "employe inner join pret on employe.id_emp=pret.id_emp where type_pret='immobiliere' \r\n"
					+ " ;");
			while (result6.next()) {
				nb_emp_IMOB =result6.getInt("nb_emp_IMOB");


			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return nb_emp_IMOB;
	}


	/**
	 * permet de calculer le Nombre d'employés qui ont bénéficiés d'un pret pour l'achat d'une voiture
	 * @return nb_emp_VOIT
	 */
	public int pret_voiture(){

		int  nb_emp_VOIT=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			ResultSet result7 = statement.executeQuery("select count(nom_emp)as nb_emp_VOIT ,sum(montant_pret)as total_pret_VOIT from \r\n"
					+ "employe inner join pret on employe.id_emp=pret.id_emp where type_pret='voiture' \r\n"
					+ " ;");
			while (result7.next()) {
				nb_emp_VOIT =result7.getInt("nb_emp_VOIT");



			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  nb_emp_VOIT;
	}


	/**
	 * Permet de calculer le Nombre d'employés qui ont bénéficiés d'un pret pour une prise en charge medicale
	 * @return nb_emp_MAL
	 */

	public int pret_medical(){

		int  nb_emp_MAL=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			ResultSet result8 = statement.executeQuery("select count(nom_emp)as nb_emp_MAL ,sum(montant_pret)as"
					+ " total_pret_MAL from \r\n"
					+ "employe inner join pret on employe.id_emp=pret.id_emp where type_pret='charge_medicale' \r\n"
					+ " ;");
			while (result8.next()) {
				nb_emp_MAL =result8.getInt("nb_emp_MAL");
				System.out.print(nb_emp_MAL);



			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  nb_emp_MAL;
	}


	/**
	 * permet de calculer le Nombre d'employés qui partent en retraite en 2030
	 * @return EMP_ret
	 */

	public int retraire_2030(){

		int  EMP_ret=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			ResultSet result9 = statement.executeQuery("select count(nom_emp) as EMP_ret from employe where ((2030-2021)+age_emp>=62);");
			while (result9.next()) {
				EMP_ret =result9.getInt("EMP_ret");
				System.out.print(EMP_ret);



			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  EMP_ret;
	}


	/**
	 * Permet de calculer le montant total d'avantage de l'employé qui a bénificier de plus de nous avantage
	 * @return max_avnt
	 */

	public int emp_max_avnt(){

		int  max_avnt=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			ResultSet result10 = statement.executeQuery(" select sum(montant_carnet)as total_avantage \r\n"
					+ "                       from employe inner join \r\n"
					+ "                       carnet_avantage on employe.id_emp=carnet_avantage.id_emp\r\n"
					+ "					   group by nom_emp order by\r\n"
					+ "                       total_avantage DESC\r\n"
					+ "					   limit 1;");
			while (result10.next()) {
				max_avnt=result10.getInt("total_avantage");
				//System.out.print(max_avnt);



			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return max_avnt ;
	}


	/**
	 * Permet de calculer la Somme d'argent qu'il reste à récupérer des prets
	 * @return som_rest_pret
	 */

	public int argent_pret(){

		int  som_rest_pret=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			ResultSet result11 = statement.executeQuery(" \r\n"
					+ "    select sum ( montant_pret - (salaire_base_empl*poucentage_prlv_pret_mois)) as total from employe inner join pret\r\n"
					+ "	on employe.id_emp=pret.id_emp;");
			while (result11.next()) {
				som_rest_pret=result11.getInt("total");
				//System.out.print(max_avnt);



			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return som_rest_pret  ;
	}


	/**
	 * Permet de calculer le Pourcentage de variation du personnel de l'entreprise
	 * @return prc_etr
	 */

	public double variation_personnel(){

		double tot_emp=0;
		double  tot_emp_etr=0;
		double  prc_etr=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			ResultSet result12 = statement.executeQuery("select count(nom_emp)as tot_emp_etr from employe where \r\n"
					+ "						nationalite_emp !='Américaine';");
			while (result12.next()) {
				tot_emp_etr =result12.getDouble("tot_emp_etr");
				//System.out.print(tot_emp_etr);}

				ResultSet result13 = statement.executeQuery("select count(nom_emp)as tot_emp from employe ;");
				while (result13.next()) {
					tot_emp =result13.getDouble("tot_emp");}}
			//System.out.print(tot_emp);


			prc_etr=(tot_emp_etr/tot_emp)*100;

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  prc_etr;
	}


	/**
	 * Permet de calculer le Pourcentage des employés en temps plein dans l'entreprise
	 * @return prc_plain
	 */

	public double temps_plein(){

		double tot_emp=0;
		double  plain=0;
		double  prc_plain=0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			ResultSet result20 = statement.executeQuery("select count(nom_emp) as pof  from employe where nb_heure_travail_mois >=140;");
			while (result20.next()) {
				plain =result20.getDouble("pof");
				//System.out.print(tot_emp_etr);}

				ResultSet result23 = statement.executeQuery("select count(nom_emp)as tot_emp from employe ;");
				while (result23.next()) {
					tot_emp =result23.getDouble("tot_emp");}}
			//System.out.print(tot_emp);


			prc_plain=(plain/tot_emp)*100;

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  prc_plain;
	}


	/**
	 * Permet d'afficher le graphe
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public String affichage(String nom,String prenom){

		String message ="";
		try {

			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SE_USA", "postgres",
					"Jb_00000");
			Statement statement = connection.createStatement();
			//if(lastName="hanri"){
			ResultSet result8 = statement.executeQuery("select statut_emp,age_emp,nationalite_emp,nb_heure_travail_mois," +
					"salaire_base_empl from employe where nom_emp='"+nom+"' and prenom_emp='"+prenom+"'");

			while (result8.next()) {
				String statut=result8.getString("statut_emp");

				String salaire=result8.getString("salaire_base_empl");

				message="statut employe:"+statut+"         "+"Salaire employe:"+salaire;}

			ResultSet result9 = statement.executeQuery("SELECT type_tickets,montant_carnet FROM employe inner join carnet_avantage\n" +

					"on employe.id_emp=carnet_avantage.id_emp where nom_emp='"+nom+"' and prenom_emp='"+prenom+"'");
			while (result9.next()) {

				String val_avant = result9.getString("montant_carnet");

				message= message+"montant d'avantage:"+val_avant;}



		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return message;
	}

	public static void main(String[] args) {

		MainUSA c=new MainUSA();
		System.out.println("Le nombre de jeunes cadres recrutés en 2019-2020 est: ");
		System.out.println(c.nbr_jeune_cadre());
		System.out.println("Le nombre total d'employés licenciés est:  ");
		System.out.println(c. nbr_emp_lic());
		System.out.println("Le montant total d'argent dépencé par l'entreprise dans les différents avantages est :");
		System.out.println(c.mont_glob_avantage());
		System.out.println("Le salaire moyen d'un employé de l'entreprise");
		System.out.println(c.salaire_moy());
		System.out.println(" Le nombre d'employés qui ont bénéficier d'un pret immobilier");
		System.out.println(c.pret_immob());
		System.out.println("Le nombre d'employés qui ont bénéficier d'un pret voiture ");
		System.out.println(c.pret_voiture());
		System.out.println("Le nombre d'employés qui ont bénéficier d'un pret pour charges médicales ");
		System.out.println(c.pret_medical());
		System.out.println("Le nombre d'employés qui partes en retraite en 2030");
		System.out.println(c.retraire_2030());
		System.out.println("le pourcentage des employés qui travaillent en temps plain");
		System.out.println(c.temps_plein());
		System.out.println("Le pourcentage de variation de l'entreprise");
		System.out.println(c.variation_personnel());
		System.out.println("le montant qui reste a récupérer dans les prets");
		System.out.println(c.argent_pret());
		System.out.println("le montant total d'avantage de l'employé qui a bénificier de plus des avantages proposés:");
		System.out.println(c.emp_max_avnt());

	}}