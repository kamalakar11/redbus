package com.redbus.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

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
}
