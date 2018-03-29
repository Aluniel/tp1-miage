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
	
	public final int INFERIEUR = -1;
	public final int EGAUX 	   = 0;
	public final int SUPERIEUR = 1;

	public int compare(Mail obj1, Mail obj2) {
		if (unDesMailsEstNull(obj1, obj2)) {
			return EGAUX;
		}
		if (leMail1EstPlusImportantQueLeMail2(obj1, obj2)) {
			return INFERIEUR;
		} else if(leMail2EstPlusImportantQueLeMail2(obj1, obj2)) {
			return SUPERIEUR;
		}
		if (statutsDifferent(obj1, obj2)) {
			return statutDuPremierMailSuperieur(obj1, obj2) ? INFERIEUR : SUPERIEUR;
		}
		if (sujetsDifferents(obj1, obj2)) {
			return obj2.getSujet().compareTo(obj1.getSujet());
		}
		return obj2.getDate().compareTo(obj1.getDate());
	}

	private boolean sujetsDifferents(Mail obj1, Mail obj2) {
		return obj1.getSujet() != obj2.getSujet();
	}

	private boolean statutsDifferent(Mail obj1, Mail obj2) {
		return obj1.getStatut() != obj2.getStatut();
	}

	private boolean statutDuPremierMailSuperieur(Mail obj1, Mail obj2) {
		return obj1.getStatut().ordinal() - obj2.getStatut().ordinal() > 0;
	}
	
	private boolean unDesMailsEstNull(Mail obj1, Mail obj2) {
		return obj1 == null || obj2 == null;
	}
	
	private boolean leMail1EstPlusImportantQueLeMail2(Mail obj1, Mail obj2) {
		return obj1.isImportant() && !obj2.isImportant();
	}
	
	private boolean leMail2EstPlusImportantQueLeMail2(Mail obj1, Mail obj2) {
		return !obj1.isImportant() && obj2.isImportant();
	}
}
