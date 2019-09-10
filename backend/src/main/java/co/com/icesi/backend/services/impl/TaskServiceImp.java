package co.com.icesi.backend.services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.icesi.backend.model.Task;
import co.com.icesi.backend.model.Transition;
import co.com.icesi.backend.repositories.TaskRepository;
import co.com.icesi.backend.services.TaskService;

@Service
public class TaskServiceImp implements TaskService
{

	Logger LOG = LoggerFactory.getLogger(TaskServiceImp.class);

	@Autowired
	private TaskRepository repo;

	@Override
	public List<Task> list()
	{

		return repo.findAll();
	}

	@Override
	public Task findById(int id)
	{
		Task found = repo.findById(id);
		LOG.info("The task " + found.toString() + "was found");
		return found;
	}

	@Override
	public Task add(Task task)
	{
		Task toAdd = repo.save(task);
		LOG.info("Task " + toAdd.toString() + "was aded");
		return toAdd;
	}

	@Override
	public Task edit(Task task)
	{
		return repo.save(task);
	}

	@Override
	public Task delete(int id)
	{
		Task toDelete = findById(id);
		repo.delete(toDelete);
		LOG.warn("Task " + toDelete.toString() + "was deleted");
		return toDelete;
	}

	@Override
	public List<Task> computeEarliestDates(List<Task> tasks, Task start)
	{
		Queue<Task> taskQueue = new LinkedList<Task>();
		start.setEarliestStart(0.0);
		start.setEarliestFinish(start.getDuration());
		List<Transition> lv1Edges = start.getSuccessors();
		queueSuccessors(taskQueue, lv1Edges);

		while (taskQueue.peek() != null)
		{
			Task cursor = taskQueue.poll();
			double maxPredecesorDuration = getMaxPredecesorES(cursor.getPredecessors());
			cursor.setEarliestStart(maxPredecesorDuration);
			cursor.setEarliestFinish(maxPredecesorDuration + cursor.getDuration());
			List<Transition> nextLevel = cursor.getSuccessors();
			queueSuccessors(taskQueue, nextLevel);
		}
		return tasks;
	}

	private double getMaxPredecesorES(List<Transition> predecessors)
	{
		Task maxTask = predecessors.get(0).getId().getPredecesor();
		double max = maxTask.getEarliestStart() + maxTask.getDuration();
		for (int i = 1; i < predecessors.size(); i++)
		{
			Task cursor = predecessors.get(i).getId().getPredecesor();
			double maxCursor = 0.0;
			if (cursor.getEarliestStart() == null)
				maxCursor = getMaxPredecesorES(cursor.getPredecessors())+ cursor.getDuration();
			else
				maxCursor = cursor.getEarliestStart() + cursor.getDuration();
			max = (maxCursor > max) ? maxCursor : max;
		}
		return max;
	}

	/**
	 * Add the list of successors to the task queue
	 * 
	 * @param taskQueue - the queue containing the tasks
	 * @param toBeAdded - the list with the transitions pointing to the successors
	 *                  to be added
	 * @return - the same task queue in case of no successors
	 */
	private Queue<Task> queueSuccessors(Queue<Task> taskQueue, List<Transition> toBeAdded)
	{
		for (Transition edge : toBeAdded)
		{
			taskQueue.add(edge.getId().getSuccessor());
		}

		return taskQueue;
	}
	
	/**
	 * Add the list of predecessors to the task queue
	 * 
	 * @param taskQueue - the queue containing the tasks
	 * @param toBeAdded - the list with the transitions pointing to the successors
	 *                  to be added
	 * @return - the same task queue in case of no successors
	 */
	private Queue<Task> queuePredecessors(Queue<Task> taskQueue, List<Transition> toBeAdded)
	{
		for (Transition edge : toBeAdded)
		{
			taskQueue.add(edge.getId().getPredecesor());
		}

		return taskQueue;
	}

	@Override
	public List<Task> computeLatestDates(List<Task> tasks, Task finish)
	{
		Queue<Task> taskQueue = new LinkedList<Task>();
		finish.setLatestFinish(finish.getEarliestFinish());
		finish.setLatestStart(finish.getLatestFinish()-finish.getDuration());
		
		List<Transition> lv1Edges = finish.getPredecessors();
		queuePredecessors(taskQueue, lv1Edges);

		while (taskQueue.peek() != null)
		{
			Task cursor = taskQueue.poll();
			LOG.debug("visiting " + cursor.getName());
			
			double minSuccessorDuration = getMinSuccessorLS(cursor.getSuccessors());
			cursor.setLatestFinish(minSuccessorDuration);
			cursor.setLatestStart(minSuccessorDuration - cursor.getDuration());
			List<Transition> nextLevel = cursor.getPredecessors();
			queueSuccessors(taskQueue, nextLevel);
		}
		return tasks;
	}

	private double getMinSuccessorLS(List<Transition> sucessors)
	{
		Task minTask = sucessors.get(0).getId().getSuccessor();
		double min = minTask.getLatestFinish() - minTask.getDuration();
		for (int i = 1; i < sucessors.size(); i++)
		{
			Task cursor = sucessors.get(i).getId().getSuccessor();
			double minCursor = 0.0;
			if (cursor.getLatestFinish() == null)
				minCursor = getMinSuccessorLS(cursor.getSuccessors())- cursor.getDuration();
			else
				minCursor = cursor.getLatestFinish() - cursor.getDuration();
			min = (minCursor < min) ? minCursor : min;
		}
		return min;
	}

}
