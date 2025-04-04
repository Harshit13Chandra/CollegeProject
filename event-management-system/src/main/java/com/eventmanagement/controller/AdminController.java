// src/main/java/com/eventmanagement/controller/AdminController.java
package main.java.com.eventmanagement.controller;

import main.java.com.eventmanagement.model.Student;
import main.java.com.eventmanagement.service.AdminService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
public class AdminController {
    private AdminService adminService = new AdminService();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("id") int id, @QueryParam("password") String password) {
        boolean isValid = adminService.authenticateAdmin(id, password);
        if (isValid) {
            return Response.ok().entity("{\"status\": \"success\"}").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("{\"error\": \"Invalid credentials\"}").build();
    }

    @POST
    @Path("/students/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(List<Student> students) {
        boolean success = adminService.addStudentsInBulk(students);
        if (success) {
            return Response.ok().entity("{\"status\": \"Students added successfully\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Failed to add students\"}").build();
    }

    @POST
    @Path("/organizer/grant")
    @Produces(MediaType.APPLICATION_JSON)
    public Response grantOrganizerPermission(
            @QueryParam("registrationId") String registrationId,
            @QueryParam("venue") String venue) {
        boolean success = adminService.grantOrganizerPermission(registrationId, venue);
        if (success) {
            return Response.ok().entity("{\"status\": \"Permission granted\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Failed to grant permission\"}").build();
    }
}