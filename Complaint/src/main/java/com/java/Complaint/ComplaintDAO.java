package com.java.Complaint;

import java.util.List;

public interface ComplaintDAO {
	void addComplaint(Complaint complaint);

	Complaint searchComplaint(int complaintID);

	List<Complaint> getAllComplaints();
}
