package com.github.ryankenney.rkenney_swagger_example.services;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.ryankenney.rkenney_swagger_example.services.pojos.DatabaseEntry;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/database")
@Produces({ MediaType.APPLICATION_JSON })
@Api(value = "/database")
public class DatabaseService {

	private static final HashMap<String, HashMap<Integer, String>>DATABASE = new HashMap<>();
	static {
		DATABASE.put("dog", new HashMap<>());
		DATABASE.get("dog").put(0, "peter");
		DATABASE.get("dog").put(1, "wilson");
		DATABASE.put("cat", new HashMap<>());
		DATABASE.get("cat").put(0, "mowmow");
		DATABASE.get("cat").put(1, "samantha");
	}
	
	@Path("/{type}/{id}")
	@GET
	@ApiOperation(
			// Operation description
			value = "Get database entry",
			// Operation nickname (can help describe if the path is overly simple)
			nickname = "getDatabaseEntry",
			// Operation response type (on success. errors covered below.)
			response = DatabaseEntry.class)
	// Describes non-success responses
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Entry does not exist") } )
	public Response getDatabaseEntry(
			// Describes non-success responses
			@ApiParam(
					// Parameter description (name covered by @PathParam)
					value = "Item type",
					// Parameter "is required"
					required = true,
					// Parameter example value
					example = "dog")
			@PathParam("type") String type,
			@ApiParam(
					value = "Item ID",
					required = true,
					example = "1")
			@PathParam("id") int id) {
		
		HashMap<Integer, String> typeMap = DATABASE.get(type);
		if (typeMap == null) {
			return Response.status(Status.NOT_FOUND).entity("{\"not found\":\"type\"}").type(MediaType.APPLICATION_JSON_TYPE).build();
		}
		String item = typeMap.get(id);
		if (item == null) {
			return Response.status(Status.NOT_FOUND).entity("{\"not found\":\"id\"}").type(MediaType.APPLICATION_JSON_TYPE).build();
		}
		return Response.ok(new DatabaseEntry(id, type, item), MediaType.APPLICATION_JSON_TYPE).build();
	}
}
