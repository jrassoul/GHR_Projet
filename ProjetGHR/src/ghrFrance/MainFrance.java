package ghrFrance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
;

public class MainFrance {

	/**
	 * Permet de calculer le nombre de Jeunes cadres recrutés en 2019-2020
	 * @return nbr_jeune_cadre
	 */

	public int nbr_jeune_cadre(){
		int nbr_jeune_cadre=0;

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();
			System.out.println("Le nombre de jeunes cadres recrut?s en 2019-2020:");
			ResultSet result1 = statement.executeQuery("select count(nom_employe) as jeune from employe INNER JOIN contrat ON employe.id_employe=contrat.id_employe "
					+ " where statut_employe='cadre' "
					+ "and age_employe<30 and date_debut between '2019-01-01' and '2020-12-31';");

			while (result1.next()) {
				nbr_jeune_cadre = result1.getInt("jeune");


			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return nbr_jeune_cadre;

	}


	/**
	 * Permet de calculer le Montant global déboursé par l'entreprise dans les différents avantages
	 * @return total_avantage
	 */
	public int mont_glob_avantage(){

		int total_avantage=0;


		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();
			System.out.println(" ");
			System.out.println("Le montant global d?bours? par l'entreprise dans les diff?rents avantages est de : ");
			ResultSet result4 = statement.executeQuery("select SUM(montant_avantage)as tot_avantage from avantage;");
			while (result4.next()) {
				total_avantage=result4.getInt("tot_avantage");
				System.out.print(total_avantage);
				System.out.println("?"); }
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return total_avantage;
	}


	/**
	 * Permet de calculer le Salaire moyen d'un employé ayant au moins 3ans d'expérience
	 * @return salaire_moy
	 */

	public int salaire_moy(){
		int salaire_moy=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();
			System.out.println(" ");
			System.out.println("le salaire moyen d'un employ? ayant au moins 3ans d'exp?rience est de : ");
			ResultSet result5 = statement.executeQuery("select avg(salaire) as salaire_moyen  from employe INNER JOIN contrat on employe.id_employe=contrat.id_employe where"
					+ " DATE(NOW())-date_debut>1095 ;");
			while (result5.next()) {
				salaire_moy=result5.getInt("salaire_moyen");
				System.out.print(salaire_moy);
				System.out.println("?"); }


		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return salaire_moy;

	}


	/**
	 * Permet de calculer le Nombre d'employés qui ont bénéficies d'un pret pour l'achat d'une voiture
	 * @return nb_pret_voiture
	 */
	public int nb_pret_voiture(){

		int nb_pret_voiture=0;

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();


			System.out.println(" ");
			System.out.print("le nombre d'employ?s qui ont b?n?fici? d'un pret pour l'achat d'une voiture est:");
			ResultSet result6 = statement.executeQuery("select count(nom_employe)as nb_emp ,sum(montant_pret)as"
					+ " total_pret from \r\n"
					+ "employe inner join pret on employe.id_employe=pret.id_employe where type_pret='voiture' \r\n"
					+ " ;");
			while (result6.next()) {
				nb_pret_voiture =result6.getInt("nb_emp");
				System.out.print(nb_pret_voiture);
				System.out.print(" ");

				System.out.print("d'une valeure totale de:");
				nb_pret_voiture=result6.getInt("total_pret");
				System.out.print(nb_pret_voiture);
				System.out.println("?");

			}
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return nb_pret_voiture;
	}

	/**
	 * Permet de calculer le Nombre d'employés qui partent en retraite en 2030
	 * @return EMP_ret
	 */
	public int retraite_2030(){

		int  EMP_ret=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			System.out.println(" ");
			System.out.print("Le nombre d'employ?s qui partent en retraite en 203");
			Statement statement = connection.createStatement();
			ResultSet result9 = statement.executeQuery("select count(nom_employe) as EMP_ret from employe where ((2030-2021)+age_employe>=62);");
			while (result9.next()) {
				EMP_ret =result9.getInt("EMP_ret");
				System.out.print(EMP_ret);
				System.out.println(" ");

			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  EMP_ret;
	}


	/**
	 * Permet de calculer le Montant des avantages de l'employé qui en a bénéficié le plus
	 * @return avantage
	 */
	public int montant_max_avantage(){

		int avantage=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {


			Statement statement = connection.createStatement();
			System.out.println("");
			System.out.println("Montant des avantages de l'employ? qui en a b?n?fici? le plus");
			ResultSet result2 = statement.executeQuery("select sum(montant_avantage)as total_avantage "
					+ "from employe inner join \r\n"
					+ "avantage on employe.id_employe=avantage.id_employe group by nom_employe,prenom_employe order by\r\n"
					+ "total_avantage ASC ;");
			while (result2.next()) {
				avantage=result2.getInt("total_avantage");}
		}

		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return avantage;
	}


	/**
	 * Permet de calculer la Somme d'argent qu'il reste a récupérer des prets
	 * @return som_rest_pret
	 */
	public int argent_pret(){

		int  som_rest_pret=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();
			System.out.println(" ");
			System.out.println("la somme d'argent qui reste a r?cup?re dans les prets ");
			ResultSet result11 = statement.executeQuery(" \r\n"
					+ "    select sum(montant_pret - (salaire*poucentage_prlv_sem)) as total from employe inner join pret\r\n"
					+ "    on employe.id_employe=pret.id_employe;");
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
	 * Permet de calculer le Pourcentage des employers étrangers
	 * @return prc_etr
	 */
	public double emp_etrangers(){

		double tot_emp=0;
		double  tot_emp_etr=0;
		double  prc_etr=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();
			System.out.println(" ");
			System.out.println("pourcentage de variation de personnel de l'entreprise");
			ResultSet result12 = statement.executeQuery("select count(nom_employe)as tot_emp_etr from employe where \r\n"
					+ "nationalite_employe !='Fran?aise'");
			while (result12.next()) {
				tot_emp_etr =result12.getDouble("tot_emp_etr");

			}
			ResultSet result13 = statement.executeQuery("select count(nom_employe)as tot_emp from employe");
			while (result13.next()) {
				tot_emp =result13.getDouble("tot_emp");}

			prc_etr=(tot_emp_etr/tot_emp)*100;

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  prc_etr;
	}


	/**
	 * Permet de calculer le Pourcentage des employés qui travaillent en temps plein
	 * @return prc_plain
	 */

	public double temps_plein(){

		double tot_emp=0;
		double  plain=0;
		double  prc_plain=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();
			System.out.println(" ");
			System.out.println("pourcentage d'employ?s qui travallent en temps plein");
			ResultSet result20 = statement.executeQuery("select count(nom_employe) as emp_plain  from employe inner join contrat on  employe.id_employe=contrat.id_employe where nbr_heure_travail >=35;");
			while (result20.next()) {
				plain =result20.getDouble("emp_plain");}
			//System.out.print(tot_emp_etr);}

			ResultSet result23 = statement.executeQuery("select count(nom_employe)as tot_emp from employe ;");
			while (result23.next()) {
				tot_emp =result23.getDouble("tot_emp");}
			//System.out.print(tot_emp);


			prc_plain=(plain/tot_emp)*100;

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return  prc_plain;
	}


	/**
	 * Permet de calculer le Nombre d'employés licenciés
	 * @return nbr_emp_lic
	 */
	public int nbr_emp_lic(){
		int nbr_emp_lic=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "")) {
			Statement statement = connection.createStatement();
			System.out.println(" ");
			System.out.println("le nombre d'employ?s licenci?s");
			ResultSet result3 = statement.executeQuery("select  count(nom_employe ) as employe_licenci? from employe inner join"
					+ " absence on employe.id_employe=\r\n"
					+ "absence.id_employe  where motif_absence='sans_motif' and date_reprise-date_absence>=15 ;");
			while (result3.next()) {
				nbr_emp_lic=result3.getInt("employe_licenci?");

				; }


		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return nbr_emp_lic;
	}


	/**
	 * la fonction main qui est appelé en premier
	 * @param args
	 */
	public static void main(String[] args) {

		MainFrance c=new MainFrance();
		System.out.println(c.nbr_jeune_cadre());
		System.out.println(c.mont_glob_avantage());
		System.out.println(c.nb_pret_voiture());
		System.out.println(c.salaire_moy());
		System.out.println(c.argent_pret());
		System.out.println(c.temps_plein());
		System.out.println(c.emp_etrangers());
		System.out.println(c.retraite_2030());
		System.out.println(c.nbr_emp_lic());
		System.out.println(c.montant_max_avantage());



	}

}
