package co.com.icesi.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import co.com.icesi.backend.businessLogic.TaskBO;

/**
 * @author jcampaz
 *
 */
@Entity
@Table(name = "Tasks")
public class Task
{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private Double duration;

	@Column(nullable = true, name = "EARLIESTSTART")
	private Double earliestStart;

	@Column(nullable = true, name = "EARLIESTFINISH")
	private Double earliestFinish;

	@Column(nullable = true, name = "LATESTSTART")
	private Double latestStart;

	@Column(nullable = true, name = "LATESTFINISH")
	private Double latestFinish;

	@Column(nullable = true)
	private Double slack;

	@OneToMany(mappedBy = "id.predecesor", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Transition> Successors;
	
	
	@OneToMany(mappedBy = "id.successor", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Transition> predecessors;

	
	public Task()
	{
		super();
		Successors = new ArrayList<Transition>();
		predecessors = new ArrayList<Transition>();
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
		Successors = new ArrayList<Transition>();
		predecessors = new ArrayList<Transition>();

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
	 * @return the Successors
	 */
	public List<Transition> getSuccessors()
	{
		return Successors;
	}

	/**
	 * @param Successors the Successors to set
	 */
	public void setSuccessors(List<Transition> Successors)
	{
		this.Successors = Successors;
	}

	/**
	 * @return the predecessors
	 */
	public List<Transition> getPredecessors()
	{
		return predecessors;
	}

	/**
	 * @param predecessors the predecessors to set
	 */
	public void setPredecessors(List<Transition> predecessors)
	{
		this.predecessors = predecessors;
	}

	@Override
	public String toString()
	{
		return "Task [id=" + id +" name: "+ name+"]";
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

	public TaskBO toBO()
	{
		return new TaskBO(id, name, duration);
	}
}
