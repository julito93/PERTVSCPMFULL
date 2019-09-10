package co.com.icesi.backend.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class TransitionId implements Serializable
{

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Task.class)
	@JoinColumn(name = "PREDECESOR", referencedColumnName = "id")
//	@MapsId(value = "id")
	@JsonBackReference
	private Task predecesor;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Task.class)
	@JoinColumn(name = "SUCCESOR", referencedColumnName = "id")
//	@MapsId(value="id")
	@JsonBackReference
	private Task successor;

	public TransitionId()
	{
		super();
	}

	public TransitionId(Task predecesor, Task successor)
	{
		this.predecesor = predecesor;
		this.successor = successor;
	}

	public Task getPredecesor()
	{
		return predecesor;
	}

	public void setPredecesor(Task predecesor)
	{
		this.predecesor = predecesor;
	}

	public Task getSuccessor()
	{
		return successor;
	}

	public void setSuccessor(Task successor)
	{
		this.successor = successor;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((predecesor == null) ? 0 : predecesor.hashCode());
		result = prime * result + ((successor == null) ? 0 : successor.hashCode());
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
		TransitionId other = (TransitionId) obj;
		if (predecesor == null)
		{
			if (other.predecesor != null)
				return false;
		}
		else if (!predecesor.equals(other.predecesor))
			return false;
		if (successor == null)
		{
			if (other.successor != null)
				return false;
		}
		else if (!successor.equals(other.successor))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "TransitionId [predecesor=" + predecesor.getName() + ", successor=" + successor.getName() + "]";
	}

}
