package com.cybage.modal;

public class DoctorsSpecialization {
	
	private int doctorsSpecializationId;
	private int specializationId;
	private int doctorsId;
	public DoctorsSpecialization(int doctorsSpecializationId, int specializationId, int doctorsId) {
		super();
		this.doctorsSpecializationId = doctorsSpecializationId;
		this.specializationId = specializationId;
		this.doctorsId = doctorsId;
	}
	public DoctorsSpecialization() {
	}
	public int getDoctorsSpecializationId() {
		return doctorsSpecializationId;
	}
	public void setDoctorsSpecializationId(int doctorsSpecializationId) {
		this.doctorsSpecializationId = doctorsSpecializationId;
	}
	public int getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}
	public int getDoctorsId() {
		return doctorsId;
	}
	public void setDoctorsId(int doctorsId) {
		this.doctorsId = doctorsId;
	}
	
	
	
	

}
