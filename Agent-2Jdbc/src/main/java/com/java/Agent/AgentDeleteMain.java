package com.java.Agent;
import java.sql.SQLException;
import java.util.Scanner;


public class AgentDeleteMain {
	
	

	    public static void main(String[] args) {
	        int agentID;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Agent ID: ");
	        agentID = sc.nextInt();
	        AgentDao dao = new AgentDaoImpl();
	        try {
	            System.out.println(dao.deleteAgentDao(agentID));
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



