package com.github.ZXSkelobrine.barcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public final class Mail {
	public static void sendMail(String toSend, String subject) throws MessagingException {
		String host = "smtp.gmail.com";
		String from = "zxstocktracker@gmail.com";
		String pass = getPassFromFile();
		String to = getToFromFile();
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");

		Session session = Session.getDefaultInstance(props, new GMailAuthenticator(from, pass));
		MimeMessage message = new MimeMessage(session);
		Address fromAddress = new InternetAddress(from);
		Address toAddress = new InternetAddress(to);

		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);

		message.setSubject(subject);
		message.setText(toSend);
		Transport transport = session.getTransport("smtp");
		transport.connect(host, from, pass);
		message.saveChanges();
		Transport.send(message);
		transport.close();
	}

	private static String getToFromFile() {
		try {
			FileInputStream fis = new FileInputStream(new File("C:/Program Files/StockKeeper/mailSettingsTo.txt"));
			byte[] b = new byte[fis.available()];
			fis.read(b);
			byte[] bytes = Hex.decodeHex(new String(b).toCharArray());
			fis.close();
			return new String(bytes, "UTF8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getPassFromFile() {
		try {
			FileInputStream fis = new FileInputStream(new File("C:/Program Files/StockKeeper/mailSettingsPass.txt"));
			byte[] b = new byte[fis.available()];
			fis.read(b);
			byte[] bytes = Hex.decodeHex(new String(b).toCharArray());
			fis.close();
			return new String(bytes, "UTF8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return null;
	}

}