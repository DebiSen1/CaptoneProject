package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Doctor;
import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.repository.DoctorRepository;
import com.upgrad.bookmyconsultation.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
public class RatingsService {

	@Autowired
	private RatingsRepository ratingsRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	
	//create a method name submitRatings with void return type and parameter of type Rating
		//set a UUID for the rating
		//save the rating to the database
		//get the doctor id from the rating object
		//find that specific doctor with the using doctor id
		//modify the average rating for that specific doctor by including the new rating
		//save the doctor object to the database
	
		public void submitRatings(Rating rating){
			String id = UUID.randomUUID().toString();
			rating.setId(id);
			ratingsRepository.save(rating);
			String doctorId = rating.getDoctorId();
			Doctor doctor = doctorRepository.findDoctorById(doctorId);
			doctor.setRating(rating.getRating());
			doctorRepository.save(doctor);
		}

	}
