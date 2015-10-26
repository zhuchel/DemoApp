package com.validation;

import java.util.Locale;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/journey")
@javax.enterprise.context.RequestScoped
public class JourneyDetailsResource extends AbstractRestValidator {

   
    @POST
    @Path("/details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchJourneyDetails() {
        Response response = null;

        // First validate input
        Locale locale = ValidationUtils.getLocaleForLanguage(null);
        ViolationMessages messages = validate(locale, omLeg, ILegTimeMarker.class);
        if (messages != null) {
            return setNonAcceptedResponse(messages);
        }

        
        return response;

    }

}
