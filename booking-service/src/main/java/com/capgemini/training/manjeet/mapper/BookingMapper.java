package com.capgemini.training.manjeet.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.training.manjeet.dto.BookingRequestDTO;
import com.capgemini.training.manjeet.dto.BookingResponseDTO;
import com.capgemini.training.manjeet.model.Booking;

/**
 * @Author Manjeet Kumar 28-Jul-2025
 */
public class BookingMapper {

	public static List<BookingResponseDTO> convertToListOfResponseDTO(List<Booking> bookings) {

		return bookings.stream()
				.map(booking -> new BookingResponseDTO(booking.getBookingId(), booking.getVehicleId(),
						booking.getCustomerId(), booking.getRouteId(), booking.getBookingDate(),
						booking.getJourneyDate(), booking.getBoardingPoint(), booking.getDropPoint(), booking.getFare(),
						booking.getStatus()))
				.collect(Collectors.toList());

	}

	public static BookingResponseDTO convertToResponseDTO(Booking booking) {
		BookingResponseDTO dto = new BookingResponseDTO();
		dto.setBookingId(booking.getBookingId());
		dto.setVehicleId(booking.getVehicleId());
		dto.setCustomerId(booking.getCustomerId());
		dto.setRouteId(booking.getRouteId());
		dto.setBookingDate(booking.getBookingDate());
		dto.setJourneyDate(booking.getJourneyDate());
		dto.setBoardingPoint(booking.getBoardingPoint());
		dto.setDropPoint(booking.getDropPoint());
		dto.setFare(booking.getFare());
		dto.setStatus(booking.getStatus());
		return dto;
	}

	public static Booking convertToEntity(BookingRequestDTO dto) {
		System.out.println("convertToEntity:: " + dto);
		Booking booking = new Booking();
		booking.setVehicleId(dto.getVehicleId());
		booking.setCustomerId(dto.getCustomerId());
		booking.setRouteId(dto.getRouteId());
		booking.setBookingDate(dto.getBookingDate());
		booking.setJourneyDate(dto.getJourneyDate());
		booking.setBoardingPoint(dto.getBoardingPoint());
		booking.setDropPoint(dto.getDropPoint());
		booking.setFare(dto.getFare());
		booking.setStatus(dto.getStatus());
		System.out.println("booking:: " + booking);
		return booking;
	}

}
