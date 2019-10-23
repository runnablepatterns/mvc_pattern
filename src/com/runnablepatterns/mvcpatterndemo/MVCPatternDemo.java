package com.runnablepatterns.mvcpatterndemo;

import com.runnablepatterns.mvcpattern.EmployeeBL;
import com.runnablepatterns.mvcpattern.EmployeeControllerImpl;
import com.runnablepatterns.mvcpattern.EmployeeObservable;
import com.runnablepatterns.mvcpattern.IEmployeeController;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to demonstrate MVC pattern 
 */
public class MVCPatternDemo {

	public static void main(String[] args) {
		// create the model
		EmployeeObservable model = new EmployeeBL();
		
		// create the controller and assign the model
		IEmployeeController controller = new EmployeeControllerImpl(model);
	}

}
