package co.com.icesi.backend.model;

import java.util.List;

/**
 * @author jcampaz
 *
 */
/**
 * @author jcampaz
 *
 */

public class Task
{

	private int id;

	private String name;

	private Double duration;

	private Double earliestStart;

	private Double earliestFinish;

	private Double latestStart;

	private Double latestFinish;

	private Double slack;

	private List<Transition> transitions;

	public Task()
	{
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param name
	 * @param duration
	 */
	public Task(int id, String name, Double duration)
	{
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;

	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getDuration()
	{
		return duration;
	}

	public void setDuration(Double duration)
	{
		this.duration = duration;
	}

	/**
	 * @return the earliestStart
	 */
	public Double getEarliestStart()
	{
		return earliestStart;
	}

	/**
	 * @param earliestStart the earliestStart to set
	 */
	public void setEarliestStart(Double earliestStart)
	{
		this.earliestStart = earliestStart;
	}

	/**
	 * @return the earliestFinish
	 */
	public Double getEarliestFinish()
	{
		return earliestFinish;
	}

	/**
	 * @param earliestFinish the earliestFinish to set
	 */
	public void setEarliestFinish(Double earliestFinish)
	{
		this.earliestFinish = earliestFinish;
	}

	/**
	 * @return the latestStart
	 */
	public Double getLatestStart()
	{
		return latestStart;
	}

	/**
	 * @param latestStart the latestStart to set
	 */
	public void setLatestStart(Double latestStart)
	{
		this.latestStart = latestStart;
	}

	/**
	 * @return the latestFinish
	 */
	public Double getLatestFinish()
	{
		return latestFinish;
	}

	/**
	 * @param latestFinish the latestFinish to set
	 */
	public void setLatestFinish(Double latestFinish)
	{
		this.latestFinish = latestFinish;
	}

	/**
	 * @return the slack
	 */
	public Double getSlack()
	{
		return slack;
	}

	/**
	 * @param slack the slack to set
	 */
	public void setSlack(Double slack)
	{
		this.slack = slack;
	}

	/**
	 * @return the transitions
	 */
	public List<Transition> getTransitions()
	{
		return transitions;
	}

	/**
	 * @param transitions the transitions to set
	 */
	public void setTransitions(List<Transition> transitions)
	{
		this.transitions = transitions;
	}

	@Override
	public String toString()
	{
		return "Task [id= " + id + " name: " + name + " duration: " + duration + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
