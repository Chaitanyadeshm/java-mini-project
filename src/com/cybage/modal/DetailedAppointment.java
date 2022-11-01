package com.cybage.modal;

import java.sql.Date;
import java.sql.Time;

public class DetailedAppointment {
	private int appointmentId;
	private int userId;
	private int patientId;
	private String paitentsName;
	private String paitentsEmail;
	private int doctorId;
	private String doctorsName;
	private String doctorsEmail;
	private Date appointmentDate;
	private Time appointmentTime;
	private String appointmentStatus;
	private String feedback;
	private int ratings;
	private String patientsNotes;
	private String prescription;

	public DetailedAppointment(int appointmentId, int userId, int patientId, String paitentsName, String paitentsEmail,
			int doctorId, String doctorsName, String doctorsEmail, Date appointmentDate, Time appointmentTime,
			String appointmentStatus, String feedback, int ratings, String patientsNotes, String prescription) {
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.patientId = patientId;
		this.paitentsName = paitentsName;
		this.paitentsEmail = paitentsEmail;
		this.doctorId = doctorId;
		this.doctorsName = doctorsName;
		this.doctorsEmail = doctorsEmail;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.appointmentStatus = appointmentStatus;
		this.feedback = feedback;
		this.ratings = ratings;
		this.patientsNotes = patientsNotes;
		this.prescription = prescription;
	}

	public DetailedAppointment() {
		super();
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPaitentsName() {
		return paitentsName;
	}

	public void setPaitentsName(String paitentsName) {
		this.paitentsName = paitentsName;
	}

	public String getPaitentsEmail() {
		return paitentsEmail;
	}

	public void setPaitentsEmail(String paitentsEmail) {
		this.paitentsEmail = paitentsEmail;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorsName() {
		return doctorsName;
	}

	public void setDoctorsName(String doctorsName) {
		this.doctorsName = doctorsName;
	}

	public String getDoctorsEmail() {
		return doctorsEmail;
	}

	public void setDoctorsEmail(String doctorsEmail) {
		this.doctorsEmail = doctorsEmail;
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
