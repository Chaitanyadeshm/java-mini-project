package com.cybage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.cybage.modal.AllUsers;
import com.cybage.modal.DetailedAppointment;
import com.cybage.modal.Roles;
import com.cybage.modal.Specialization;
import com.cybage.modal.Users;
import com.cybage.utility.JDBCUtility;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public List<Roles> getAllRoles() {
		List<Roles> roles = new ArrayList<Roles>();
		Statement statement;
		try {
			Connection connection = JDBCUtility.getConnection();
			statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from roles");

			Roles role = new Roles();
			while (resultset.next()) {
				role = new Roles();
				role.setRoleId(resultset.getInt(1));
				role.setRoleName(resultset.getString(2));
				roles.add(role);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return roles;
	}

	@Override
	public List<Users> getSpecificUsers(String typeOfUser) {
		List<Users> users = new ArrayList<Users>();
		Statement statement;
		try {
			Connection connection = JDBCUtility.getConnection();
			statement = connection.createStatement();
			System.out.println("type of user: " + typeOfUser);
			ResultSet resultset = statement.executeQuery("select * from users inner "
					+ "join roles on users.role_id = roles.role_id where roles.role_name ='Doctor';");

			Users user = new Users();
			while (resultset.next()) {

				user = new Users();
				System.out.println("something: " + resultset.getInt(1));
				user.setUserId(resultset.getInt(1));
				user.setRoleId(resultset.getInt(2));
				user.setFirstname(resultset.getString(3));
				user.setLastname(resultset.getString(4));
				user.setEmail(resultset.getString(5));
				user.setMobile(resultset.getInt(6));
				user.setPassword(resultset.getString(7));
				user.setActive(resultset.getInt(8));
				user.setProfileUrl(resultset.getString(9));
				user.setCity(resultset.getString(8));
				users.add(user);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean registerDoctor(Users user, String[] doctorsSpecialization) {
		Connection connection;
		boolean success = false;
		String registerDoctor = "insert into users(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)"
				+ "values(2, ?, ?, ?, ?, ?, 1, null, ?);";
		try {
			connection = JDBCUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement(registerDoctor, Statement.RETURN_GENERATED_KEYS);
//			ps.setInt(1, 2);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getMobile());
			String password = user.getFirstname() + user.getLastname() + "@123";
			System.out.println("new password: " + password);
			ps.setString(5,  password);
//			ps.setInt(6, 1);
//			ps.setString(8, "noUrl");
			ps.setString(6, user.getCity());

			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
//			System.out.println("----------------------- this is query success: "+ result);
//			String getDoctorId = "select * from users where email = ' " + user.getEmail()+ " '; ";
			 try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                user.setUserId(generatedKeys.getInt(1));
		            }
			 }
			System.out.println("this is new doctor ID: "+ user.getUserId());
			
			if (user.getUserId() != 0) {
				for (int i = 0; i < doctorsSpecialization.length; i++) {
					String insertDoctorsSpecialization = "insert into doctors_specialization(specialization_id, doctor_id)"
							+ "values("+doctorsSpecialization[i]+", "+ user.getUserId()+")";
					PreparedStatement insertDS = connection.prepareStatement(insertDoctorsSpecialization);
					insertDS.executeUpdate();
				}
			}
			System.out.println("this is user: " + user);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		List<Specialization> specializations = new ArrayList<Specialization>();
//		Statement statement;
		try(Connection connection = JDBCUtility.getConnection();
				Statement statement = connection.createStatement()) {
			
			ResultSet resultset = statement.executeQuery("select * from specialization");

			Specialization specialization = new Specialization();
			while (resultset.next()) {
				specialization = new Specialization();
				specialization.setSpecializationId(resultset.getInt(1));
				specialization.setCategory(resultset.getString(2));
				specializations.add(specialization);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return specializations;
	}

	@Override
	public List<AllUsers> getAllUsers() {
		List<AllUsers> allUsers = new ArrayList<AllUsers>();
		String getALlUsers = "select user_id, firstname, lastname, email, mobile, role_name,  password, active, profile_url, city "
				+ "from users inner join roles on users.role_id = roles.role_id" ;
//		Statement statement;
		try (Connection connection = JDBCUtility.getConnection();
			Statement statement = connection.createStatement();) {
			
			
//			System.out.println("type of user: " + typeOfUser);
			ResultSet resultset = statement.executeQuery(getALlUsers);

			AllUsers user = new AllUsers();
			while (resultset.next()) {

				user = new AllUsers();
				System.out.println("something: " + resultset.getInt(1));
				user.setUserId(resultset.getInt(1));
				user.setFirstname(resultset.getString(2));
				user.setLastname(resultset.getString(3));
				user.setEmail(resultset.getString(4));
				user.setMobile(resultset.getInt(5));
				user.setRoleName(resultset.getString(6));
				user.setPassword(resultset.getString(7));
				user.setActive(resultset.getInt(8));
				user.setProfileUrl(resultset.getString(9));
				user.setCity(resultset.getString(10));
				allUsers.add(user);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allUsers;
	}

	@Override
	public List<String> getDoctorsSpecializations(int doctordId) {
		List<String> allSpecialization = new ArrayList<String>();
		String getDoctorsSpecialization = "select category from specialization inner join doctors_specialization "
				+ "on specialization.specialization_id = doctors_specialization.specialization_id where doctors_specialization.doctor_id = "+doctordId+ ";";
		try (Connection connection = JDBCUtility.getConnection();
				Statement statement = connection.createStatement();) {
				ResultSet resultset = statement.executeQuery(getDoctorsSpecialization);
				while (resultset.next()) {
					allSpecialization.add(resultset.getString(1));
				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		return allSpecialization;
	}

	
	@Override
	public Users loginUser(String email, String password) {
		Users user = new Users();
		String loginUserQuery = "select * from users where email = '"+ email +"' and password = '"+ password+"';";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(loginUserQuery);) {
				ResultSet resultset = statement.executeQuery(loginUserQuery);
				while (resultset.next()) {
					user.setUserId(resultset.getInt(1));
					user.setRoleId(resultset.getInt(2));
					user.setFirstname(resultset.getString(3));
					user.setLastname(resultset.getString(4));
					user.setEmail(resultset.getString(5));
					user.setMobile(resultset.getInt(6));
					user.setPassword(resultset.getString(7));
					user.setActive(resultset.getInt(8));
					user.setProfileUrl(resultset.getString(9));
					user.setCity(resultset.getString(8));
				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		if(user.getUserId() != 0)
			return user;
		else
			return null;
	}

	@Override
	public List<DetailedAppointment> getALlDetailedAppointments(int roleId, int userId) {
		List<DetailedAppointment> detailedAppointments = new ArrayList<DetailedAppointment>();
		
		String getALlDetailedAppointmentsQuery = "";
		if(roleId == 1) {
			// Admin query
			getALlDetailedAppointmentsQuery = "select  appointment_id, user_id,  patient_id, firstname as patients_firstname, "
					+ "lastname as patients_lastname, email, doctor_id," + 
					"(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname," + 
					"(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname," + 
					"(select email from users where users.user_id = appointments.doctor_id) as doctors_email," + 
					"appointment_date, appointment_time,appointments_status," + 
					"feedback , ratings, patient_notes from users inner join appointments on appointments.patient_id = users.user_id;";
		}else if(roleId == 2 ) {
			System.out.println("this is doctor with user id: " + userId);
			// doctor's  query
			getALlDetailedAppointmentsQuery = "select  appointment_id, user_id,  patient_id, firstname as patients_firstname, "
					+ "lastname as patients_lastname, email, doctor_id," + 
					"(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname," + 
					"(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname," + 
					"(select email from users where users.user_id = appointments.doctor_id) as doctors_email," + 
					"appointment_date, appointment_time,appointments_status," + 
					"feedback , ratings, patient_notes from users inner join appointments on appointments.patient_id = users.user_id "
					+ "where appointments.doctor_id = "+ userId + ";";
			
		}else if(roleId == 3) {
			System.out.println("this is patient with user id: " + userId);
			// patient's  query
			getALlDetailedAppointmentsQuery = "select  appointment_id, user_id,  patient_id, firstname as patients_firstname, "
					+ "lastname as patients_lastname, email, doctor_id," + 
					"(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname," + 
					"(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname," + 
					"(select email from users where users.user_id = appointments.doctor_id) as doctors_email," + 
					"appointment_date, appointment_time,appointments_status," + 
					"feedback , ratings, patient_notes from users inner join appointments on appointments.patient_id = users.user_id "
					+ "where users.user_id = "+ userId + ";";
		}
		
		try (Connection connection = JDBCUtility.getConnection();
				Statement statement = connection.createStatement();) {
				ResultSet resultset = statement.executeQuery(getALlDetailedAppointmentsQuery);
				DetailedAppointment detailedAppointment = new DetailedAppointment();
				while (resultset.next()) {
					detailedAppointment = new DetailedAppointment();
					detailedAppointment.setAppointmentId(resultset.getInt(1));
					detailedAppointment.setUserId(resultset.getInt(2));
					detailedAppointment.setPatientId(resultset.getInt(3));
					detailedAppointment.setPaitentsName(resultset.getString(4) + " " + resultset.getString(5));
					detailedAppointment.setPaitentsEmail(resultset.getString(6));
					detailedAppointment.setDoctorId(resultset.getInt(7));
					detailedAppointment.setDoctorsName(resultset.getString(8) + " " + resultset.getString(9));
					detailedAppointment.setDoctorsEmail(resultset.getString(10));
					detailedAppointment.setAppointmentDate(resultset.getDate(11));
					detailedAppointment.setAppointmentTime(resultset.getTime(12));
					detailedAppointment.setAppointmentStatus(resultset.getString(13));
					detailedAppointment.setFeedback(resultset.getString(14));
					detailedAppointment.setRatings(resultset.getInt(15));
					detailedAppointment.setPatientsNotes(resultset.getString(16));
					detailedAppointments.add(detailedAppointment);
					
				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return detailedAppointments;
	}

	@Override
	public boolean updateAppointmentStatus(int appointmentId, String status) {
		boolean success = false;
		String updateStatusQuery = "update appointments set appointments_status = '"+status+"' where appointment_id = "+appointmentId+" ;";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateStatusQuery);) {
				int result = statement.executeUpdate(updateStatusQuery);
				if(result > 0)
					success = true;
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		return success;
	}

//	@Override
//	public ProductModal getProductById(int productId) throws ClassNotFoundException, SQLException {
//		Connection connection = JDBCUtility.getConnection();
//
//		Statement statement = connection.createStatement();
//
//		ResultSet resultset = statement.executeQuery("select * from product where productId = " + productId);
//
//		ProductModal product = new ProductModal();
//		while (resultset.next()) {
//			product.setProductId(resultset.getInt(1));
//			product.setPrice(resultset.getInt(4));
//			product.setProductName(resultset.getString(2));
//			product.setUserId(resultset.getInt(3));
//		}
//		return product;
//	}
//
//	@Override
//	public boolean addProduct(ProductModal product) throws ClassNotFoundException, SQLException {
//
//		Connection connection = JDBCUtility.getConnection();
//
//		String updatedInsertRow = "insert into product ( productName, userId, productPrice) values (?,?,?)";
//		PreparedStatement ps = connection.prepareStatement(updatedInsertRow);
//		ps.setString(1, product.getProductName());
//		ps.setInt(2, product.getUserId());
//		ps.setInt(3, product.getPrice());
//		ps.executeUpdate();
//
//		return true;
//	}
//
//	@Override
//	public List<ProductModal> getAllProduct() throws ClassNotFoundException, SQLException {
//		Connection connection = JDBCUtility.getConnection();
//
//		Statement statement = connection.createStatement();
//
//		ResultSet resultset = statement.executeQuery("select * from product");
//
//		ProductModal product = new ProductModal();
//		List<ProductModal> allProductsList = new ArrayList<>();
//		while (resultset.next()) {
//			product = new ProductModal();
//			product.setProductId(resultset.getInt(1));
//			product.setProductName(resultset.getString(2));
//			product.setUserId(resultset.getInt(3));
//			product.setPrice(resultset.getInt(4));
//			allProductsList.add(product);
//		}
//		return allProductsList;
//	}
//
//	@Override
//	public boolean deleteProduct(int productId) throws ClassNotFoundException, SQLException {
//		Connection connection = JDBCUtility.getConnection();
//
//		Statement statement = connection.createStatement();
//
//		String deleteRow = "delete from product where productId =" + productId;
//
//		int result = statement.executeUpdate(deleteRow);
//		if (result > 0)
//			return true;
//		else
//			return false;
//	}

}
