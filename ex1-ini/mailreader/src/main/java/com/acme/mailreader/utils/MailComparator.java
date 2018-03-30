package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {
	
	public final int MAIL1_INFERIEUR = -1;
	public final int EGAUX 	   = 0;
	public final int MAIL1_SUPERIEUR = 1;

	public int compare(Mail mail1, Mail mail2) {
		if (unDesMailsEstNull(mail1, mail2)) {
			return EGAUX;
		}
		if (leMail1EstPlusImportantQueLeMail2(mail1, mail2)) {
			return MAIL1_INFERIEUR;
		} else if(leMail2EstPlusImportantQueLeMail2(mail1, mail2)) {
			return MAIL1_SUPERIEUR;
		}
		if (statutsDifferent(mail1, mail2)) {
			return statutDuPremierMailSuperieur(mail1, mail2) ? MAIL1_INFERIEUR : MAIL1_SUPERIEUR;
		}
		if (sujetsDifferents(mail1, mail2)) {
			return mail2.getSujet().compareTo(mail1.getSujet());
		}
		return mail2.getDate().compareTo(mail1.getDate());
	}

	private boolean sujetsDifferents(Mail mail1, Mail mail2) {
		return mail1.getSujet() != mail2.getSujet();
	}

	private boolean statutsDifferent(Mail mail1, Mail mail2) {
		return mail1.getStatut() != mail2.getStatut();
	}

	private boolean statutDuPremierMailSuperieur(Mail mail1, Mail mail2) {
		return mail1.getStatut().ordinal() - mail2.getStatut().ordinal() > 0;
	}
	
	private boolean unDesMailsEstNull(Mail mail1, Mail mail2) {
		return mail1 == null || mail2 == null;
	}
	
	private boolean leMail1EstPlusImportantQueLeMail2(Mail mail1, Mail mail2) {
		return mail1.isImportant() && !mail2.isImportant();
	}
	
	private boolean leMail2EstPlusImportantQueLeMail2(Mail mail1, Mail mail2) {
		return !mail1.isImportant() && mail2.isImportant();
	}
}
