package co.com.icesi.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.icesi.backend.model.Task;
import co.com.icesi.backend.repositories.TaskRepository;
import co.com.icesi.backend.services.TaskService;

@Service
public class TaskServiceImp implements TaskService {
	
	@Autowired
	private TaskRepository repo;
	
	@Override
	public List<Task> list() {
		return repo.findAll();
	}

	@Override
	public Task findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Task add(Task task) {
		return repo.save(task);
	}

	@Override
	public Task edit(Task task) {
		return repo.save(task);
	}

	@Override
	public Task delete(int id) {
		return null;
	}

}
