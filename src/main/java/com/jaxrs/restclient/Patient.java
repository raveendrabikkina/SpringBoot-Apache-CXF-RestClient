package com.jaxrs.restclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
public class Patient {
	String name;
	long id;

	public Patient() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}