package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.Doctor;
import com.upgrad.bookmyconsultation.enums.Speciality;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String> {

	List<Doctor> findBySpecialityOrderByRatingDesc(Speciality speciality);

	List<Doctor> findAllByOrderByRatingDesc();

	@Query(
		value = "SELECT * FROM DOCTOR WHERE doctor_id =: doctorId", 
		nativeQuery = true)
	public Doctor findDoctorById(@Param("doctorId") String doctorId);
}
