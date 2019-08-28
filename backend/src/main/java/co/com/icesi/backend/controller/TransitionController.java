package co.com.icesi.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.icesi.backend.businessLogic.TaskBO;
import co.com.icesi.backend.businessLogic.TransitionBO;
import co.com.icesi.backend.model.Task;
import co.com.icesi.backend.model.Transition;
import co.com.icesi.backend.services.TransitionService;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RequestMapping({"/transitions"})
@RestController
public class TransitionController {

	@Autowired
	TransitionService service;
	
	@GetMapping
	public List<Transition> list(){
		return service.list();
	}
	
	@PostMapping
	public Transition add(@RequestBody Transition transition)
	{
		return service.add(transition);
	}
	
	/**
	 * return an array of DTO(data transfer object) version of the existing transitions 
	 * 
	 * @return empty list if there is no tasks in the database.
	 */
	public List<TransitionBO> getTasksBO() {
		List<TransitionBO> transitionsBO = new ArrayList<TransitionBO>();
		List<Transition> transitions = list();
		if (!transitions.isEmpty()) {

			for (Transition transition : transitions) {
				transitionsBO.add(transition.toBO());

			}
		}
		return transitionsBO;
	}
}
