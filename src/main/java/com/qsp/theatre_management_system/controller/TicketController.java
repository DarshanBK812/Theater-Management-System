package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dao.TicketDao;
import com.qsp.theatre_management_system.dto.Ticket;
import com.qsp.theatre_management_system.service.TicketService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}

	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int ticketId) {
		return ticketService.fetchTicketById(ticketId);
	}

	@GetMapping("/fetchAllTicket")
	public ResponseStructureForAll<Ticket> fetchAllTicket() {
		return ticketService.fetchAllTicket();
	}

	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int ticketId) {
		return ticketService.deleteTicketById(ticketId);
	}

	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId, Ticket ticket) {
		return ticketService.updateTicketById(oldTicketId, ticket);
	}
	
	@PutMapping("/addExistsingTicketToExistsingPayment")
	public ResponseStructure<Ticket> addExistsingTicketToExistsingPayment(@RequestParam int payemntId ,@RequestParam int ticketId) {
		return ticketService.addExistsingTicketToExistsingPayment(payemntId, ticketId);
	}

}
