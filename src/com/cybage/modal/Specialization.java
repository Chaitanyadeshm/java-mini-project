package com.cybage.modal;

public class Specialization {
	private int specializationId;
	private String category;
	public Specialization(int specializationId, String category) {
		super();
		this.specializationId = specializationId;
		this.category = category;
	}
	public Specialization() {
		super();
	}
	public int getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
