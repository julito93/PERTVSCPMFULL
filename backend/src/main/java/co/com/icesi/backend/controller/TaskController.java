package co.com.icesi.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.icesi.backend.model.Task;
import co.com.icesi.backend.services.TaskService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(
{ "/tasks" })
@RestController
public class TaskController
{

	public static final String CONTENT_TYPE = HttpHeaders.CONTENT_TYPE + ":" + MediaType.APPLICATION_JSON_VALUE;

	public static final String ACCEPT = HttpHeaders.ACCEPT + ":" + MediaType.APPLICATION_JSON_VALUE;

	@Autowired
	TaskService service;

	@GetMapping
	public List<Task> list()
	{
		return service.list();
	}

	/**
	 * @param task
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Task addTask(@RequestBody Task task)
	{
		return service.add(task);
	}

	@GetMapping(path =
	{ "/{id}" })
	public Task listById(@PathVariable("id") int id)
	{
		return service.findById(id);
	}

	@PutMapping(path =
	{ "/{id}" })
	public Task update(@RequestBody Task task, @PathVariable("id") int id)
	{
		task.setId(id);
		return service.edit(task);
	}
}
