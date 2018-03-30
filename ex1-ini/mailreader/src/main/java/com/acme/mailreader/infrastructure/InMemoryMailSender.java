package com.acme.mailreader.infrastructure;

import com.acme.mailreader.domaine.Mail;
import com.acme.mailreader.infrastructure.MailSender;

public class InMemoryMailSender implements MailSender {
	public void envoyerMail(Mail mail) {
		// Ajout d'un mail en mémoire
	}
}
