package com.jaxrs.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.provider.JAXBElementProvider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		client.register(new JacksonJsonProvider());
		client.register( new JAXBElementProvider<Object>());

		WebTarget target = client.target("http://localhost:8383/api/patientservice/patient/123");
		
		Builder request1 = target.request();
		request1.accept(MediaType.APPLICATION_XML);
		Patient patient1 = request1.get(Patient.class);
		
		Builder request2 = target.request();
		request2.accept(MediaType.APPLICATION_JSON);
		Patient patient2 = request2.get(Patient.class);
		
		System.out.println(MediaType.APPLICATION_XML);
		System.out.println(patient1.getId());
		System.out.println(patient1.getName());
		
		System.out.println(MediaType.APPLICATION_JSON);
		System.out.println(patient2.getId());
		System.out.println(patient2.getName());

	}
}
