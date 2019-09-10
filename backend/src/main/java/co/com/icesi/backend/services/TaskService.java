package co.com.icesi.backend.services;

import java.util.List;

import co.com.icesi.backend.model.Task;


public interface TaskService {

	List<Task> list();
	
	Task findById(int id);
	
	Task add(Task task);
	
	Task edit(Task task);
	
	Task delete(int id);

	List<Task> computeEarliestDates(List<Task> tasks, Task start);
	
	List<Task> computeLatestDates(List<Task> tasks, Task finish);
}
