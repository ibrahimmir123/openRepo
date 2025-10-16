package com.capgemini.training.manjeet.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.manjeet.dto.ApiResponse;
import com.capgemini.training.manjeet.dto.BookingRequestDTO;
import com.capgemini.training.manjeet.dto.BookingResponseDTO;
import com.capgemini.training.manjeet.mapper.BookingMapper;
import com.capgemini.training.manjeet.model.Booking;
import com.capgemini.training.manjeet.service.BookingService;
import com.capgemini.training.manjeet.util.ResponseBuilder;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

	private static final Logger logger=LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private BookingService bookingService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<BookingResponseDTO>>> getAllBookings() {
		logger.info("Fetching all Booking details..."); 
				return bookingService.getAllBookings()
				        .map(allBookings -> ResponseBuilder.success(
				                BookingMapper.convertToListOfResponseDTO(allBookings),
				                "Booking Details Fetch Successfully !!"))
				        .orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Booking not found"));
}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<BookingResponseDTO>> getBookingById(@PathVariable Long id) {
		logger.info("Fetching Booking details by Id..");
		return bookingService.getBookingById(id)
				.map(booking -> ResponseBuilder.success(BookingMapper.convertToResponseDTO(booking),
						"Booking Details Fetch Successfully !!"))
				.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Booking not found with ID: " + id));

	}

	@PostMapping
	public ResponseEntity<ApiResponse<BookingResponseDTO>> createBooking(@RequestBody BookingRequestDTO booking) {
		logger.info("Creating new Booking...");
		try {
			Booking savedBooking = bookingService.createBooking(BookingMapper.convertToEntity(booking));
			return ResponseBuilder.created(BookingMapper.convertToResponseDTO(savedBooking),
					"Booking Created Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Booking creation fail",e);
			return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, "Getting Error : " + e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<BookingResponseDTO>> updateBooking(@PathVariable Long id,
			@RequestBody BookingRequestDTO booking) {
		logger.info("Updation Booking details..");
		try {
			Booking updateBooking = bookingService.updateBooking(id, booking);
			return ResponseBuilder.success(BookingMapper.convertToResponseDTO(updateBooking),
					"Booking Details updated Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Booking details updation fail..",e);
			return ResponseBuilder.error(HttpStatus.NOT_FOUND, "Getting Error : " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
		return ResponseEntity.noContent().build();
	}
}
