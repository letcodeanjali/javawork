package com.java.Agent;
import java.sql.SQLException;
import java.util.Scanner;



public class AgentUpdateMain {
	
	    public static void main(String[] args) {
	        Agent agent = new Agent();
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Agent ID: ");
	        agent.setAgentID(sc.nextInt());
	        System.out.println("Enter Agent Name: ");
	        agent.setName(sc.next());
	        System.out.println("Enter City: ");
	        agent.setCity(sc.next());
	        System.out.println("Enter Gender: ");
	        agent.setGender(sc.next());
	        System.out.println("Enter Marital Status: ");
	        agent.setMaritalStatus(sc.nextInt());
	        System.out.println("Enter Premium: ");
	        agent.setPremium(sc.nextDouble());
	        AgentDao dao = new AgentDaoImpl();
	        try {
	            System.out.println(dao.updateAgentDao(agent));
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
}
