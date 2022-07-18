package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Override
	List<User> findAll();

	//specify a method that returns User by finding it by email id
	@Query(
		value = "SELECT * FROM USER WHERE email_id =: emailId", 
		nativeQuery = true)
	public User findByEmailId(@Param("emailId") String emailId);
	

}
