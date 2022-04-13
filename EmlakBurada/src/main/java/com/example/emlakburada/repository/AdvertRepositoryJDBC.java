package com.example.emlakburada.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.emlakburada.model.Advert;

public class AdvertRepositoryJDBC extends JdbcConnectionRepository {

	private static final String INSERT_ADVERT = "INSERT INTO ADVERT (id, advert_no, description, active) VALUES (?,?,?,?);";
	private static final String SELECT_ALL_ADVERT = "SELECT * FROM ADVERT";
	private static final String FIND_ADVERT = "SELECT * FROM ADVERT WHERE id = ?";

	public void save(Advert advert) {

		Connection connection = connect();

		if (connection != null) {

			PreparedStatement prepareStatement = null;
			try {

				prepareStatement = connection.prepareStatement(INSERT_ADVERT);
				prepareStatement.setLong(1, advert.getId());
				prepareStatement.setLong(2, advert.getAdvertNo());
				prepareStatement.setString(3, advert.getDescription());
				prepareStatement.setBoolean(4, advert.getActive());

				int executeUpdate = prepareStatement.executeUpdate();

				System.out.println("result: " + executeUpdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Connection oluşturululamadı!");
		}

	}

	public List<Advert> findAll() {

		List<Advert> userList = new ArrayList<Advert>();

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_ADVERT);

			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {

				Long id = result.getLong("id");
				Long advertNo = result.getLong("advert_no");
				String description = result.getString("description");
				Boolean active = result.getBoolean("active");

				userList.add(prepareUser(id, advertNo, description, active));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;

	}

	private Advert prepareUser(Long id, Long advertNo, String description, Boolean active) {
		Advert advert = new Advert();

		advert.setId(id);
		advert.setAdvertNo(advertNo);
		advert.setDescription(description);
		advert.setActive(active);

		return advert;
	}

	public Advert findById(Long id) {
		Advert advert = null;
		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADVERT);
			prepareStatement.setLong(1, id);
			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				Long userId = result.getLong("id");
				Long advertNo = result.getLong("advert_no");
				String description = result.getString("description");
				Boolean active = result.getBoolean("active");
				advert = prepareUser(userId, advertNo, description, active);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advert;

	}

}
