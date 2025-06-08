package com.qsp.theatre_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.theatre_management_system.service.BrachNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;


@RestControllerAdvice
public class ApplicationExceptionHandler {

	
	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {		
		responseStructure.setMessage("Owner Not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ownerIdNotFound.getMessage());
		return   new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdressNotFound.class)
	public ResponseEntity<ResponseStructure<String>> adressNotFound(AdressNotFound adressNotFound){
		responseStructure.setMessage("Adress not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(adressNotFound.getMsg());
		return  new ResponseEntity<ResponseStructure<String>>(responseStructure ,  HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TheaterNotFound.class)
	public ResponseEntity<ResponseStructure<String>> theaterNotFound(TheaterNotFound theaterNotFound){
		responseStructure.setMessage("Thater not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(theaterNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BrachNotFound.class)
	public ResponseEntity<ResponseStructure<String>> brachNotFound(BrachNotFound brachNotFound){
		responseStructure.setMessage("Thater not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(brachNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<ResponseStructure<String>> employeeNotFound(EmployeeNotFound employeeNotFound){
		responseStructure.setMessage("Employee not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(employeeNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SeatNotFound.class)
	public ResponseEntity<ResponseStructure<String>> seatNotFound(SeatNotFound seatNotFound){
		responseStructure.setMessage("Seat not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(seatNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ViewerNotFound.class)
	public ResponseEntity<ResponseStructure<String>> viewerNotFound(ViewerNotFound viewerNotFound){
		responseStructure.setMessage("viewer not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(viewerNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ManagerNotFound.class)
	public ResponseEntity<ResponseStructure<String>> managerNotFound(ManagerNotFound managerNotFound){
		responseStructure.setMessage("manager not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(managerNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MovieNotFound.class)
	public ResponseEntity<ResponseStructure<String>> movieNotFound(MovieNotFound movieNotFound){
		responseStructure.setMessage("Movie is not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(movieNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TicketNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ticketNotFound(TicketNotFound ticketNotFound){
		responseStructure.setMessage("Ticket not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ticketNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND );
	}
	
	@ExceptionHandler(PaymentNotFound.class)
	public ResponseEntity<ResponseStructure<String>> paymentNotFound(PaymentNotFound paymentNotFound){
		responseStructure.setMessage("Payment not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(paymentNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND );
	}
	
	@ExceptionHandler(FoodNotFound.class)
	public ResponseEntity<ResponseStructure<String>> foodNotFound(FoodNotFound foodNotFound){
		responseStructure.setMessage("Food not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(foodNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ScreenNotFound.class)
	public ResponseEntity<ResponseStructure<String>> screenNotFound(ScreenNotFound screenNotFound){
		responseStructure.setMessage("Screen not found in the DB");
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(screenNotFound.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.NOT_FOUND);
	}
	

}
