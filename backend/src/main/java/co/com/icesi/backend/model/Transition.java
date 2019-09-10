package co.com.icesi.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jcampaz
 *
 */
@Entity
@Table(name = "Transition")
public class Transition implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransitionId id;

	@Column
	private String type;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public TransitionId getId()
	{
		return id;
	}

	public void setId(TransitionId id)
	{
		this.id = id;
	}

	
	
	public Transition()
	{
		super();
	}

	public Transition(TransitionId id, String type)
	{
		super();
		this.id = id;
		this.type = type;
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

		Transition other = (Transition) obj;
		if (other.id == null)
			return false;

		return this.id.equals(other.id);
	}

	@Override
	public String toString()
	{
		return "Transition [id=" + id.getPredecesor().getName() + " -> "+id.getSuccessor().getName()+"]";
	}
	
	
}
