package co.com.icesi.backend.repositories;

import java.util.List;


import co.com.icesi.backend.model.Task;

public interface TaskRepository{

	List<Task> findAll();
	
	Task findById(int id);
	
	Task save(Task task);
	
	void delete(Task task);  
	
}
