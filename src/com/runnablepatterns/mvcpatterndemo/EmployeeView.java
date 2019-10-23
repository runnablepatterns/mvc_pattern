package com.runnablepatterns.mvcpatterndemo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.runnablepatterns.mvcpattern.IEmployeeController;
import com.runnablepatterns.mvcpattern.EmployeeObservable;
import com.runnablepatterns.mvcpattern.EmployeeObserver;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeView implements EmployeeObserver{

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTable tableEmployee;
	
	/**
	 * Variable used to store model
	 */
	private EmployeeObservable model;
	
	/**
	 * Variable used to store controller
	 */
	private IEmployeeController controller;

	/**
	 * Overloaded constructor used to initialize controller and model
	 * @param _controller
	 * @param _model
	 */
	public EmployeeView(IEmployeeController _controller, EmployeeObservable _model) {
		this.controller = _controller;
		this.model = _model;
		this.model.registerObserver(this);
		initialize();
	}
	
	/**
	 * Method used to set frame visibility
	 * @param _visible
	 */
	public void setFrameVisible(boolean _visible) {
		this.frame.setVisible(_visible);
	}
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MVCPatternDemo window = new MVCPatternDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	/**
	 * Method used when the user adds a new employee
	 * @param e
	 */
	private void addEmployeeClick(ActionEvent e) {
		if(validFields()) {
			this.controller.addEmployee(this.txtName.getText(), this.txtLastName.getText());
		}
	}
	
	@Override
	public void updateEmployeeTable(String name, String lastName) {
		// create the row data
		Object[] newRow = {name, lastName};
		
		// add a new row
		((DefaultTableModel)this.tableEmployee.getModel()).addRow(newRow);
	}
	
	/**
	 * Method to perform basic UI validations
	 * @return True if the fields are valid
	 */
	private boolean validFields() {
		return (this.txtName.getText().trim() != "" && this.txtLastName.getText().trim() != "");
	}
	
	/**
	 * Method used to clear variables
	 */
	public void clearFields() {
		this.txtName.setText("");
		this.txtLastName.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 295, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(45, 12, 119, 15);
		frame.getContentPane().add(lblEmployeeName);
		
		txtName = new JTextField();
		txtName.setBounds(168, 10, 114, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblEmployeeLastName = new JLabel("Employee Last Name");
		lblEmployeeLastName.setBounds(12, 39, 152, 15);
		frame.getContentPane().add(lblEmployeeLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(168, 39, 114, 19);
		frame.getContentPane().add(txtLastName);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployeeClick(e);
			}
		});
		btnAddEmployee.setBounds(12, 66, 270, 25);
		frame.getContentPane().add(btnAddEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 108, 267, 153);
		frame.getContentPane().add(scrollPane);
		
		tableEmployee = new JTable();
		tableEmployee.setModel(new DefaultTableModel(
			new String[] {
				"Name", "Last Name"
			}, 0
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableEmployee.getColumnModel().getColumn(0).setResizable(false);
		tableEmployee.getColumnModel().getColumn(0).setPreferredWidth(130);
		tableEmployee.getColumnModel().getColumn(1).setResizable(false);
		tableEmployee.getColumnModel().getColumn(1).setPreferredWidth(130);
		tableEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableEmployee.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(tableEmployee);
	}
}
