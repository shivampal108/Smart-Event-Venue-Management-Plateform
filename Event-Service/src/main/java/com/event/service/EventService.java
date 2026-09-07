package com.event.service;

import java.util.List;

import com.event.dto.EventRequestDto;
import com.event.dto.EventResponseDto;

public interface EventService {

	

	public EventResponseDto addEvent(EventRequestDto  event);
	
	public EventResponseDto viewEvent(Long id);
	
	
	public List<EventResponseDto> viewAllEvents();
	
	
	public String deleteEvent(Long id);
	
	
	public EventResponseDto updateEvent(EventRequestDto event, long id);
	
	
	public String updateSeats(Integer seats, long id);

	public String addSeats(Integer seats, long id);
	
}
