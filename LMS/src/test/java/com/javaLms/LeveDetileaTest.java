package com.javaLms;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class LeveDetileaTest {

	@Test
	public void testToString() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LeaveDetails leavDetails = new LeaveDetails(1, 1000, sdf.parse("2024-10-10"), 
				sdf.parse("2024-10-12"), "Sick", "EL", "PENDING", "Enjoy");
		String result ="LeaveDetails [leaveId=1, empId=1000, leaveStartDate=Thu Oct 10 00:00:00 IST 2024, leaveEndDate=Sat Oct 12 00:00:00 IST 2024, "
				+ "leaveReason=Sick, leaveType=EL, leaveStatus=PENDING, managerComments=Enjoy]";
		assertEquals(result, leavDetails.toString());
	}
	@Test
	public void testConstructors() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LeaveDetails leaveDetails = new LeaveDetails();
		assertNotNull(leaveDetails);
		LeaveDetails leavDetails = new LeaveDetails(1, 1000, sdf.parse("2024-10-10"), 
				sdf.parse("2024-10-12"), "Sick", "EL", "PENDING", "Enjoy");
		assertEquals(1, leavDetails.getLeaveId());
		assertEquals(1000, leavDetails.getEmpId());
		assertEquals("2024-10-10", sdf.format(leavDetails.getLeaveStartDate()));
		assertEquals("2024-10-12", sdf.format(leavDetails.getLeaveEndDate()));
		assertEquals("Sick", leavDetails.getLeaveReason());
		assertEquals("EL", leavDetails.getLeaveType());
		assertEquals("PENDING", leavDetails.getLeaveStatus());
		assertEquals("Enjoy", leavDetails.getManagerComments());
	}

	@Test
	public void testGettersAndSetters() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LeaveDetails leaveDetails = new LeaveDetails();
		leaveDetails.setLeaveId(1);
		leaveDetails.setEmpId(1000);
		leaveDetails.setLeaveStartDate(sdf.parse("2024-10-10"));
		leaveDetails.setLeaveEndDate(sdf.parse("2024-10-12"));
		leaveDetails.setLeaveReason("Sick");
		leaveDetails.setLeaveType("EL");
		leaveDetails.setLeaveStatus("PENDING");
		leaveDetails.setManagerComments("Enjoy");
		
		assertEquals(1, leaveDetails.getLeaveId());
		assertEquals(1000, leaveDetails.getEmpId());
		assertEquals("2024-10-10", sdf.format(leaveDetails.getLeaveStartDate()));
		assertEquals("2024-10-12", sdf.format(leaveDetails.getLeaveEndDate()));
		assertEquals("Sick", leaveDetails.getLeaveReason());
		assertEquals("EL", leaveDetails.getLeaveType());
		assertEquals("PENDING", leaveDetails.getLeaveStatus());
		assertEquals("Enjoy", leaveDetails.getManagerComments());
	}
}

