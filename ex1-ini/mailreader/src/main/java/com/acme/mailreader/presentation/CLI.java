package com.acme.mailreader.presentation;

import com.acme.mailreader.domaine.Mail;
import com.acme.mailreader.infrastructure.InMemoryMailSender;
import com.acme.mailreader.infrastructure.MailSender;
import com.acme.mailreader.infrastructure.SmtpMailSender;

public class CLI {
	public static boolean production;
	
	public static void main(String[] args) {
		production = Boolean.parseBoolean(args[0]);
		MailSender mailSender = production ? new SmtpMailSender() : new InMemoryMailSender();
		Mail mail = new Mail();
		mail.setSujet(args[1]);
		mailSender.envoyerMail(mail);
	}
}
