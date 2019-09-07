package co.com.icesi.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.icesi.backend.model.Task;
import co.com.icesi.backend.services.TaskService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(
{ "/tasks" })
@RestController
public class TaskController
{

	@Autowired
	TaskService service;

	@GetMapping
	public List<Task> list()
	{

		return service.list();
	}

	@PostMapping
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

//	/**
//	 * return an array of DTO(data transfer object) version of the existing tasks
//	 * 
//	 * @return empty list if there is no tasks in the database.
//	 */
//	public List<TaskBO> getTasksBO() {
//		List<TaskBO> tasksBO = new ArrayList<TaskBO>();
//		List<Task> tasks = list();
//		if (!tasks.isEmpty()) {
//
//			for (Task task : tasks) {
//				tasksBO.add(task.toBO());
//
//			}
//		}
//		return tasksBO;
//	}

}
