package lms;
import java.util.Date;
import java.util.List;

public class LeaveDetailsBal {
	static LeaveDetailsImpl dao = new LeaveDetailsImpl();
	 StringBuilder sb = new StringBuilder();
	
	public List<LeaveDetails> showLeaveBal() {
		return dao.showLeaveDao();
	}
	public String applyLeaveBal(LeaveDetails leaveDetails) 
				throws LeaveDetailsException {
				if (validateLeave(leaveDetails)== true) {
			return dao.addLeaveDao(leaveDetails);
		}
		throw new LeaveDetailsException(sb.toString());
	}
	
	public boolean validateLeave(LeaveDetails leaveDetails) {
		boolean flag = true;
		Date today =new Date();
		long ms = leaveDetails.getLeaveStartDate().getTime() - 
					today.getTime();
		int days = (int) ms / (1000 * 60 * 60 * 24);
		if (days < 0) {
			sb.append("Leave-StartDate cannot be Yesterday...");
			flag = false;
		}
		ms = leaveDetails.getLeaveEndDate().getTime() - 
					today.getTime();
		days = (int) ms / (1000 * 60 * 60 * 24);
		if (days < 0) {
			sb.append("Leave-EndDate Cannot be Yesterdays...");
			flag = false;
		}
		ms = leaveDetails.getLeaveEndDate().getTime() - 
					leaveDetails.getLeaveStartDate().getTime();
		days = (int) ms / (1000 * 60 * 60 * 24);
		if (days < 0) {
			sb.append("Leave StartDate cannot be Greater than leave Enddate");
			flag = false;
		}
		return flag;
	}


}
