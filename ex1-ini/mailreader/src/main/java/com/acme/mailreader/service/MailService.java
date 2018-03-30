package com.acme.mailreader.service;

import com.acme.mailreader.infrastructure.SmtpMailSender;
import com.acme.mailreader.presentation.CLI;
import com.acme.mailreader.domaine.Mail;
import com.acme.mailreader.infrastructure.InMemoryMailSender;
import com.acme.mailreader.infrastructure.MailSender;

public class MailService {
	private MailSender sender;
	public void envoyerMail(Mail mail){
		if (CLI.production){
			sender = new SmtpMailSender();
		}else {
			sender = new InMemoryMailSender();
		}
		sender.envoyerMail(mail);
}
}
