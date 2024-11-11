package com.javaLms;

import java.util.Date;

public class LeaveDetails {
	private int leaveId;
	private int empId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String leaveReason;
	private String leaveType;
	private String leaveStatus;
	private String managerComments;
	
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getManagerComments() {
		return managerComments;
	}
	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}
	public LeaveDetails() {

	}
	public LeaveDetails(int leaveId, int empId, Date leaveStartDate, Date leaveEndDate, String leaveReason,
			String leaveType, String leaveStatus, String managerComments) {
		this.leaveId = leaveId;
		this.empId = empId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveReason = leaveReason;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.managerComments = managerComments;
	}
	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", empId=" + empId + ", leaveStartDate=" + leaveStartDate
				+ ", leaveEndDate=" + leaveEndDate + ", leaveReason=" + leaveReason + ", leaveType=" + leaveType
				+ ", leaveStatus=" + leaveStatus + ", managerComments=" + managerComments + "]";
	}
	
}
