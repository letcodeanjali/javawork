package com.java.Agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDaoImpl  implements AgentDao {
	
	Connection connection;
    PreparedStatement pst;

    @Override
    public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
        String cmd = "SELECT * FROM Agent";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        List<Agent> agentList = new ArrayList<>();
        while (rs.next()) {
            Agent agent = new Agent();
            agent.setAgentID(rs.getInt("AgentID"));
            agent.setName(rs.getString("Name"));
            agent.setCity(rs.getString("City"));
            agent.setGender(rs.getString("GENDER"));
            agent.setMaritalStatus(rs.getInt("MaritalStatus"));
            agent.setPremium(rs.getDouble("Premium"));
            agentList.add(agent);
        }
        return agentList;
    }

    @Override
    public Agent searchAgentDao(int agentID) throws ClassNotFoundException, SQLException {
        String cmd = "SELECT * FROM Agent WHERE AgentID = ?";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, agentID);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Agent agent = new Agent();
            agent.setAgentID(rs.getInt("AgentID"));
            agent.setName(rs.getString("Name"));
            agent.setCity(rs.getString("City"));
            agent.setGender(rs.getString("GENDER"));
            agent.setMaritalStatus(rs.getInt("MaritalStatus"));
            agent.setPremium(rs.getDouble("Premium"));
            return agent;
        }
        return null;
    }

    @Override
    public String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException {
        String cmd = "INSERT INTO Agent(Name, City, GENDER, MaritalStatus, Premium) VALUES (?, ?, ?, ?, ?)";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setString(1, agent.getName());
        pst.setString(2, agent.getCity());
        pst.setString(3, agent.getGender());
        pst.setInt(4, agent.getMaritalStatus());
        pst.setDouble(5, agent.getPremium());
        pst.executeUpdate();
        return "Agent Record Inserted...";
    }

    @Override
    public String deleteAgentDao(int agentID) throws ClassNotFoundException, SQLException {
        Agent agentFound = searchAgentDao(agentID);
        if (agentFound != null) {
            String cmd = "DELETE FROM Agent WHERE AgentID = ?";
            connection = ConnectionHelper.getConnection();
            pst = connection.prepareStatement(cmd);
            pst.setInt(1, agentID);
            pst.executeUpdate();
            return "Agent Record Deleted...";
        } else {
            return "Agent Record Not Found...";
        }
    }

    @Override
    public String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException {
        String cmd = "UPDATE Agent SET Name = ?, City = ?, GENDER = ?, MaritalStatus = ?, Premium = ? WHERE AgentID = ?";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setString(1, agentNew.getName());
        pst.setString(2, agentNew.getCity());
        pst.setString(3, agentNew.getGender());
        pst.setInt(4, agentNew.getMaritalStatus());
        pst.setDouble(5, agentNew.getPremium());
        pst.setInt(6, agentNew.getAgentID());
        pst.executeUpdate();
        return "Agent Record Updated...";
    }
}


