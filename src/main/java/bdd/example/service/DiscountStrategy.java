package bdd.example.service;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import bdd.example.model.Ticket;

@Component
public class DiscountStrategy {

	public void execute(Ticket ticket) {

		Calendar now = Calendar.getInstance();
		Calendar discountExpiresAt = Calendar.getInstance();
		
		discountExpiresAt.setTime(ticket.getFlight().getDatetime().getTime());
		discountExpiresAt.add(Calendar.HOUR, 0 - ticket.getPolicy().getDiscountPeriodHours());

		if (now.before(discountExpiresAt)) {
			ticket.setDiscount(BigDecimal.valueOf(0.15));
		}
	}

}
