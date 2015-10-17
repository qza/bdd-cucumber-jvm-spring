package bdd.example.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import bdd.example.model.Ticket;

@Service
public class PaymentService {

	public void createTransaction(Ticket ticket) {
		ticket.setPaymentTransaction(UUID.randomUUID().toString());
	}

}
