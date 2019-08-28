package co.com.icesi.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.icesi.backend.model.Task;


public interface TaskService {

	List<Task> list();
	
	Task findById(int id);
	
	Task add(Task task);
	
	Task edit(Task task);
	
	Task delete(int id);
}
