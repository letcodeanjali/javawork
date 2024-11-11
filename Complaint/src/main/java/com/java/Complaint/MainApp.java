package com.java.Complaint;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;

public class MainApp {

	public static void main(String[] args) {
		// Bootstrap Hibernate
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // Load settings from
																							// hibernate.cfg.xml
				.build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		// Example usage
		ComplaintDAO complaintDAO = new ComplaintDAOImpl(sessionFactory);

		// Add complaint example
		Complaint newComplaint = new Complaint();
		newComplaint.setComplaintType("Software");
		newComplaint.setCDescription("Application crashing frequently");
		newComplaint.setSeverity("High");
		complaintDAO.addComplaint(newComplaint);

		// Search complaint example
		Complaint foundComplaint = complaintDAO.searchComplaint(1);
		System.out.println("Found Complaint: " + foundComplaint);

		// Get all complaints example
		List<Complaint> allComplaints = complaintDAO.getAllComplaints();
		System.out.println("All Complaints:");
		for (Complaint complaint : allComplaints) {
			System.out.println(complaint);
		}

		// Shutdown Hibernate
		sessionFactory.close();
	}
}
