package com.cts.jpahibdemo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TraineeId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long rollNumber;
	private String programName;

	public TraineeId() {
		// TODO Auto-generated constructor stub
	}

	public TraineeId(Long rollNumber, String programName) {
		super();
		this.rollNumber = rollNumber;
		this.programName = programName;
	}

	public Long getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Long rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((programName == null) ? 0 : programName.hashCode());
		result = prime * result + ((rollNumber == null) ? 0 : rollNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TraineeId other = (TraineeId) obj;
		if (programName == null) {
			if (other.programName != null)
				return false;
		} else if (!programName.equals(other.programName))
			return false;
		if (rollNumber == null) {
			if (other.rollNumber != null)
				return false;
		} else if (!rollNumber.equals(other.rollNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TraineeId [rollNumber=" + rollNumber + ", programName=" + programName + "]";
	}
	
	
}
