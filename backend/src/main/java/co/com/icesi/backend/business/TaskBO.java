package co.com.icesi.backend.business;

import java.util.ArrayList;
import java.util.List;

public class TaskBO {

	private int id;

	private String name;

	private double duration;

	private double earliestStart;

	private double earliestFinish;

	private double latestStart;

	private double latestFinish;

	private double slack;
	
	private List<TransitionBO> transitions;

	public TaskBO(int id, String name, double duration) {

		this.id = id;
		this.name = name;
		this.duration = duration;
		transitions = new ArrayList<TransitionBO>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the earliestStart
	 */
	public double getEarliestStart() {
		return earliestStart;
	}

	/**
	 * @param earliestStart the earliestStart to set
	 */
	public void setEarliestStart(double earliestStart) {
		this.earliestStart = earliestStart;
	}

	/**
	 * @return the earliestFinish
	 */
	public double getEarliestFinish() {
		return earliestFinish;
	}

	/**
	 * @param earliestFinish the earliestFinish to set
	 */
	public void setEarliestFinish(double earliestFinish) {
		this.earliestFinish = earliestFinish;
	}

	/**
	 * @return the latestStart
	 */
	public double getLatestStart() {
		return latestStart;
	}

	/**
	 * @param latestStart the latestStart to set
	 */
	public void setLatestStart(double latestStart) {
		this.latestStart = latestStart;
	}

	/**
	 * @return the latestFinish
	 */
	public double getLatestFinish() {
		return latestFinish;
	}

	/**
	 * @param latestFinish the latestFinish to set
	 */
	public void setLatestFinish(double latestFinish) {
		this.latestFinish = latestFinish;
	}

	/**
	 * @return the slack
	 */
	public double getSlack() {
		return slack;
	}

	/**
	 * @param slack the slack to set
	 */
	public void setSlack(double slack) {
		this.slack = slack;
	}

	public List<TransitionBO> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<TransitionBO> transitions) {
		this.transitions = transitions;
	}

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + "]";
	}
}
