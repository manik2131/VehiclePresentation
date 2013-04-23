package com.mindtree.awsfinalpresentation.SendRequest;

import javax.ws.rs.core.MediaType;


import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * SendRequestImpl is the implementation of SendRequest interface
 * using jersey api
 * */
public class SendRequestImpl implements SendRequest {

	 private Logger logger =LoggerFactory.getLogger(SendRequestImpl.class);
	// Sends Post Request to business layer with XML data
	public ClientResponse sendPostRequest(String URL, String xmlString) {

		logger.info("Sending Post request to business layer...");
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client
				.create();
		WebResource service = client.resource(URL);
		com.sun.jersey.api.client.WebResource.Builder builder = service
				.type(MediaType.APPLICATION_XML);
		builder = builder.accept(MediaType.TEXT_PLAIN);// Add acceptable media
														// types

		builder = builder.entity(xmlString);
		final ClientResponse response = builder.post(ClientResponse.class);

		return response;

	}

	// Sends Get Request to business layer
	public ClientResponse sendGetRequest(String URL) {
		logger.info("Sending GET request to business layer...");
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client
				.create();
		WebResource service = client.resource(URL);
		com.sun.jersey.api.client.WebResource.Builder builder = service
				.type(MediaType.APPLICATION_XML);
		final ClientResponse response = builder.get(ClientResponse.class);

		return response;
	}

}
