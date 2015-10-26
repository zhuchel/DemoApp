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

import com.daimler.mop.bom.Leg;
import com.daimler.mop.bom.MspCredentials;
import com.daimler.mop.ejb.JourneyDetailService;
import com.daimler.mop.ejb.MspAuthenticationService;
import com.daimler.mop.openmobility.bom.v4.OMLeg;
import com.daimler.mop.openmobility.mapper.v4.LegMapper;
import com.daimler.mop.openmobility.mapper.v4.OMLegMapper;
import com.daimler.mop.validation.AbstractRestValidator;
import com.daimler.mop.validation.ValidationUtils;
import com.daimler.mop.validation.ViolationMessages;
import com.daimler.mop.validation.marker.ILegTimeMarker;
import com.dcx.iap.logging.ApplicationLogger;

@Path("/journey")
@javax.enterprise.context.RequestScoped
@Interceptors(ExceptionLoggingInterceptorV4.class)
public class JourneyDetailsResource extends AbstractRestValidator {

    private static final ApplicationLogger LOGGER = ApplicationLogger
            .getApplicationLogger(JourneyDetailsResource.class);

    @EJB
    protected JourneyDetailService routeDetailService;

    @Inject
    protected LegMapper legMapper;

    @Inject
    protected OMLegMapper omLegMapper;

    @Inject
    protected MspAuthenticationService mspAuthenticationService;

    @POST
    @Path("/details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchJourneyDetails(@DefaultValue("") @HeaderParam("X-MOP-Msp-User-Id") String mspUserId,
            @DefaultValue("") @HeaderParam("X-MOP-Msp-Password") String mspPassword,
            @HeaderParam("X-MOP-Language") String language, OMLeg omLeg) {
        Response response = null;

        // First validate input
        Locale locale = ValidationUtils.getLocaleForLanguage(null);
        ViolationMessages messages = validate(locale, omLeg, ILegTimeMarker.class);
        if (messages != null) {
            return setNonAcceptedResponse(messages);
        }

        Leg leg = new Leg();
        legMapper.mapFromOMLeg(omLeg, leg);

        // Special handling for already authenticated users
        MspCredentials mspCredentials = null;
        try {
            mspCredentials = mspAuthenticationService.checkAuthentication(leg.getMsp(), mspUserId, mspPassword, null);
        } catch (Exception e) {
            // catch exception because MspNotAuthenticatedException is wrapped in EJBException OR
            // InvocationTargetException or whatever
            // ignore, request can be made anyways but may return more data if succeeded
            LOGGER.info("1407", "Failed to retrieve MspCredentials", e);
        }

        Leg detailleg = routeDetailService.findJourneyDetails(leg, mspCredentials);

        if (detailleg != null) {
            omLegMapper.mapFromLeg(omLeg, leg);
            response = Response.status(Status.OK).entity(omLeg).build();
        } else {
            response = Response.status(Status.NO_CONTENT).build();
        }
        return response;

    }

}
