package com.java.Issue;

import java.util.List;

public class ComplaintDao {
	String addComplaint(Complaint complaint);

	Complaint searchComplaint(String complaintID);

	List<Complaint> getAllComplaints();

	String deleteComplaintDao(String complaintID);

	String updateComplaintdao(Complaint complaintNew);

}
