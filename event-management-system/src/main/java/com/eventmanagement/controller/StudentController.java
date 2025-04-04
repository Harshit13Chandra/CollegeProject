// src/main/java/com/eventmanagement/controller/StudentController.java
package com.eventmanagement.controller;

import com.eventmanagement.model.Event;
import com.eventmanagement.service.StudentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/student")
public class StudentController {
    private StudentService studentService = new StudentService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @QueryParam("registrationId") String registrationId,
            @QueryParam("password") String password) {
        boolean isValid = studentService.authenticateStudent(registrationId, password);
        if (isValid) {
            return Response.ok().entity("{\"status\": \"success\"}").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("{\"error\": \"Invalid credentials\"}").build();
    }

    @GET
    @Path("/events/upcoming")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUpcomingEvents() {
        List<Event> events = studentService.getUpcomingEvents();
        return Response.ok().entity(events).build();
    }

    @POST
    @Path("/events/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerForEvent(
            @QueryParam("registrationId") String registrationId,
            @QueryParam("eventId") int eventId) {
        boolean success = studentService.registerForEvent(registrationId, eventId);
        if (success) {
            return Response.ok().entity("{\"status\": \"Registered successfully\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Registration failed\"}").build();
    }

    @POST
    @Path("/events/rate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response rateEvent(
            @QueryParam("eventId") int eventId,
            @QueryParam("rating") double rating) {
        boolean success = studentService.rateEvent(eventId, rating);
        if (success) {
            return Response.ok().entity("{\"status\": \"Rating submitted\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Failed to submit rating\"}").build();
    }
}