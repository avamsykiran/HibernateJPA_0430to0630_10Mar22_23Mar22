package com.cts.jpahibdemo.entity;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trainees")
public class Trainee {

	@EmbeddedId
	private TraineeId tid;
	private String fullName;
	private LocalDate dateOfAdmission;
	
	public Trainee() {}

	public Trainee(TraineeId tid, String fullName, LocalDate dateOfAdmission) {
		super();
		this.tid = tid;
		this.fullName = fullName;
		this.dateOfAdmission = dateOfAdmission;
	}

	public TraineeId getTid() {
		return tid;
	}

	public void setTid(TraineeId tid) {
		this.tid = tid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	@Override
	public String toString() {
		return "Trainee [tid=" + tid + ", fullName=" + fullName + ", dateOfAdmission=" + dateOfAdmission + "]";
	}
	
	
}
