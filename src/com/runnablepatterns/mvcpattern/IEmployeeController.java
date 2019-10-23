package com.runnablepatterns.mvcpattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface used by all elements that want to control models and views 
 */
public interface IEmployeeController {
	
	/**
	 * Method used to add a new employee
	 * @param _name
	 * @param _lastName
	 */
	void addEmployee(String _name, String _lastName);

}
