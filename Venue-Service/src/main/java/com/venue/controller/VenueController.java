package com.venue.controller;

import java.time.LocalDateTime;
import java.util.List;

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

import com.venue.dto.VenueRequestDto;
import com.venue.dto.VenueResponseDto;
import com.venue.response.ApiResponse;
import com.venue.response.SuccessResponse;
import com.venue.service.VenueService;

@RestController
@RequestMapping("/venue")
public class VenueController {
	
	@Autowired
	private VenueService vService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addVenue( @RequestBody VenueRequestDto request){
		
		ApiResponse response= new SuccessResponse<VenueResponseDto>(vService.addVenue(request), HttpStatus.CREATED.value(), "Venue Created", LocalDateTime.now(), true);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
		
		
		
	}
	
	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> viewVenue( @PathVariable Long id){
		
		ApiResponse response= new SuccessResponse<VenueResponseDto>(vService.viewVenue(id), HttpStatus.OK.value(), "Venue featched Successfully", LocalDateTime.now(), true);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
		
		
	}
	
	
	
	@GetMapping("/view-all")
	public ResponseEntity<?> viewAllVenue( ){
		
		ApiResponse response= new SuccessResponse<List<VenueResponseDto>>(vService.viewAllVenues(), HttpStatus.OK.value(), "All-Venue featched Successfully", LocalDateTime.now(), true);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
		
		
	}
	
	
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVenue(@PathVariable Long id ){
		
		ApiResponse response= new SuccessResponse<String>(vService.deleteVenue(id), HttpStatus.OK.value(), "venue deleted Successfully", LocalDateTime.now(), true);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
		
		
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateVenue(@RequestBody VenueRequestDto request, @PathVariable Long id ){
		
		ApiResponse response= new SuccessResponse<VenueResponseDto>(vService.updateVenue(request, id), HttpStatus.OK.value(), "Venue updated Successfully", LocalDateTime.now(), true);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
		
		
	}
	
	
	
	

}
