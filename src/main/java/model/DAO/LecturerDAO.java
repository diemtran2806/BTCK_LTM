package model.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.BEAN.*;
public class LecturerDAO {
		private static final String CREATE_LECTURER = "INSERT INTO lecturer(id_lecturer,id_faculty,lecturer_salary)\r\n"
														+ "values(?, ?, ?);";
		private static final String GET_ALL_LECTURER = "SELECT id_person, name,  faculty_name, role, phone, email, CCCD, gender, address, dob, img, faculty_name, lecturer_salary "
														+ "from "
														+ "(select * from lecturer left join person on lecturer.id_lecturer = person.id_person) as lec "
														+ "left join faculty on lec.id_faculty = faculty.id_faculty;";
		private static final String UPDATE_LECTURER = "UPDATE lecturer\r\n"
														+ "SET  id_faculty= ?, lecturer_salary = ?\r\n"
														+ "WHERE id_lecturer = ?;";
		private static final String GET_LECTURER_BY_ID = "select "
															+ "id_person, id_faculty, lecturer_salary, name, phone, email, CCCD,role, gender, address, dob,img "
															+ "from "
															+ "lecturer left join person "
															+ "on"
															+ " lecturer.id_lecturer = person.id_person "
															+ "where "
															+ "id_person = ?;\r\n";
		private static final String GET_LECTURER_VIEW_BY_ID = "SELECT id_person, name,  faculty_name, role, phone, email, CCCD, gender, address, dob, img, faculty_name, lecturer_salary "
				+ "from "
				+ "(select * from lecturer left join person on lecturer.id_lecturer = person.id_person) as lec "
				+ "left join faculty on lec.id_faculty = faculty.id_faculty "
				+ "where "
				+ "id_person = ?;\r\n";
		private static final String SEARH_LECTURER ="SELECT "
													+ "id_person, name,  faculty_name, role, phone, email, CCCD, gender, address, dob,img, faculty_name, lecturer_salary "
													+ "from "
													+ "(select * from lecturer left join person on lecturer.id_lecturer = person.id_person) "
													+ "as lec "
													+ "left join faculty on lec.id_faculty = faculty.id_faculty "
													+ "where "  //search start
													+ "id_person=? or "
													+ "name like N? or "
													+ "faculty_name like N? or "
													+ "phone like ? or "
													+ "email like ? or "
													+ "CCCD like ? or "
													+ "address like ? or "
													+ "faculty_name like N? ;";
		
		public static boolean createLecturer(Lecturer Lecturer){
			// try-with-resource statement will auto close the connection.
			try {
				Connection con = ConnectDatabase.getMySQLConnection();
				int id_lecturer = PersonDAO.createPerson(Lecturer);
				if(id_lecturer!=0){
					PreparedStatement psLecturer = con.prepareStatement(CREATE_LECTURER);
					System.out.print(psLecturer);
					psLecturer.setInt(1, id_lecturer);
					psLecturer.setInt(2, Lecturer.getId_faculty());
					psLecturer.setInt(3, Lecturer.getLecturer_salary());
					psLecturer.executeUpdate();
				}
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		
		public static ArrayList<LecturerListView> getLecturerList(String search){
			ArrayList<LecturerListView> result = new ArrayList<LecturerListView>();
			try {
				Connection con = ConnectDatabase.getMySQLConnection();				
				ResultSet rs = null;
				
				if(search=="") {
					Statement stmt = con.createStatement();
					rs = stmt.executeQuery(GET_ALL_LECTURER);
					
				}
				else {
					PreparedStatement psPerson = con.prepareStatement(SEARH_LECTURER);
					psPerson.setString(1, search);
					psPerson.setString(2, "%" + search + "%");
					psPerson.setString(3, "%" +  search + "%");
					psPerson.setString(4, "%" +  search + "%");
					psPerson.setString(5, "%" +  search + "%");
					psPerson.setString(6, "%" +  search + "%");
					psPerson.setString(7, "%" +  search + "%");
					psPerson.setString(8, "%" +  search + "%");
					rs = psPerson.executeQuery();
				}
				while(rs.next()) {
					result.add(new LecturerListView(rs.getInt("id_person"), rs.getString("name"),"",rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD"),rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getString("img"),rs.getString("faculty_name"),rs.getInt("lecturer_salary")));
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return result;
		}
		
		public static Lecturer getLecturerById(int id){
			Lecturer result = null;
			try {
				
				Connection con = ConnectDatabase.getMySQLConnection();
				PreparedStatement psLecturer = con.prepareStatement(GET_LECTURER_BY_ID);
				psLecturer.setInt(1, id);
				ResultSet rs = psLecturer.executeQuery();
				if(rs.next()) {
					result = new Lecturer(rs.getInt("id_person"), rs.getString("name"),"",rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD"),rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getString("img"),rs.getInt("id_faculty"),rs.getInt("lecturer_salary"));
				}				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return result;
		}
		
		public static LecturerListView getLecturerViewById(int id){
			try {
				
				Connection con = ConnectDatabase.getMySQLConnection();
				PreparedStatement psLecturer = con.prepareStatement(GET_LECTURER_VIEW_BY_ID);
				psLecturer.setInt(1, id);
				ResultSet rs = psLecturer.executeQuery();
				if(rs.next()) {
					return new LecturerListView(rs.getInt("id_person"), rs.getString("name"),"",rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD"),rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getString("img"),rs.getString("faculty_name"),rs.getInt("lecturer_salary"));
				}				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return null;
		}
		
		public static boolean updateLecturer(Lecturer Lecturer){
			try {
				Connection con = ConnectDatabase.getMySQLConnection();
				if (PersonDAO.updatePerson(Lecturer)) {
					PreparedStatement psLecturer = con.prepareStatement(UPDATE_LECTURER);
					psLecturer.setInt(1, Lecturer.getId_faculty());
					psLecturer.setInt(2, Lecturer.getLecturer_salary());
					psLecturer.setInt(3, Lecturer.getId_person());
					psLecturer.executeUpdate();  					
				} 
			}  catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
}
