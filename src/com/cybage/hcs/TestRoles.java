package com.cybage.hcs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.modal.Roles;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;


@WebServlet("/TestRoles")
public class TestRoles extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("no rolesasdf found");
		AdminService service = new AdminServiceImpl();
		List<Roles> roles = new ArrayList<>();
		roles = service.getAllRoles();
		if(roles.size() > 0) {
			for(Roles role: roles)
				System.out.println("Role name: " + role.getRoleName());
			
		}else {
			System.out.println("no roles found");
		}
//		RequestDispatcher d = request.getRequestDispatcher("admin_home.jsp");
//		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
