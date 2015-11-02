/**
 * @(#) OMLeg.java
 */

package com.validation.bom;

import javax.validation.constraints.NotNull;

import com.validation.IValidation;
import com.validation.constraints.LocalizedRegexpHui;
import com.validation.marker.ILegTimeMarker;




public class OMLegDay implements IValidation {

    @NotNull
	private String name;
    
    @LocalizedRegexpHui(groups={ILegTimeMarker.class})
	private String dt;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getDt() {
		return dt;
	}

   

   
}
