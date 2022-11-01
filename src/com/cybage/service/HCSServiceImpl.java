package com.cybage.service;

import java.sql.SQLException;
import java.util.List;
import com.cybage.dao.HCSDAO;
import com.cybage.dao.HCSDAOImpl;
import com.cybage.modal.AllUsers;
import com.cybage.modal.Appointment;
import com.cybage.modal.DetailedAppointment;
import com.cybage.modal.Doctor;
import com.cybage.modal.Roles;
import com.cybage.modal.Specialization;
import com.cybage.modal.Users;

public class HCSServiceImpl implements HCSService {

	HCSDAO hcsDAO = new HCSDAOImpl();

	@Override
	public List<Roles> getAllRoles() {
		return hcsDAO.getAllRoles();
	}
	
	@Override
	public List<Users> getSpecificUsers(String typeOfUser) {
		return hcsDAO.getSpecificUsers(typeOfUser);
	}

	@Override
	public boolean registerDoctor(Users user, String[] doctorsSpecialization) throws ClassNotFoundException, SQLException {
		return hcsDAO.registerDoctor(user, doctorsSpecialization);
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		return hcsDAO.getAllSpecialization();
	}

	@Override
	public List<AllUsers> getAllUsers() {
		return hcsDAO.getAllUsers();
	}

	@Override
	public List<String> getDoctorsSpecializations(int doctordId) {
		return hcsDAO. getDoctorsSpecializations(doctordId);
	}

	@Override
	public Users loginUser(String email, String password) {
		return hcsDAO.loginUser(email, password);
	}

	@Override
	public List<DetailedAppointment> getALlDetailedAppointments(int roleId, int userId) {
		return hcsDAO.getALlDetailedAppointments(roleId, userId);
	}

	@Override
	public boolean updateAppointmentStatus(int appointmentId, String status) {
		return hcsDAO.updateAppointmentStatus(appointmentId, status);
	}

	@Override
	public boolean registerPatient(Users user) {
		return hcsDAO.registerPatient(user);
	}

	@Override
	public List<Doctor> getSpecializedDoctor(int specializationId) {
		return hcsDAO.getSpecializedDoctor(specializationId);
	}

	@Override
	public List<Appointment> getDoctorsAppointment(int doctorId) {
		return hcsDAO.getDoctorsAppointment(doctorId);
	}

	@Override
	public boolean addAppointment(Appointment appointment) {
		return hcsDAO.addAppointment(appointment);
	}

	@Override
	public Users getUserById(int userId) {
		return hcsDAO.getUserById(userId);
	}

	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		return hcsDAO.updateUser(user);
	}

	@Override
	public boolean changePassword(int userId, String newPassword) {
		return hcsDAO.changePassword(userId, newPassword);
	}

	@Override
	public boolean addPrescription(int appointmentId, String prescriptionText) {
		return hcsDAO.addPrescription(appointmentId,prescriptionText);
	}

	@Override
	public boolean addFeedback(int appointmentId, String enteredText) {
		return hcsDAO.addFeedback(appointmentId,enteredText);
	}
	


}
