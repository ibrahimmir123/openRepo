package com.capgemini.training.manjeet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.manjeet.model.User;

/**
 * @Author Manjeet Kumar 30-Jul-2025
 */

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findPasswordByEmail(String useremail);

}
