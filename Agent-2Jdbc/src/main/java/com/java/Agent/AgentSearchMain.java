package com.java.Agent;
import java.sql.SQLException;
import java.util.Scanner;


public class AgentSearchMain {
	
	
	

	    public static void main(String[] args) {
	        int agentID;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Agent ID: ");
	        agentID = sc.nextInt();
	        AgentDao dao = new AgentDaoImpl();
	        try {
	            Agent agent = dao.searchAgentDao(agentID);
	            if (agent != null) {
	                System.out.println(agent);
	            } else {
	                System.out.println("*** Record Not Found ***");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



