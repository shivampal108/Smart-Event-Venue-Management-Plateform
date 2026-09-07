package com.event.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.event.customexception.EventNotFoundException;
import com.event.dto.EventRequestDto;
import com.event.dto.EventResponseDto;
import com.event.entity.Event;
import com.event.feignconfig.VenueFeign;
import com.event.repository.EventRepository;




@Service
public class EventServiceImp implements EventService {

	
	@Autowired
	private VenueFeign venueFeign;
	
	@Autowired
	private EventRepository eRepo;
	
	
	@Override
	public EventResponseDto addEvent(EventRequestDto event) {
		
		
	   venueFeign.viewVenue(event.getVenueId());
	   
	   Event e1=new Event();
	   BeanUtils.copyProperties(event, e1);
	   
	   
	e1=   eRepo.save(e1);
	   
	   EventResponseDto response= EventResponseDto.builder().build();
	   
	   BeanUtils.copyProperties(e1, response);
	   
	   
	   
	   return response;
	   
		
		
	}

	@Override
	public EventResponseDto viewEvent(Long id) {
		Event e1= eRepo.findById(id).orElseThrow(()->new EventNotFoundException("Event not exhist"));
		
		
		EventResponseDto e2= EventResponseDto.builder().build();
		
		
		BeanUtils.copyProperties(e1, e2);
		
		return e2;
	}

	@Override
	public List<EventResponseDto> viewAllEvents() {
		
		
		
		List<Event> events=eRepo.findAll();
			
			List<EventResponseDto> dtos=new ArrayList<EventResponseDto>();
			
			for(Event e :events) {
				
				EventResponseDto e1=EventResponseDto.builder().build();
				BeanUtils.copyProperties(e,e1);
				dtos.add(e1);
			}
			
			
			return dtos;
			
	}

	@Override
	public String deleteEvent(Long id) {

		eRepo.findById(id).orElseThrow(()->new EventNotFoundException("Venut not exhist"));

		
		eRepo.deleteById(id);
		
		return "Event deleted having id: "+ id;
	}

	@Override
	public EventResponseDto updateEvent(EventRequestDto event, long id) {
		
		Event e1= 	eRepo.findById(id).orElseThrow(()->new EventNotFoundException("Event not present for updating"));
			
			BeanUtils.copyProperties(event, e1);
			e1.setVenueId(id);
			
		eRepo.save(e1);
			
			EventResponseDto responseDto= EventResponseDto.builder().build();
			
			BeanUtils.copyProperties( e1,responseDto);

			
			
			return  responseDto;
	}

	@Override
	public String updateSeats(Integer seats, long id) {
		
		Event e1= 	eRepo.findById(id).orElseThrow(()->new EventNotFoundException("Event not present for updating"));
		
		
		
		Integer seat=(e1.getAvailableSeats()-seats);
		

		e1.setAvailableSeats(seat);
		
		
		eRepo.save(e1);
	
	
		return "Seat updated for event having id: "+id;
	}

	@Override
	public String addSeats(Integer seats, long id) {
		
		
		
	Event e1= 	eRepo.findById(id).orElseThrow(()->new EventNotFoundException("Event not present for updating"));
		
		
		
		Integer seat=(e1.getAvailableSeats()+seats);
		

		e1.setAvailableSeats(seat);
		
		
		eRepo.save(e1);
	
	
		return "Seat updated for event having id: "+id;
		
		
	}

	

}
