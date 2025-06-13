package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Payment;
import com.qsp.theatre_management_system.dto.Screen;
import com.qsp.theatre_management_system.dto.Ticket;
import com.qsp.theatre_management_system.repo.PaymentRepo;
import com.qsp.theatre_management_system.repo.ScreenRepo;
import com.qsp.theatre_management_system.repo.TicketRepo;

import jakarta.persistence.Entity;

@Repository
public class TicketDao {
	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	PaymentRepo paymentRepo;

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public Ticket fetchTicketById(int ticketId) {
		Optional<Ticket> ticket = ticketRepo.findById(ticketId);

		if (ticket.isEmpty()) {
			return null;
		} else
			return ticket.get();
	}

	public List<Ticket> fetchAllTicket() {
		return ticketRepo.findAll();
	}

	public Ticket deleteTicketById(int ticketId) {
		Ticket ticket = ticketRepo.findById(ticketId).get();
		ticketRepo.delete(ticket);
		return ticket;
	}

	public Ticket updateTicketById(int oldTicketId, Ticket ticket) {
		ticket.setTicketId(oldTicketId);
		ticketRepo.save(ticket);
		
		return ticket;
	}

	public Ticket addExistsingTicketToExistsingPayment(int payemntId, int titleId) {
		Ticket ticket = fetchTicketById(titleId);
		Payment payment = paymentRepo.findById(titleId).get();
		ticket.setPayment(payment);
		return saveTicket(ticket);

	}

}
