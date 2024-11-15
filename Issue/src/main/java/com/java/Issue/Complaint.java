package com.java.Issue;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Complaint")
public class Complaint {

	@Id
	@Column(name = "complaintID")
	private String complaintID;
	@Column(name = "complaintType")
	private String complaintType;
	@Column(name = "CDescription")
	private String desc;
	@Column(name = "ComplaintDate")
	private Timestamp dateOfIssue;
	@Column(name = "severity")
	private String severity;
	@Column(name = "status")
	private String status;

	// Getters and Setters
	public String getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(String complaintID) {
		this.complaintID = complaintID;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Timestamp getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Timestamp dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Complaint(String complaintID, String complaintType, String desc, Timestamp dateOfIssue, String severity,
			String status) {
		this.complaintID = complaintID;
		this.complaintType = complaintType;
		this.desc = desc;
		this.dateOfIssue = dateOfIssue;
		this.severity = severity;
		this.status = status;
	}

	public Complaint() {
	}

	@Override
	public String toString() {
		return "Complaint [complaintID=" + complaintID + ", complaintType=" + complaintType + ", desc=" + desc
				+ ", dateOfIssue=" + dateOfIssue + ", severity=" + severity + ", status=" + status + "]";
	}
}
