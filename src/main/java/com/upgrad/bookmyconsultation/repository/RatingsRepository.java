package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingsRepository extends CrudRepository<Rating,String>{

	@Query(
		value = "SELECT * FROM RATING WHERE doctor_id =: doctorId", 
		nativeQuery = true)
	public List<Rating> findByDoctorId(@Param("doctorId") String doctorId);
}

//mark it as repository
//create an interface RatingsRepository that extends CrudRepository
	//create a method findByDoctorId that returns a list of type Rating
	//define method parameter doctorId of type String