package co.com.icesi.backend.businessLogic;

public class TransitionBO {

	private TaskBO predecesor;

	private TaskBO succesor;

	private String type;

	public TransitionBO(TaskBO predecesor, TaskBO succesor, String type) {

		this.predecesor = predecesor;
		this.succesor = succesor;
		this.type = type;
	}

	/**
	 * @return the predecesor
	 */
	public TaskBO getPredecesor() {
		return predecesor;
	}

	/**
	 * @param predecesor the predecesor to set
	 */
	public void setPredecesor(TaskBO predecesor) {
		this.predecesor = predecesor;
	}

	/**
	 * @return the succesor
	 */
	public TaskBO getSuccesor() {
		return succesor;
	}

	/**
	 * @param succesor the succesor to set
	 */
	public void setSuccesor(TaskBO succesor) {
		this.succesor = succesor;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
