package com.example.emlakburada.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.emlakburada.model.User;

public class UserRepositoryJDBC extends JdbcConnectionRepository {

	private static final String INSERT_USER = "INSERT INTO USER (ID, NAME, EMAIL, PHONE_NUMBER) VALUES (?,?,?,?);";
	private static final String SELECT_ALL_USER = "SELECT * FROM USER";
	private static final String FIND_USER = "SELECT * FROM USER WHERE id = ?";

	public void save(User user) {

		Connection connection = connect();

		if (connection != null) {

			PreparedStatement prepareStatement = null;
			try {

				prepareStatement = connection.prepareStatement(INSERT_USER);
				prepareStatement.setLong(1, user.getId());
				prepareStatement.setString(2, user.getName());
				prepareStatement.setString(3, user.getEmail());
				prepareStatement.setString(4, user.getPhoneNumber());

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

	public List<User> findAll() {

		List<User> userList = new ArrayList<User>();

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_USER);

			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {

				Long id = result.getLong("id");
				String name = result.getString("name");
				String email = result.getString("email");
				String phoneNumber = result.getString("phone_number");

				userList.add(prepareUser(id, name, email, phoneNumber));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;

	}

	private User prepareUser(Long id, String name, String email, String phoneNumber) {
		User user = new User();

		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);

		return user;
	}

	public User findById(Long id) {
		User user = null;
		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(FIND_USER);
			prepareStatement.setLong(1, id);
			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				Long userId = result.getLong("id");
				String name = result.getString("name");
				String email = result.getString("email");
				String phoneNumber = result.getString("phone_number");
				user = prepareUser(userId, name, email, phoneNumber);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

}
