package com.capgemini.training.manjeet.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.training.manjeet.model.Route;

/**
 * @Author Manjeet Kumar 25-Jul-2025
 */

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

	List<Route> findBySourceAndDestination(String source, String destination);

	List<Route> findBySourceContainingIgnoreCaseAndDestinationContainingIgnoreCase(String source, String destination,
			Pageable pageable);

	@Query("SELECT r FROM Route r WHERE LOWER(r.source) LIKE LOWER(CONCAT('%', :source, '%')) AND LOWER(r.destination) LIKE LOWER(CONCAT('%', :destination, '%'))")
	List<Route> searchRoutes(@Param("source") String source, @Param("destination") String destination);

}
