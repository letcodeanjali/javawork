package lms;
import java.util.Date;
public class LeaveDetails {
	

	private int leaveId;
	private int empId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private int noOfDays;
	private Date appliedOn;
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
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public Date getAppliedOn() {
		return appliedOn;
	}
	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
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
		// TODO Auto-generated constructor stub
	}
	public LeaveDetails(int leaveId, int empId, Date leaveStartDate, Date leaveEndDate, int noOfDays, Date appliedOn,
			String leaveType, String leaveStatus, String managerComments) {
		this.leaveId = leaveId;
		this.empId = empId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.noOfDays = noOfDays;
		this.appliedOn = appliedOn;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.managerComments = managerComments;
	}
	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", empId=" + empId + ", leaveStartDate=" + leaveStartDate
				+ ", leaveEndDate=" + leaveEndDate + ", noOfDays=" + noOfDays + ", appliedOn=" + appliedOn
				+ ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus + ", managerComments=" + managerComments
				+ "]";
	}
	

}
