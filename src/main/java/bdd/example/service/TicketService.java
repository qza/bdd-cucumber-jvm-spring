package bdd.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bdd.example.model.Customer;
import bdd.example.model.Flight;
import bdd.example.model.Ticket;

@Service
public class TicketService {

	@Autowired
	CustomerService customerService;

	@Autowired
	DiscountStrategy discountStrategy;

	@Autowired
	PaymentService paymentService;

	public Ticket purchase(Flight flight, Customer customer) {

		Ticket ticket = new Ticket(flight, customer);

		discountStrategy.execute(ticket);

		paymentService.createTransaction(ticket);

		customerService.notify(ticket, "purchase");

		return ticket;
	}

}
