package com.flaviussana.demo.service;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

public final class HuiResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8378495908491170239L;
	private Map<String, ListHolder> map;

	public void setMap(final Map<String, ListHolder> map) {
		this.map = map;
	}

	@XmlElement
	public Map<String, ListHolder> getMap() {
		return map;
	}

}
