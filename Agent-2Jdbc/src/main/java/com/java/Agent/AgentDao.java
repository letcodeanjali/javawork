package com.java.Agent;

import java.sql.SQLException;
import java.util.List;

public interface AgentDao {
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
    Agent searchAgentDao(int agentID) throws ClassNotFoundException, SQLException;
    String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException;
    String deleteAgentDao(int agentID) throws ClassNotFoundException, SQLException;
    String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException;


}
