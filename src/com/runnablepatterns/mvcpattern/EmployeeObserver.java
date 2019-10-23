package com.runnablepatterns.mvcpattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface used by all elements that want to receive notifications from employee changes 
 */
public interface EmployeeObserver {

	/**
	 * Method called when a model change happens
	 * @param name
	 * @param lastName
	 */
	public void updateEmployeeTable(String name, String lastName);
}
