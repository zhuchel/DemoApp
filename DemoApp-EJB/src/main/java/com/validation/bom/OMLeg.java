/**
 * @(#) OMLeg.java
 */

package com.validation.bom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.daimler.mop.validation.IValidation;
import com.daimler.mop.validation.marker.ILegTimeMarker;
import com.daimler.mop.validation.marker.IMyTaxiBookingMarker;
import com.daimler.mop.validation.marker.IRideAnnouncementInfoMarker;
import com.daimler.mop.validation.marker.IRideAnnouncementSearchMarker;

/**
 * Represents a journey section containing information about locations, time, vehicle and MSP
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OMLeg implements com.validation.IValidation {

    private OMMobilityServiceProvider msp;

    @Valid
    @NotNull(message = "notnullvalidator", groups = { ILegTimeMarker.class, IRideAnnouncementInfoMarker.class,
            IRideAnnouncementSearchMarker.class, Default.class })
    private OMLocation startLocation;

    @Valid
    @NotNull(message = "notnullvalidator", groups = { ILegTimeMarker.class, IRideAnnouncementInfoMarker.class,
            IRideAnnouncementSearchMarker.class, Default.class })
    private OMLocation endLocation;

    @Valid
    @NotNull(message = "notnullvalidator", groups = { ILegTimeMarker.class, IRideAnnouncementInfoMarker.class,
            IRideAnnouncementSearchMarker.class })
    private OMPlanedRealTime startTime;

    private List<OMStep> steps;

    @NotNull(message = "notnullvalidator", groups = ILegTimeMarker.class)
    private OMPlanedRealTime endTime;

    @Valid
    @NotNull(message = "notnullvalidator", groups = { IRideAnnouncementInfoMarker.class, IMyTaxiBookingMarker.class })
    private OMVehicleInfo vehicleInfo;

    private final Map<String, String> properties;

    private OMRoute route;

    public OMLeg() {
        this.properties = new HashMap<String, String>();
    }

    public void setMsp(OMMobilityServiceProvider msp) {
        this.msp = msp;
    }

    public OMMobilityServiceProvider getMsp() {
        return msp;
    }

    public void setStartLocation(OMLocation startLocation) {
        this.startLocation = startLocation;
    }

    public OMLocation getStartLocation() {
        return startLocation;
    }

    public void setEndLocation(OMLocation endLocation) {
        this.endLocation = endLocation;
    }

    public OMLocation getEndLocation() {
        return endLocation;
    }

    public void setStartTime(OMPlanedRealTime startTime) {
        this.startTime = startTime;
    }

    public OMPlanedRealTime getStartTime() {
        return startTime;
    }

    public void setSteps(List<OMStep> steps) {
        this.steps = steps;
    }

    public List<OMStep> getSteps() {
        return steps;
    }

    public void setEndTime(OMPlanedRealTime endTime) {
        this.endTime = endTime;
    }

    public OMPlanedRealTime getEndTime() {
        return endTime;
    }

    public void setVehicleInfo(OMVehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public OMVehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    public OMRoute getRoute() {
        return route;
    }

    public void setRoute(OMRoute route) {
        this.route = route;
    }

    public void putProperty(String key, String value) {
        properties.put(key, value);
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
