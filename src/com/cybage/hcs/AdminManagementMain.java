package com.cybage.hcs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cybage.modal.ProductModal;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;

public class AdminManagementMain {

	public static void main(String[] args) {
		
		
//
//		ProductService productService = new ProductServiceImpl();
//		Scanner s = new Scanner(System.in);
//		System.out.println("this is running");
//		outerLoop: while (true) {
//			System.out.println("Choose\n 1. Get product by id  \n 2. Add product  \n 3. Show all products  "
//					+ "\n 4. Delete product by Id  \n 5. Exit");
//			int choice = s.nextInt();
//			switch (choice) {
//			case 1:
//				try {
//					ProductModal productModal = productService.getProductById(2);
//					System.out.println("product name: " + productModal.getProductName());
//
//				} catch (ClassNotFoundException | SQLException e) {
//
//					e.printStackTrace();
//				}
//				break;
//			case 2:
//				try {
//					ProductModal product = new ProductModal();
//					
//					System.out.print("Enter Product Name: ");
//					product.setProductName(s.next());
//					s.next();
//					System.out.print("Enter Product Price: ");
//					product.setPrice(s.nextInt());
//					System.out.print("Enter User Id: ");
//					product.setUserId(s.nextInt());
//					boolean productAdded = productService.addProduct(product);
//					if(productAdded)
//						System.out.println("Product added successfully");
//					else
//						System.out.println("Could not add the product.");
//
//				} catch (ClassNotFoundException | SQLException e) {
//
//					e.printStackTrace();
//				}
//				break;
//			case 3:
//				try {
//					List<ProductModal> allProducts = new ArrayList<>();
//					allProducts = productService.getAllProduct();
//					if(allProducts.size() > 0) {						
//						System.out.println("These are all products: ");
//						for(int i = 0; i < allProducts.size(); i++) {
//							System.out.println(allProducts.get(i).getProductId() + " | " + 
//									allProducts.get(i).getProductName() + " | " +
//									allProducts.get(i).getUserId() + " | " +
//									allProducts.get(i).getPrice() );
//						}
//					}
//					else
//						System.out.println("There are no products available in the database.");
//				} catch (ClassNotFoundException | SQLException e) {
//
//					e.printStackTrace();
//				}
//				break;
//			case 4:
//				try {
//					System.out.print("Enter Product id which you want to delete:");
//					int productId = s.nextInt();
//					boolean productDeleted = productService.deleteProduct(productId);
//					if(productDeleted) 						
//						System.out.println("Product deleted successfully.");
//					else
//						System.out.println("Could not delete product.");
//				} catch (ClassNotFoundException | SQLException e) {
//					e.printStackTrace();
//				}
//				break;
//			case 5:
//				break outerLoop;
//			default:
//				break;
//			}
//
//		}
//		s.close();
		System.out.println("Program terminated succcessfully.");

	}

}
