package com.capgemini.training.manjeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.manjeet.model.Driver;

/**
 * @Author Manjeet Kumar
 *  25-Jul-2025
 */

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

}

