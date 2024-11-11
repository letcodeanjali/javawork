package lms;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class LeaveDetailsImpl implements LeaveDetailsDao{
  static List<LeaveDetails> listLeaveDetails;
	
	static {
		listLeaveDetails = new ArrayList<LeaveDetails>();
	}
	
	public List<LeaveDetails> showLeaveDao() {
		return listLeaveDetails;
	}

	public String addLeaveDao(LeaveDetails leaveDetails) {
		long ms = leaveDetails.getLeaveEndDate().getTime() - 
					leaveDetails.getLeaveStartDate().getTime();
		int days = (int)ms/(1000 * 60 * 60 * 24);
		leaveDetails.setNoOfDays(days);
		leaveDetails.setLeaveStatus("PENDING");
		leaveDetails.setAppliedOn(new Date());
		listLeaveDetails.add(leaveDetails);
		return "Leave Record Inserted...";
	}
	

}
