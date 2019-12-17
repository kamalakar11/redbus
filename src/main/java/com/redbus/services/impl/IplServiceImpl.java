package com.redbus.services.impl;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.redbus.dao.IplServicDaoImpl;
import com.redbus.pojo.Team;

public class IplServiceImpl {

	public Response registerForIpl(Team team) {
		System.out.println("IplServiceImpl::registerForIpl");
		double totalMatches = team.getTotalMatches();
		double win = team.getWin();
		double winRatio = (win/totalMatches)*100;
		String message;
		if(winRatio > 60) {
			team.setStatus("Accepted");
			System.out.println("Saving team to database");
			message = "Congratulations!! Your registered for IPL!! Start practice";
		} else {
			System.out.println("Team is rejected!! Try next year!!");
			message = "Sorry!! Team is rejected!! Try next year!!";
		}
		
		IplServicDaoImpl dao = new IplServicDaoImpl();
		dao.registerForIpl(team);
		return Response.status(200).entity(message).build();
	}
	
	public Team getTeam(String teamName) {
		IplServicDaoImpl dao = new IplServicDaoImpl();
		Team team = dao.getTeam(teamName);
		return team;
	}

	public Response deleteTeam(String teamName) {
		IplServicDaoImpl dao = new IplServicDaoImpl();
		int count = dao.deleteTeam(teamName);
		String message;
		if(count > 0) {
			message = teamName + " deleted successfully!!";
		} else {
			message = teamName + " Not found!!";
		}
		return Response.status(200).entity(message).build();
	}
}
