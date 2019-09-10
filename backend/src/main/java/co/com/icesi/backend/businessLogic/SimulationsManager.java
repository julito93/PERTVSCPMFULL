package co.com.icesi.backend.businessLogic;

import java.util.ArrayList;
import java.util.List;

public class SimulationsManager {

	private TaskBO start;

	/**
	 * The nodes of the precedence diagram
	 */
	private List<TaskBO> nodes;

	/**
	 * the edges of the precedence diagram
	 */
	private List<TransitionBO> edges;

	/**
	 * @return the nodes
	 */
	public List<TaskBO> getNodes() {
		return nodes;
	}

	/**
	 * Generate a new simulation manager
	 * @param nodes The nodes of the precedence network
	 * @param edges the edges of the precedence network
	 */
	
	/**
	 * Generate a new simulation manager<br>
	 * initialize the list of nodes and edges as empty lists
	 */
	public SimulationsManager() {

		this.nodes = new ArrayList<TaskBO>();
		this.edges = new ArrayList<TransitionBO>();
	}

	/**
	 * @param nodes the nodes to set
	 */
	
	public void setNodes(List<TaskBO> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @return the edges
	 */
	public List<TransitionBO> getEdges() {
		return edges;
	}

	/**
	 * @param edges the edges to set
	 */
	public void setEdges(List<TransitionBO> edges) {
		this.edges = edges;
	}

	/**
	 * Computes the <b>earliest start date</b> for every node in precedence network
	 * <br>
	 * The earliest start date is determined by adding the earliest start date of
	 * any preceding tasks to the duration of the current task
	 */
	private void computeEarliestStartDate() {
		
//		Queue<TransitionBO> startingEdges =new LinkedList<TransitionBO>(start.getTransitions());
//		
//		for (TransitionBO edge : startingEdges) {
//			 
//		}
		
	}

	/**
	 * Computes the <b>latest start date</b> for every node in precedence network
	 * <br>
	 * the latest start date is determined by taking any dependent node's latest
	 * start date and subtracting the current task's duration
	 */

	private void computeLatestStartDate() {

	}

	/**
	 * Determine the critical path nodes of the precedence network <br>
	 * A task is on the critical path if it has no <b>float time</b> <br>
	 * the float is determined by subtracting the earliest possible start date of the
	 * predecessor node to the latest possible start date of the successor
	 * 
	 */
	public void criticalPathMethod() {
		computeEarliestStartDate();
		computeLatestStartDate();

	}

	public TaskBO getStart()
	{
		return start;
	}

	public void setStart(TaskBO start)
	{
		this.start = start;
	}

}
