package com.runnablepatterns.mvcpattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to store Employee details 
 */
public class Employee {
	
	/**
	 * Variable to store name details
	 */
	private String name;
	
	/**
	 * Variable to store last name details
	 */
	private String lastName;
	
	/**
	 * Overloaded constructor to initialice employee details
	 * @param _name
	 * @param _lastName
	 */
	public Employee(String _name, String _lastName) {
		this.setName(_name);
		this.setLastName(_lastName);
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
