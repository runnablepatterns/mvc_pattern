package com.runnablepatterns.mvcpattern;

import java.util.ArrayList;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to handle employee operations 
 */
public class EmployeeBL implements EmployeeObservable{

	/**
	 * Variable used to store employees
	 */
	private ArrayList<Employee> employeeList;
	
	/**
	 * Variable used to store employee observers
	 */
	private ArrayList<EmployeeObserver> employeeObservers;
	
	/**
	 * Default constructor
	 */
	public EmployeeBL() {
		this.setEmployeeList(new ArrayList());
		this.setEmployeeObservers(new ArrayList());
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	/**
	 * @return the employeeObservers
	 */
	public ArrayList<EmployeeObserver> getEmployeeObservers() {
		return employeeObservers;
	}

	/**
	 * @param employeeObservers the employeeObservers to set
	 */
	public void setEmployeeObservers(ArrayList<EmployeeObserver> employeeObservers) {
		this.employeeObservers = employeeObservers;
	}

	@Override
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public void registerObserver(EmployeeObserver observer) {
		// add the observer
		this.getEmployeeObservers().add(observer);
	}

	@Override
	public void removeObserver(EmployeeObserver observer) {
		// remove observer
		this.getEmployeeObservers().remove(observer);
	}

	@Override
	public void addEmployee(String name, String lastName) {
		// add employee to the list
		this.getEmployeeList().add(new Employee(name, lastName));
		
		// notify observers about the employee just added
		notifyObservers(name, lastName);
	}
	
	/**
	 * Method used to notify all the observers
	 */
	public void notifyObservers(String _name, String _lastName) {
		// get all observers
		for(int index = 0; index < this.getEmployeeObservers().size(); index++) {
			// notify the change
			this.getEmployeeObservers().get(index).updateEmployeeTable(_name, _lastName);
		}
	}
}
