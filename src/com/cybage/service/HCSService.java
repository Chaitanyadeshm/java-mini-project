package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.modal.AllUsers;
import com.cybage.modal.Appointment;
import com.cybage.modal.DetailedAppointment;
import com.cybage.modal.Doctor;
import com.cybage.modal.Roles;
import com.cybage.modal.Specialization;
import com.cybage.modal.Users;

public interface HCSService {
	
	List<Roles> getAllRoles();
	List<Specialization> getAllSpecialization();
	List<Users> getSpecificUsers(String typeOfUser);
	boolean registerDoctor(Users user, String[] doctorsSpecialization) throws ClassNotFoundException, SQLException;
	List<AllUsers> getAllUsers();
	List<String> getDoctorsSpecializations(int doctordId);
	Users loginUser(String email, String password);
	List<DetailedAppointment> getALlDetailedAppointments(int roleId, int userId);
	boolean updateAppointmentStatus(int appointmentId, String status);
	boolean registerPatient(Users user);
	List<Doctor> getSpecializedDoctor(int specializationId);
	List<Appointment> getDoctorsAppointment(int doctorId);
	boolean addAppointment(Appointment appointment);
	Users getUserById(int userId);
	boolean updateUser(Users user);
	boolean changePassword(int userId, String newPassword);
	boolean addPrescription(int appointmentId, String prescriptionText);
	boolean addFeedback(int appointmentId, String enteredText);
	
}
