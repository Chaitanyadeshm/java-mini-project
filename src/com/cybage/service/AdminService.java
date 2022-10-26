package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import com.cybage.modal.AllUsers;
import com.cybage.modal.DetailedAppointment;
import com.cybage.modal.ProductModal;
import com.cybage.modal.Roles;
import com.cybage.modal.Specialization;
import com.cybage.modal.Users;

public interface AdminService {
	
	List<Roles> getAllRoles();
	List<Specialization> getAllSpecialization();
	List<Users> getSpecificUsers(String typeOfUser);
	boolean registerDoctor(Users user, String[] doctorsSpecialization) throws ClassNotFoundException, SQLException;
	List<AllUsers> getAllUsers();
	List<String> getDoctorsSpecializations(int doctordId);
	Users loginUser(String email, String password);
	List<DetailedAppointment> getALlDetailedAppointments(int roleId, int userId);
	boolean updateAppointmentStatus(int appointmentId, String status);
//	ProductModal getProductById(int productId) throws ClassNotFoundException, SQLException;
//	List<ProductModal> getAllProduct() throws ClassNotFoundException, SQLException;
//	boolean addProduct(ProductModal product) throws ClassNotFoundException, SQLException;
//	boolean deleteProduct(int productId) throws ClassNotFoundException, SQLException;
	
}
