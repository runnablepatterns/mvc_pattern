package com.runnablepatterns.mvcpattern;

import java.util.ArrayList;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface used to expose all methods available to the model 
 */
public interface EmployeeObservable {

	/**
	 * Method to get all employees
	 * @return The employee list
	 */
	ArrayList<Employee> getEmployeeList();
	
	/**
	 * Add the employee to the list
	 * @param name
	 * @param lastName
	 */
	void addEmployee(String name, String lastName);
	
	/**
	 * Method to add a new observer
	 * @param observer
	 */
	void registerObserver(EmployeeObserver observer);
	
	/**
	 * Method to remove the observer
	 * @param observer
	 */
	void removeObserver(EmployeeObserver observer);
}
