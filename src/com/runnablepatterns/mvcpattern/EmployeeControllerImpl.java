package com.runnablepatterns.mvcpattern;

import com.runnablepatterns.mvcpatterndemo.EmployeeView;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to implement controller operations for its model 
 */
public class EmployeeControllerImpl implements IEmployeeController {

	/**
	 * Variable used to store model
	 */
	private EmployeeObservable model;
	
	/**
	 * Variable used to store the view
	 */
	private EmployeeView view;
	
	/**
	 * Overloaded constructor used to initialize model and the view
	 * @param _model
	 */
	public EmployeeControllerImpl(EmployeeObservable _model) {
		this.model = _model;
		// create the view
		this.view = new EmployeeView(this, this.model);
		this.view.setFrameVisible(true);
	}
	
	@Override
	public void addEmployee(String _name, String _lastName) {
		// call the model logic
		this.model.addEmployee(_name, _lastName);
		// clear view fields
		this.view.clearFields();
	}

}
