package com.github.ryankenney.rkenney_swagger_example.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/hello")
@Produces({ MediaType.TEXT_PLAIN })
@Api(value = "/hello")
public class HelloService {

	@Path("/")
	@GET
	@ApiOperation(value = "Check that service is online. Returns \"hi\" on success.")
	public Response sayHi() {
		return Response.ok("hi", MediaType.TEXT_PLAIN).build();
	}
}
