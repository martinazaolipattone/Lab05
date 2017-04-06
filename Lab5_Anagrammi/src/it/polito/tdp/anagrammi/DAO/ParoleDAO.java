package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ParoleDAO {

	public boolean isCorrect(String parola){
		final String sql = "SELECT * FROM parola WHERE nome =?";

		try {
			Connection conn = ConnectionDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, parola);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				return true;
				
			}
			else return false;


		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	}

