package com.project.ems.controllers;

import com.project.ems.dao.IEventRepository;
import com.project.ems.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventsController {
	

	private IEventRepository projectRepository;

	@Autowired
	public EventsController(IEventRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@GetMapping("/")
	public String getEvents(Model model) {
		model.addAttribute("events", projectRepository.findAll());
		model.addAttribute("eventsTop3",projectRepository.findTop3By());
		return "index";
	}

	@GetMapping("/search")
	public String filterEvents(Model model, @RequestParam String query) {

		model.addAttribute("events", projectRepository.findByNameOrPlaceOrTypeOrDescriptionContains(query, query, query, query));
		model.addAttribute("eventsTop3",projectRepository.findTop3By());
		return "index";
	}

//	@GetMapping("/")
//	public String getFilter(Event event, Model model, @RequestParam String query) {
//		model.addAttribute("events", projectRepository.findByNameOrPlaceOrTypeOrDescriptionContains(query, query, query, query));
//		model.addAttribute("eventsTop3",projectRepository.findTop3By());
//		return "index";
//	}

	@RequestMapping("/events")
	public String getAuthors(Model model, @RequestParam String query){
		model.addAttribute("events", projectRepository.findAll());

		return "events/list";
	}

	@GetMapping ("event/{id}")
	public String getEvent(Model model, @PathVariable Long id){
		model.addAttribute("event", projectRepository.findById(id));
		return "event";
	}

	//This method should handle the saving to the database

	@GetMapping("/create")
	public String create(Event event) {
		return "create";
	}

	@PostMapping("/createevent")
	public String createEvent(Event event, BindingResult result, Model model) {
		projectRepository.save(event);
		model.addAttribute("events", projectRepository.findAll());
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/";
	}

	@PostMapping("/update/{id}")
	public String updateEvent() {
		return "index";
	}

}