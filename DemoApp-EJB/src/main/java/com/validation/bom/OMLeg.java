/**
 * @(#) OMLeg.java
 */

package com.validation.bom;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.validation.IValidation;
import com.validation.constraints.LocalizedRegexp;
import com.validation.marker.ILegTimeMarker;




public class OMLeg implements IValidation {

    @NotNull
	private String name;
    
    @Valid
    private OMLegDay day;
    
    @LocalizedRegexp(groups={ILegTimeMarker.class})
	private Date dt;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Date getDt() {
		return dt;
	}

	public void setDay(OMLegDay day) {
		this.day = day;
	}

	public OMLegDay getDay() {
		return day;
	}

   

   
}
