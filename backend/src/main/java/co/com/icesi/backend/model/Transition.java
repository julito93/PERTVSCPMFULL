package co.com.icesi.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import co.com.icesi.backend.businessLogic.TransitionBO;

@Entity
@Table(name = "Transition")
public class Transition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonManagedReference
	private TransitionId id;

	@Column
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TransitionId getId() {
		return id;
	}

	public void setId(TransitionId id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
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

	public TransitionBO toBO() {
		// TODO Auto-generated method stub
		return new TransitionBO(id.getPredecesor().toBO(), id.getSuccessor().toBO(), type);
	}

}
