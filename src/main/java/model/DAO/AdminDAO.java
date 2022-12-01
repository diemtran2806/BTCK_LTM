package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BEAN.Admin;
import model.BEAN.AdminView;

public class AdminDAO {
	private static final String CREATE_ADMIN = "INSERT INTO admin(id_admin,admin_salary)\r\n"
			+ "values(?, ?);";
	private static final String GET_ADMIN_BY_ID = "SELECT * FROM admin LEFT JOIN person ON "
			+ "admin.id_admin = person.id_person where id_admin=?;";
	private static final String GET_ADMINVIEW_BY_ID = "SELECT person.id_person,name,role,phone,email,CCCD,gender"
			+ ",address,dob,admin_salary FROM admin LEFT JOIN person ON admin.id_admin = person.id_person "
			+ "where id_admin=?;";
	private static final String UPDATE_ADMIN = "UPDATE admin "
			+ "SET admin_salary=? "
			+ "WHERE id_admin=?;";
	private static final String GET_ALL_ADMIN = "SELECT person.id_person,name,role,phone,email,CCCD,gender"
			+ ",address,dob,admin_salary FROM admin LEFT JOIN person ON "
			+ "admin.id_admin = person.id_person where "
			+ "admin.id_admin=? or name like N? or phone like ? or email like ? or "
			+ "CCCD like ? or address like N? or dob like N? or admin_salary like N?;";

	public static boolean createAdmin(Admin admin){
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			int id_admin = PersonDAO.createPerson(admin);
			if(id_admin != 0){
				PreparedStatement ps = con.prepareStatement(CREATE_ADMIN);
				ps.setInt(1, id_admin);
				ps.setInt(2, admin.getAdmin_salary());
				ps.executeUpdate();
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static ArrayList<AdminView> getAdminList(String value){
		ArrayList<AdminView> result = new ArrayList<AdminView>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_ALL_ADMIN);
			ps.setString(1, value);
			ps.setString(2, "%" + value + "%");
			ps.setString(3, "%" + value + "%");
			ps.setString(4, "%" + value + "%");
			ps.setString(5, "%" + value + "%");
			ps.setString(6, "%" + value + "%");
			ps.setString(7, "%" + value + "%");
			ps.setString(8, "%" + value + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new AdminView(rs.getInt("id_person"), rs.getString("name")
					,rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD")
					,rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getInt("admin_salary")));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static Admin getAdminById(int id){
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_ADMIN_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Admin(rs.getInt("id_student"), rs.getString("name"),rs.getString("password")
					,rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD")
					,rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getInt("admin_salary"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static AdminView getAdminViewById(int id){
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_ADMINVIEW_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new AdminView(rs.getInt("id_person"), rs.getString("name")
					,rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD")
					,rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getInt("admin_salary"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean updateAdmin(Admin admin) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			if (PersonDAO.updatePerson(admin)) {
				PreparedStatement ps = con.prepareStatement(UPDATE_ADMIN);
				ps.setInt(1, admin.getAdmin_salary());
				ps.setInt(2, admin.getId_person());
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
