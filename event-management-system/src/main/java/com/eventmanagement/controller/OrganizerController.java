// src/main/java/com/eventmanagement/controller/OrganizerController.java
package com.eventmanagement.controller;

import com.eventmanagement.model.Event;
import com.eventmanagement.service.OrganizerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/organizer")
public class OrganizerController {
    private OrganizerService organizerService = new OrganizerService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @QueryParam("registrationId") String registrationId,
            @QueryParam("password") String password) {
        boolean isValid = organizerService.authenticateOrganizer(registrationId, password);
        if (isValid) {
            return Response.ok().entity("{\"status\": \"success\"}").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("{\"error\": \"Invalid credentials\"}").build();
    }

    @POST
    @Path("/events/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEvent(Event event) {
        String permittedVenue = organizerService.getPermittedVenue(event.getOrganizerId());
        if (permittedVenue == null || !permittedVenue.equals(event.getVenue())) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("{\"error\": \"You are not permitted to use this venue\"}").build();
        }
        
        boolean success = organizerService.createEvent(event);
        if (success) {
            return Response.ok().entity("{\"status\": \"Event created successfully\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Failed to create event\"}").build();
    }

    @POST
    @Path("/organizers/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrganizer(
            @QueryParam("registrationId") String registrationId,
            @QueryParam("eventId") int eventId) {
        boolean success = organizerService.addCoOrganizer(registrationId, eventId);
        if (success) {
            return Response.ok().entity("{\"status\": \"Organizer added successfully\"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Failed to add organizer\"}").build();
    }
}