package org.ara.opa.decision.log;

import org.ara.opa.decision.log.model.DecisionLog;
import org.ara.opa.decision.log.model.Labels;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/logs")
public class Resource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{partitionName}")
    public DecisionLog loggingToDatabase(@PathParam("partitionName") String partitionName, DecisionLog [] messageBody) {
        return messageBody[0];
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String loggingToDatabase(String messageBody) {
        return messageBody;
    }
}