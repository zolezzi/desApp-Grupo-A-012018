package edu.unq.desapp.grupo_a.backend.utils;

import edu.unq.desapp.grupo_a.backend.model.Notification;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.repository.NotificationRepository;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	/**
	 * Utility method to send HTML emails
	 * @param toEmails
	 * @param subject
	 * @param body
	 */
	public static void sendEmails(List<User> toEmails, String subject, String body){

		Session session = getSession();

		NotificationRepository notificationRepository = new NotificationRepository();
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      for (User user : toEmails) {
			  msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail(), false));
			  Transport.send(msg);
			  //notificationRepository.save(new Notification(body, user.getId()));
		  }
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}

	private static Session getSession() {

		final String fromEmail = "carpnd.grupoa@gmail.com";
		final String password = "p13dp1p3r";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

		//create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		return Session.getInstance(props, auth);
	}
}