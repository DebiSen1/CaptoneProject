package com.upgrad.bookmyconsultation.repository;


import com.upgrad.bookmyconsultation.entity.Appointment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String> {

	public List<Appointment> findByUserId(String userId);

	@Query(
		value = "SELECT * FROM APPOINTMENT WHERE doctor_id =: doctorId and time_slot=:timeSlot and appointment_date=:appointmentDate", 
		nativeQuery = true)
	public Appointment findByDoctorIdAndTimeSlotAndAppointmentDate(@Param("doctorId") String doctorId, 
	@Param("timeSlot") String timeSlot, @Param("appointmentDate") String appointmentDate);

	@Query(
		value = "SELECT * FROM APPOINTMENT WHERE appointment_id =: appointmentId", 
		nativeQuery = true)
    public Appointment getAppointmentDetails(@Param("appointmentId") String appointmentId);

}
