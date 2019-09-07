package co.com.icesi.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.icesi.backend.model.Transition;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({ "/transitions" })
@RestController
public class TransitionController {

	@GetMapping
	public List<Transition> list() {
		return null;
	}

	@PostMapping
	public Transition add(@RequestBody Transition transition) {
		return null;
	}

//	/**
//	 * return an array of DTO(data transfer object) version of the existing
//	 * transitions
//	 * 
//	 * @return empty list if there is no tasks in the database.
//	 */
//	public List<TransitionBO> getTasksBO() {
//		List<TransitionBO> transitionsBO = new ArrayList<TransitionBO>();
//
//		return transitionsBO;
//	}
}
