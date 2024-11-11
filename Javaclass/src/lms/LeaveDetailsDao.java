package lms;

import java.util.List;

public  interface LeaveDetailsDao {
	 List<LeaveDetails> showLeaveDao();
	 String addLeaveDao(LeaveDetails leaveDetails);

}
