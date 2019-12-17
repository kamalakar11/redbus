package com.redbus.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redbus.pojo.Team;
import com.redbus.services.impl.IplServiceImpl;

@Path(value = "/ipl")
public class IplService {

	@GET
	@Path(value = "/wish")
	public Response wishMe() {
		System.out.println("executing wishMe!!");
		String message = "Good Morning!!";
		System.out.println("exiting wishMe!!");
		return Response.status(200).entity(message).build();
	}

	@POST
	@Path(value = "/registerTeam")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response registerForIpl(Team team) {
		System.out.println("IplService :: registerForIpl");
		IplServiceImpl service = new IplServiceImpl();
		return service.registerForIpl(team);
	}

	@GET
	@Path("/getTeamJson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeamJson(@QueryParam("name") String teamName) {
		System.out.println("Entered into getTeamJson : " + teamName);
		IplServiceImpl service = new IplServiceImpl();
		Team team = service.getTeam(teamName);
		return Response.status(200).entity(team).build();
	}

	@GET
	@Path("/getTeamXml")
	@Produces(MediaType.APPLICATION_XML)
	public Response getTeamInXml(@QueryParam("name") String teamName) {
		System.out.println("Entered into getTeamInXml : " + teamName);
		IplServiceImpl service = new IplServiceImpl();
		Team team = service.getTeam(teamName);
		return Response.status(200).entity(team).build();
	}
	
	@GET
	@Path("/getTeam")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getTeam(@QueryParam("name") String teamName) {
		System.out.println("Entered into getTeam : " + teamName);
		IplServiceImpl service = new IplServiceImpl();
		Team team = service.getTeam(teamName);
		return Response.status(200).entity(team).build();
	}

	@DELETE
	@Path(value = "/deleteTeam/{name}")
	public Response deleteTeam(@PathParam("name") String teamName) {
		IplServiceImpl service = new IplServiceImpl();
		return service.deleteTeam(teamName);
	}

}
