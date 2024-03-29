package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;


	//create a method post method named bookAppointment with return type ReponseEntity
		//method has paramter of type Appointment, use RequestBody Annotation for mapping
	
		//save the appointment details to the database and save the response from the method used
		//return http response using ResponseEntity
	@RequestMapping(value="/appointments", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment){
		try{
			String appointmentId = appointmentService.createAppointment(appointment);	
			if(appointmentId==null){
				return new ResponseEntity<String>(HttpStatus.PRECONDITION_FAILED);
			}
		}
        catch(SlotUnavailableException ex){
			System.out.println("Slot is Unavailable.");
		}
		catch(InvalidInputException ex){
			System.out.println("Invalid Input.");
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	
	
	
	//create a get method named getAppointment with return type as ResponseEntity
		//method has appointmentId of type String. Use PathVariable annotation to identity appointment using the parameter defined
		
		//get the appointment details using the appointmentId
		//save the response
		//return the response as an http response
		@RequestMapping(value = {"/appointments/{appointmentId}"}, method = RequestMethod.GET, 
		produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Appointment> getAppointment(@PathVariable(name = "appointmentId") String appointmentId){
			Appointment appointment = appointmentService.getAppointment(appointmentId);
			return ResponseEntity.ok(appointment);
		}

}