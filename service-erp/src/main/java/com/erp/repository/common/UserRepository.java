package com.erp.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

public User findOneByEmail(String email);
	
	@Query("select ur from User ur where ur.email =:email and ur.password =:password and ur.isActive = true")
	public User getUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}
