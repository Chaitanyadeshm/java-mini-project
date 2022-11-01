package com.cybage.modal;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	
	private int appointmentId;
	private int patientId;
	private int doctorId;
	private Date appointmentDate;
	private Time appointmentTime;
	private String appointmentStatus;
	private String feedback;
	private int ratings;
	private String patientsNotes;
	private String prescription;

	
	public Appointment(int appointmentId, int patientId, int doctorId, Date appointmentDate, Time appointmentTime,
			String appointmentStatus, String feedback, int ratings, String patientsNotes, String prescription) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.appointmentStatus = appointmentStatus;
		this.feedback = feedback;
		this.ratings = ratings;
		this.patientsNotes = patientsNotes;
		this.prescription = prescription;
	}
	public Appointment() {
		super();
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Time getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getPatientsNotes() {
		return patientsNotes;
	}
	public void setPatientsNotes(String patientsNotes) {
		this.patientsNotes = patientsNotes;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	
	

}
