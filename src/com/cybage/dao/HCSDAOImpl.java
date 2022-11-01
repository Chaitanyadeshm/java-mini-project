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

import org.apache.log4j.Logger;

import com.cybage.modal.AllUsers;
import com.cybage.modal.Appointment;
import com.cybage.modal.DetailedAppointment;
import com.cybage.modal.Doctor;
import com.cybage.modal.Roles;
import com.cybage.modal.Specialization;
import com.cybage.modal.Users;
import com.cybage.utility.JDBCUtility;

public class HCSDAOImpl implements HCSDAO {
	static Logger  logger = null;
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
			ResultSet resultset = statement.executeQuery("select * from users inner "
					+ "join roles on users.role_id = roles.role_id where roles.role_name ='Doctor';");

			Users user = new Users();
			while (resultset.next()) {

				user = new Users();
				user.setUserId(resultset.getInt(1));
				user.setRoleId(resultset.getInt(2));
				user.setFirstname(resultset.getString(3));
				user.setLastname(resultset.getString(4));
				user.setEmail(resultset.getString(5));
				user.setMobile(resultset.getString(6));
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
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobile());
			String password = user.getFirstname() + user.getLastname() + "@123";
			ps.setString(5, password);
			ps.setString(6, user.getCity());

			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setUserId(generatedKeys.getInt(1));
				}
			}
			if (user.getUserId() != 0) {
				for (int i = 0; i < doctorsSpecialization.length; i++) {
					String insertDoctorsSpecialization = "insert into doctors_specialization(specialization_id, doctor_id)"
							+ "values(" + doctorsSpecialization[i] + ", " + user.getUserId() + ")";
					PreparedStatement insertDS = connection.prepareStatement(insertDoctorsSpecialization);
					insertDS.executeUpdate();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		List<Specialization> specializations = new ArrayList<Specialization>();
		try (Connection connection = JDBCUtility.getConnection(); Statement statement = connection.createStatement()) {

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
				+ "from users inner join roles on users.role_id = roles.role_id";
		try (Connection connection = JDBCUtility.getConnection(); Statement statement = connection.createStatement();) {

			ResultSet resultset = statement.executeQuery(getALlUsers);

			AllUsers user = new AllUsers();
			while (resultset.next()) {
				user = new AllUsers();
				user.setUserId(resultset.getInt(1));
				user.setFirstname(resultset.getString(2));
				user.setLastname(resultset.getString(3));
				user.setEmail(resultset.getString(4));
				user.setMobile(resultset.getString(5));
				user.setRoleName(resultset.getString(6));
				user.setPassword(resultset.getString(7));
				user.setActive(resultset.getInt(8));
				user.setProfileUrl(resultset.getString(9));
				user.setCity(resultset.getString(10));
				allUsers.add(user);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

	@Override
	public List<String> getDoctorsSpecializations(int doctordId) {
		List<String> allSpecialization = new ArrayList<String>();
		String getDoctorsSpecialization = "select category from specialization inner join doctors_specialization "
				+ "on specialization.specialization_id = doctors_specialization.specialization_id where doctors_specialization.doctor_id = "
				+ doctordId + ";";
		try (Connection connection = JDBCUtility.getConnection(); Statement statement = connection.createStatement();) {
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
		String loginUserQuery = "select * from users where email = '" + email + "' and password = '" + password + "';";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(loginUserQuery);) {
			ResultSet resultset = statement.executeQuery(loginUserQuery);
			while (resultset.next()) {
				user.setUserId(resultset.getInt(1));
				user.setRoleId(resultset.getInt(2));
				user.setFirstname(resultset.getString(3));
				user.setLastname(resultset.getString(4));
				user.setEmail(resultset.getString(5));
				user.setMobile(resultset.getString(6));
				user.setPassword(resultset.getString(7));
				user.setActive(resultset.getInt(8));
				user.setProfileUrl(resultset.getString(9));
				user.setCity(resultset.getString(8));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (user.getUserId() != 0)
			return user;
		else
			return null;
	}

	@Override
	public List<DetailedAppointment> getALlDetailedAppointments(int roleId, int userId) {
		List<DetailedAppointment> detailedAppointments = new ArrayList<DetailedAppointment>();

		String getALlDetailedAppointmentsQuery = "";
		if (roleId == 1) {
			// Admin query
			getALlDetailedAppointmentsQuery = "select  appointment_id, user_id,  patient_id, firstname as patients_firstname, "
					+ "lastname as patients_lastname, email, doctor_id,"
					+ "(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname,"
					+ "(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname,"
					+ "(select email from users where users.user_id = appointments.doctor_id) as doctors_email,"
					+ "appointment_date, appointment_time,appointments_status,"
					+ "feedback , ratings, patient_notes, prescription from users inner join appointments on appointments.patient_id = users.user_id"
					+ " where appointments_status != 'Cancel' order by appointment_id desc;";
		} else if (roleId == 2) {
			// doctor's query
			getALlDetailedAppointmentsQuery = "select  appointment_id, user_id,  patient_id, firstname as patients_firstname, "
					+ "lastname as patients_lastname, email, doctor_id,"
					+ "(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname,"
					+ "(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname,"
					+ "(select email from users where users.user_id = appointments.doctor_id) as doctors_email,"
					+ "appointment_date, appointment_time,appointments_status,"
					+ "feedback , ratings, patient_notes, prescription from users inner join appointments on appointments.patient_id = users.user_id "
					+ "where appointments.doctor_id = " + userId + " and appointments_status != 'Cancel' order by appointment_id desc;";

		} else if (roleId == 3) {
			// patient's query
			getALlDetailedAppointmentsQuery = "select  appointment_id, user_id,  patient_id, firstname as patients_firstname, "
					+ "lastname as patients_lastname, email, doctor_id,"
					+ "(select firstname from users where users.user_id = appointments.doctor_id) as doctors_firstname,"
					+ "(select lastname from users where users.user_id = appointments.doctor_id) as doctors_lastname,"
					+ "(select email from users where users.user_id = appointments.doctor_id) as doctors_email,"
					+ "appointment_date, appointment_time,appointments_status,"
					+ "feedback , ratings, patient_notes, prescription from users inner join appointments on appointments.patient_id = users.user_id "
					+ "where users.user_id = " + userId + " and appointments_status != 'Cancel' order by appointment_id desc;";
		}

		try (Connection connection = JDBCUtility.getConnection(); Statement statement = connection.createStatement();) {
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
				detailedAppointment.setPrescription(resultset.getString(17));
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
		String updateStatusQuery = "update appointments set appointments_status = '" + status
				+ "' where appointment_id = " + appointmentId + " ;";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateStatusQuery);) {
			int result = statement.executeUpdate(updateStatusQuery);
			if (result > 0)
				success = true;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return success;
	}

	@Override
	public boolean registerPatient(Users user) {
		boolean success = false;
		String INSERT_USERS_SQL = "insert into users(role_id, firstname, lastname, email, mobile, password, active, profile_url,city)"
				+ "values(3, ?, ?, ?, ?, ?, 1, null, ?);";
		try {
			Connection connection = JDBCUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobile());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getCity());
			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Doctor> getSpecializedDoctor(int specializationId) {
		List<Doctor> doctors = new ArrayList<Doctor>();
		String getSpecializedDoctorQuery = "select user_id, firstname, lastname, email, mobile, profile_url, city "
				+ "from users where users.user_id in ( " + "select doctor_id from doctors_specialization inner join "
				+ "specialization on doctors_specialization.specialization_id = specialization.specialization_id "
				+ "where specialization.specialization_id = " + specializationId + ");";
		try (Connection connection = JDBCUtility.getConnection(); Statement statement = connection.createStatement();) {

			ResultSet resultset = statement.executeQuery(getSpecializedDoctorQuery);

			Doctor doctor = new Doctor();
			while (resultset.next()) {
				doctor = new Doctor();
				doctor.setUserId(resultset.getInt(1));
				doctor.setFirstname(resultset.getString(2));
				doctor.setLastname(resultset.getString(3));
				doctor.setEmail(resultset.getString(4));
				doctor.setMobile(resultset.getString(5));
				doctor.setProfileUrl(resultset.getString(6));
				doctor.setCity(resultset.getString(7));
				doctors.add(doctor);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return doctors;
	}

	@Override
	public List<Appointment> getDoctorsAppointment(int doctorId) {

		return null;
	}

	@Override
	public boolean addAppointment(Appointment appointment) {
		boolean success = false;
		Connection connection;
		String registerDoctor = "insert into appointments(patient_id, doctor_id, appointment_date, appointment_time,appointments_status,"
				+ "feedback , ratings, patient_notes, prescription) values(?, ?, ?, ?, 'Pending', '', '4', ?, null );";
		try {
			connection = JDBCUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement(registerDoctor);
			ps.setInt(1, appointment.getPatientId());
			ps.setInt(2, appointment.getDoctorId());
			ps.setDate(3, appointment.getAppointmentDate());
			ps.setTime(4, appointment.getAppointmentTime());
			ps.setString(5, appointment.getPatientsNotes());
			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

	@Override
	public Users getUserById(int userId) {
		Users user = new Users();
		String getUsreById = "select * from users where user_id ="+userId+ ";";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement statement = connection.prepareStatement(getUsreById);) {
			ResultSet resultset = statement.executeQuery(getUsreById);
			while (resultset.next()) {
				user.setUserId(resultset.getInt(1));
				user.setRoleId(resultset.getInt(2));
				user.setFirstname(resultset.getString(3));
				user.setLastname(resultset.getString(4));
				user.setEmail(resultset.getString(5));
				user.setMobile(resultset.getString(6));
				user.setPassword(resultset.getString(7));
				user.setActive(resultset.getInt(8));
				user.setProfileUrl(resultset.getString(9));
				user.setCity(resultset.getString(10));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (user.getUserId() != 0)
			return user;
		else
			return null;
	}

	@Override
	public boolean updateUser(Users user) {
		boolean success = false;
		String UPDATE_USERS_SQL = "update users set firstname = ?, lastname = ?, email = ?, mobile = ?, "
				+ "city = ? where user_id = ?";
		try(Connection connection = JDBCUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);) {
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobile());
			ps.setString(5, user.getCity());
			ps.setInt(6, user.getUserId());
			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean changePassword(int userId, String newPassword) {
		boolean success = false;
		String UPDATE_USERS_SQL = "update users set password = ? where user_id = ?";
		try(Connection connection = JDBCUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);) {
			ps.setString(1, newPassword);
			ps.setInt(2, userId);
			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean addPrescription(int appointmentId, String prescriptionText) {
		boolean success = false;
		String addPerscriptionQuery = "update appointments set prescription = ?, appointments_status = ? where appointment_id = ?";
		try(Connection connection = JDBCUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement(addPerscriptionQuery);) {
			ps.setString(1, prescriptionText);
			ps.setString(2, "Done");
			ps.setInt(3, appointmentId);
			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean addFeedback(int appointmentId, String feedback) {
		boolean success = false;
		String addPerscriptionQuery = "update appointments set feedback = ? where appointment_id = ?";
		try(Connection connection = JDBCUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement(addPerscriptionQuery);) {
			ps.setString(1, feedback);
			ps.setInt(2, appointmentId);
			int result = ps.executeUpdate();
			if (result > 0)
				success = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return success;	}

}
