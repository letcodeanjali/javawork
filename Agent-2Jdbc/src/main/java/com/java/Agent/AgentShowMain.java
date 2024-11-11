package com.java.Agent;
import java.sql.SQLException;
import java.util.List;


public class AgentShowMain {
	
	

	    public static void main(String[] args) {
	        AgentDao dao = new AgentDaoImpl();
	        try {
	            List<Agent> agentList = dao.showAgentDao();
	            for (Agent agent : agentList) {
	                System.out.println(agent);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


