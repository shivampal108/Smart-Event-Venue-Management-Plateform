package com.venue.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.venue.customexception.VenueNotFoundException;
import com.venue.dto.VenueRequestDto;
import com.venue.dto.VenueResponseDto;
import com.venue.entity.Venue;
import com.venue.repository.VenueRepository;


@Service
public class VenueServiceImp implements VenueService {
	
	
	@Autowired
	private VenueRepository vRepo;

	@Override
	public VenueResponseDto addVenue(VenueRequestDto venue) {
		
		
		Venue venue1=Venue.builder().build();
		
		BeanUtils.copyProperties(venue, venue1);
	    venue1=	vRepo.save(venue1) ;
		
		VenueResponseDto v1=VenueResponseDto.builder().build();
		BeanUtils.copyProperties(venue1, v1);
		
		return  v1;
	}

	@Override
	public VenueResponseDto viewVenue(Long id) {
		
		Venue v1= vRepo.findById(id).orElseThrow(()->new VenueNotFoundException("Venue not exhist"));
		
		
		VenueResponseDto v2= VenueResponseDto.builder().build();
		
		
		BeanUtils.copyProperties(v1, v2);
		
		return v2;
	}

	@Override
	public List<VenueResponseDto> viewAllVenues() {
		
		
		
		
	List<Venue> venues=vRepo.findAll();
		
		List<VenueResponseDto> dtos=new ArrayList<VenueResponseDto>();
		
		for(Venue v :venues) {
			
			VenueResponseDto v1=VenueResponseDto.builder().build();
			BeanUtils.copyProperties(v,v1);
			dtos.add(v1);
		}
		
		
		return dtos;
		
		
		
	}

	@Override
	public String deleteVenue(Long id) {
		
		
		vRepo.findById(id).orElseThrow(()->new VenueNotFoundException("Venut not exhist"));

		
		vRepo.deleteById(id);
		
		return "Venue deleted having id: "+ id;
	}

	@Override
	public VenueResponseDto updateVenue(VenueRequestDto venue, long id) {
		
		
	Venue v1= 	vRepo.findById(id).orElseThrow(()->new VenueNotFoundException("venue not present for updating"));
		
		BeanUtils.copyProperties(venue, v1);
		v1.setVenueId(id);
		
	vRepo.save(v1);
		
		VenueResponseDto responseDto= VenueResponseDto.builder().build();
		
		BeanUtils.copyProperties( v1,responseDto);

		
		
		return  responseDto;
	}

}
