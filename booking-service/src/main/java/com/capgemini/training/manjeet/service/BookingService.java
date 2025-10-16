package com.capgemini.training.manjeet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.manjeet.dto.BookingRequestDTO;
import com.capgemini.training.manjeet.mapper.BookingMapper;
import com.capgemini.training.manjeet.model.Booking;
import com.capgemini.training.manjeet.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public Optional<List<Booking>> getAllBookings() {
		// return bookingRepository.findAll();

		//List<Booking> bookings = bookingRepository.findAll();
		//return bookings.isEmpty() ? Optional.empty() : Optional.of(bookings);
		
		return Optional.ofNullable(bookingRepository.findAll()).filter(list -> !list.isEmpty());

	}

	public Optional<Booking> getBookingById(Long id) {
		return bookingRepository.findById(id);
	}

	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Booking updateBooking(Long id, BookingRequestDTO updatedBooking) {
		return bookingRepository.findById(id).map(existing -> {
			BookingMapper.convertToEntity(updatedBooking).setBookingId(id);
			
			return bookingRepository.save(BookingMapper.convertToEntity(updatedBooking));
		}).orElseThrow(() -> new RuntimeException("Booking not found !!"));
	}

	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
}
