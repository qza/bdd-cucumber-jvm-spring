package bdd.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private Customer customer;

	private Flight flight;

	private Policy policy;

	private BigDecimal price = BigDecimal.ZERO, discount = BigDecimal.ZERO;
	
	private List<String> messages = new ArrayList<>();
	
	private String paymentTransactionId;

	public Ticket(Flight flight, Customer customer) {
		this.flight = flight;
		this.customer = customer;
		this.policy = new Policy();
	}

	public Flight getFlight() {
		return flight;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Policy getPolicy() {
		return policy;
	}

	public BigDecimal getPrice() {
		return price.subtract(price.multiply(discount));
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public void addMessage(String message) { 
		messages.add(message);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public boolean isPaymentCompleted() {
		return paymentTransactionId != null;
	}

	public void setPaymentTransaction(String paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}

}
