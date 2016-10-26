package com.lllencinas.glassdesign.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




@Path("/mailsender")
public class MailSender {

	@GET
	@Produces("application/json")
	public Response echoMessage(){
		System.out.println("Me llego un GET a echo");

		// ...
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String msgBody = "Body del mensaje de ejemplo";

		try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress("lucas.lencinas@hotmail.com", "Mister Lucas"));
		    msg.addRecipient(Message.RecipientType.TO,
		     new InternetAddress("lllencinas@gmail.com", "glassdesign admin"));
		    msg.setSubject("Subject de ejemplo");
		    msg.setText(msgBody);
		    Transport.send(msg);

		} catch (AddressException e) {
		    // ...
			System.out.println(e.getMessage());
		} catch (MessagingException e) {
		    // ...
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return Response.ok("{}",MediaType.APPLICATION_JSON).build();
	}
}
