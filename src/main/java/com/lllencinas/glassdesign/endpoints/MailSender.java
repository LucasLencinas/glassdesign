package com.lllencinas.glassdesign.endpoints;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Path("/mailsender")
public class MailSender {

	@GET
	@Produces("application/json")
	public Response echoMessage(){
		System.out.println("Me llego un GET a echo");

		String MAILGUN_DOMAIN_NAME = "mg.glassdesign";
		String MAILGUN_API_KEY = "key-5bd724f94fa38e82a0a602ff3fcdb2dd";
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", MAILGUN_API_KEY));
		WebResource webResource = client.resource("https://api.mailgun.net/v3/" + MAILGUN_DOMAIN_NAME
				+ "/messages");
		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		formData.add("from", "Glass Design <lucaslencinas@" + MAILGUN_DOMAIN_NAME + ">");
		formData.add("to", "lllencinas@gmail.com");
		formData.add("subject", "Simple Mailgun Example");
		formData.add("text", "Plaintext content");
		webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);

		return Response.ok("{}",MediaType.APPLICATION_JSON).build();
	}
}

