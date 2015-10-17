package bdd.example.service;

import org.springframework.stereotype.Service;

import bdd.example.model.Ticket;

@Service
public class CustomerService {

	public void notify(Ticket ticket, String message) {
		ticket.addMessage(message);
	}

}
