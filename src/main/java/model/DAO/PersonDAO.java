package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BEAN.Person;

public class PersonDAO {
	private static final String CHECK_LOGIN = "SELECT count(*) as count FROM person where id_person=? and password=?";
	private static final String CREATE_PERSON = "INSERT INTO person(name, password, role, phone, email, CCCD, gender,address, dob, img)\r\n"
			+ "values(?,?,?,?,?,?,?,?,?,?);\r\n";
	private static final String GET_ALL_PERSON = "SELECT * FROM person;";
	private static final String GET_PERSON_BY_ID = "SELECT * FROM person where id_person=?;";
	private static final String UPDATE_PERSON = "UPDATE person "
			+ "SET name=?, role=?, phone=?, email=?, CCCD=?, gender=?, address=?, dob=?, img=? "
			+ "WHERE id_person=?;";
	private static final String DELETE_PERSON = "DELETE FROM person WHERE id_person=?;";
	private static final String GET_PASSWORD_PERSON = "SELECT password FROM person where id_person=?;";
	private static final String GET_NAME_PERSON = "SELECT name FROM person where id_person=?;";
	private static final String GET_ROLE_PERSON = "SELECT role FROM person where id_person=?;";
	
	//lvd
	private static final String UPDATE_PASSWORD = "UPDATE person\r\n"
												+ "SET password = ? WHERE id_person = ?;";
	private static final String CHECK_PHONENUMBER_DUPLICATE = "SELECT count(*) as count FROM person where phone=? and not id_person=?;";
	private static final String CHECK_EMAIL_DUPLICATE = "SELECT count(*) as count FROM person where email=? and not id_person=?;";

	public static boolean checkLogin(int id, String password) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(CHECK_LOGIN);
			
			psPerson.setInt(1, id);
			psPerson.setString(2, password);
			ResultSet rs = psPerson.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkPhoneNumberDuplicate(String phone, int id) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(CHECK_PHONENUMBER_DUPLICATE);
			
			psPerson.setString(1, phone);
			psPerson.setInt(2, id);
			ResultSet rs = psPerson.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkEmailDuplicate(String email, int id) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(CHECK_EMAIL_DUPLICATE);
			
			psPerson.setString(1, email);
			psPerson.setInt(2, id);
			ResultSet rs = psPerson.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String getPassPerson(int id) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(GET_PASSWORD_PERSON);
			psPerson.setInt(1, id);
			ResultSet rs = psPerson.executeQuery();
			if (rs.next()) {
				return rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getNamePerson(int id) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(GET_NAME_PERSON);
			psPerson.setInt(1, id);
			ResultSet rs = psPerson.executeQuery();
			if (rs.next()) {
				return rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getRolePerson(int id) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(GET_ROLE_PERSON);
			psPerson.setInt(1, id);
			ResultSet rs = psPerson.executeQuery();
			if (rs.next()) {
				return rs.getString("role");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static Person getPersonById(int id) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(GET_PERSON_BY_ID);
			psPerson.setInt(1, id);
			ResultSet rs = psPerson.executeQuery();
			if (rs.next()) {
				return new Person(rs.getInt("id_person"), rs.getString("name"), rs.getString("password"),
						rs.getString("role"), rs.getString("phone"), rs.getString("email"), rs.getString("CCCD"),
						rs.getBoolean("gender"), rs.getString("address"), rs.getDate("dob"),rs.getString("img"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int createPerson(Person person) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(CREATE_PERSON, PreparedStatement.RETURN_GENERATED_KEYS);
			psPerson.setString(1, person.getName());
			psPerson.setString(2, person.getPassword());
			psPerson.setString(3, person.getRole());
			psPerson.setString(4, person.getPhone());
			psPerson.setString(5, person.getEmail());
			psPerson.setString(6, person.getCCCD());
			psPerson.setBoolean(7, person.getGender());
			psPerson.setString(8, person.getAddress());
			psPerson.setDate(9, person.getDob());
			psPerson.setString(10, person.getImg());
			psPerson.executeUpdate();
			ResultSet rs = psPerson.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean updatePerson(Person person) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(UPDATE_PERSON);
			psPerson.setString(1, person.getName());
			psPerson.setString(2, person.getRole());
			psPerson.setString(3, person.getPhone());
			psPerson.setString(4, person.getEmail());
			psPerson.setString(5, person.getCCCD());
			psPerson.setBoolean(6, person.getGender());
			psPerson.setString(7, person.getAddress());
			psPerson.setDate(8, person.getDob());
			psPerson.setString(9, person.getImg());
			psPerson.setInt(10, person.getId_person());
			psPerson.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deletePerson(int id) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(DELETE_PERSON);
			psPerson.setInt(1, id);
			psPerson.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updatePassword(int id, String password) {
		try {
			
			Connection con = ConnectDatabase.getMySQLConnection();
			PreparedStatement psPerson = con.prepareStatement(UPDATE_PASSWORD);
			psPerson.setString(1, password);
			psPerson.setInt(2, id);
			psPerson.executeUpdate();
		} catch (Exception e) {
			
		}
		return true;
	}
}
