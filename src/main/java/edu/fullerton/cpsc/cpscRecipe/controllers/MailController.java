package edu.fullerton.cpsc.cpscRecipe.controllers;

/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * courtesy of google github account 
 */

// [START simple_includes]
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
// [END simple_includes]

import java.io.UnsupportedEncodingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
// [END multipart_includes]

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class MailController {

	@RequestMapping(value = RecipeMakerConstants.SHARE_THIS_RECIPE, method = RequestMethod.POST)
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String type = req.getParameter("type");
		if (type != null && type.equals("multipart")) {
			resp.getWriter().print("Sending HTML email with attachment.");
			sendMultipartMail();
		} else {
			resp.getWriter().print("Sending simple email.");
			sendSimpleMail();
		}
	}

	@RequestMapping(value = RecipeMakerConstants.SHARE_THIS_RECIPE, method = RequestMethod.GET)
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String type = req.getParameter("type");
		if (type != null && type.equals("multipart")) {
			resp.getWriter().print("Sending HTML email with attachment.");
			sendMultipartMail();
		} else {
			resp.getWriter().print("Sending simple email.");
			sendSimpleMail();
		}
	}

	private void sendSimpleMail() {
		// [START simple_example]
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("nimeshprabhu5555@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("devnigam24@csu.fullerton.edu", "Mr. Dev"));
			msg.setSubject("Your Quick recipe maker account has been activated");
			Transport.send(msg);
		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		} catch (UnsupportedEncodingException e) {
			// ...
		}
		// [END simple_example]
	}

	private void sendMultipartMail() {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String msgBody = "recipe maker";

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("nimeshprabhu5555@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("devnigam24@csu.fullerton.edu", "Mr. Dev"));
			msg.setSubject("Your Quick recipe maker account has been activated");
			msg.setText(msgBody);

			// [START multipart_example]
			String htmlBody = ""; // ...
			byte[] attachmentData = null; // ...
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlBody, "text/html");
			mp.addBodyPart(htmlPart);

			msg.setContent(mp);
			// [END multipart_example]

			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		} catch (UnsupportedEncodingException e) {
			// ...
		}
	}
}
