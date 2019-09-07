package co.com.icesi.backend.repositories;

import java.util.List;


import co.com.icesi.backend.model.Task;

public interface TaskRepository /*extends Repository<Task, Integer>*/{

	List<Task> findAll();
	
	Task findById(int id);
	
	Task save(Task task);
	
	void delete(Task task);  
	
}
