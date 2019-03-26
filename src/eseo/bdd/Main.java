package eseo.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/villeFrance?user=root&password=");
			Statement stm = connect.createStatement();

			ResultSet rset = stm.executeQuery("SELECT * FROM ville_france");

			while (rset.next()) {
				VilleFrance villeFrance = new VilleFrance();
				villeFrance.setCodeCommuneINSEE(rset.getString("Code_commune_INSEE"));
				villeFrance.setNomCommune(rset.getString("Nom_commune"));
				villeFrance.setCodePostal(rset.getString("Code_postal"));
				villeFrance.setLibelleAcheminement(rset.getString("Libelle_acheminement"));
				villeFrance.setLigne5(rset.getString("Ligne_5"));
				villeFrance.setLatitude(rset.getString("Latitude"));
				villeFrance.setLongitude(rset.getString("Longitude"));
				System.out.println(villeFrance.toString());
			}

			rset.close();
			stm.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}