/**
 * @(#) OMLeg.java
 */

package com.validation.bom;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.validation.IValidation;
import com.validation.constraints.LocalizedRegexp;




public class OMLegDay implements IValidation {

    @NotNull
	private String name;
    
    @LocalizedRegexp(day=Day.MONDAY)
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

   

   
}
