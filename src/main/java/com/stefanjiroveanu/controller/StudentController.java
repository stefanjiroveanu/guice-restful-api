package com.stefanjiroveanu.controller;

import com.stefanjiroveanu.persistance.model.Student;
import com.stefanjiroveanu.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api")
public class StudentController {

    @Inject
    private StudentService service;

    @GET
    @Path("/{uuid}")
    @Produces(APPLICATION_JSON)
    public Response findStudent(@PathParam("uuid") String uuid) {
        return Response.ok(service.findByUuid(uuid)).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response saveStudent(Student student) {
        return Response.ok(service.save(student)).build();
    }

    @DELETE
    @Path("/{uuid}")
    public Response deleteStudent(@PathParam("uuid") String uuid) {
        service.delete(uuid);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{uuid}")
    @Produces(APPLICATION_JSON)
    public Response updateStudent(@PathParam("uuid") String uuid, Student student) {
        return Response.ok(service.update(uuid, student)).build();
    }
}
