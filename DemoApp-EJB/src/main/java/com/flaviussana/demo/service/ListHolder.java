package com.flaviussana.demo.service;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ListHolder {
	
	private List<CacheInformation> list;

	public void setList(List<CacheInformation> list) {
		this.list = list;
	}

	@XmlElement
	public List<CacheInformation> getList() {
		return list;
	}

}
