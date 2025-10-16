package com.capgemini.training.manjeet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.manjeet.model.Customer;

/**
 * @Author Manjeet Kumar
 *  25-Jul-2025
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{


    Optional<Customer> findCustomerByEmail(String email);

}

