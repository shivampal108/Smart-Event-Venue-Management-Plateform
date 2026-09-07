package com.event.controller;


import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.dto.EventRequestDto;
import com.event.dto.EventResponseDto;
import com.event.response.ApiResponse;
import com.event.response.SuccessResponse;
import com.event.service.EventService;


@RestController
@RequestMapping("/event")
public class EventController {

	
	@Autowired
	private EventService eService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEvent(@RequestBody EventRequestDto request) {
		
		
		ApiResponse success= new SuccessResponse<EventResponseDto>(eService.addEvent(request), HttpStatus.CREATED.value(), "Event Created Successfully", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(success);
		
		
		
	}
	
	
	
	@GetMapping("/view-all")
	public ResponseEntity<?> viewEvent() {
		
		
		ApiResponse success= new SuccessResponse<List<EventResponseDto>>(eService.viewAllEvents(), HttpStatus.CREATED.value(), "Event fetched Successfully", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.OK).body(success);
		
		
		
	}
	
	
	
	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> viewEvent( @PathVariable Long id){
		
		ApiResponse response= new SuccessResponse<EventResponseDto>(eService.viewEvent(id), HttpStatus.OK.value(), "Event featched Successfully", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
		
		
	}
	
	
	

	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable Long id ){
		
		ApiResponse response= new SuccessResponse<String>(eService.deleteEvent(id), HttpStatus.OK.value(), "Event deleted Successfully", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
		
		
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEvent(@RequestBody EventRequestDto request, @PathVariable Long id ){
		
		ApiResponse response= new SuccessResponse<EventResponseDto>(eService.updateEvent(request, id), HttpStatus.OK.value(), "Event updated Successfully", LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
		
		
	}
	
	
	
	@PatchMapping("/update-seat/{no}/{id}")
	
	public ResponseEntity<?> updateSeat(@PathVariable Integer no, @PathVariable Long id){
		
		ApiResponse response= new SuccessResponse<String>(eService.updateSeats(no,id), HttpStatus.OK.value(), "Event updated Successfully", LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
	}
	
	
	
@PatchMapping("/add-seat/{no}/{id}")
	
	public ResponseEntity<?> addSeat(@PathVariable Integer no, @PathVariable Long id){
		
		ApiResponse response= new SuccessResponse<String>(eService.addSeats(no,id), HttpStatus.OK.value(), "Event updated Successfully", LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
	}
	
	
	
	
}
