package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.TicketDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Ticket;
import com.qsp.theatre_management_system.exception.TicketNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;
import com.qsp.theatre_management_system.dto.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

	@Autowired
	ResponseStructure<Ticket> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Ticket> responseStructureForAll;

	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setMessage("Ticket saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;
	}

	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if(ticket != null) {
			responseStructure.setMessage("Ticket fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(ticketDao.fetchTicketById(ticketId));
			return responseStructure;
		} else {
			throw new TicketNotFound();
		}
	}

	public ResponseStructureForAll<Ticket> fetchAllTicket() {
		responseStructureForAll.setMessage("All Ticket fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(ticketDao.fetchAllTicket());
		return responseStructureForAll;
	}

	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		responseStructure.setMessage(" Ticket deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return responseStructure;
	}

	public ResponseStructure<Ticket> updateTicketById(int oldTicketId, Ticket ticket) {
		responseStructure.setMessage("Ticket updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, ticket));
		return responseStructure;
	}
	
	public ResponseStructure<Ticket> addExistsingTicketToExistsingPayment(int payemntId, int titleId) {
		responseStructure.setMessage("Payment saved succesfully to Ticket in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(ticketDao.addExistsingTicketToExistsingPayment(payemntId, titleId));
		return responseStructure;
	}


}
