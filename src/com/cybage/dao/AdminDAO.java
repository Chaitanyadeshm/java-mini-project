package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import com.cybage.modal.AllUsers;
import com.cybage.modal.DetailedAppointment;
import com.cybage.modal.Roles;
import com.cybage.modal.Specialization;
import com.cybage.modal.Users;

public interface AdminDAO {
	
	List<Roles> getAllRoles();
	List<Specialization> getAllSpecialization();
	List<Users> getSpecificUsers(String typeOfUser);

//	ProductModal getProductById(int productId) throws ClassNotFoundException, SQLException;
//	boolean addProduct(ProductModal product)  throws ClassNotFoundException, SQLException;
//	List<ProductModal> getAllProduct() throws ClassNotFoundException, SQLException;
//	boolean deleteProduct(int productId) throws ClassNotFoundException, SQLException;
	boolean registerDoctor(Users user,  String[] doctorsSpecialization);
	List<AllUsers> getAllUsers();
	List<String> getDoctorsSpecializations(int doctordId);
	Users loginUser(String email, String password);
	List<DetailedAppointment> getALlDetailedAppointments(int roleId, int userId);
	boolean updateAppointmentStatus(int appointmentId, String status);


}
