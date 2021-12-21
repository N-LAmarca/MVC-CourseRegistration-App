package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;


public class StudentController 
{
	StudentModel theModel;
	CatalogueModel cat;
	AppView appView;
	CourseAddController addCourse;
	CourseRemoveController remCourse;
	EnrolledViewController enrolledCourses;
	
	
	public StudentController(AppView appView, CatalogueModel cat)
	{
		this.appView = appView;
		this.cat = cat;
		
		appView.addActionListener(appView.getSignInButton(), new StudentListener());
	}
	
	
	class StudentListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == appView.getSignInButton())
			{	
				String name = "";
				int number = 0;
				try {
						name = appView.getStudentName();
						number = appView.getStudentNumber();
						theModel = new StudentModel(name, number);
						appView.setTheDisplay("Welcome " + theModel.getStudentName() + ". You have successfully logged on.\n" 
						+ "Please select one of the menu items below and enter any required course information in the fields below: ");
						enrolledCourses= new EnrolledViewController(appView, theModel);
						addCourse = new CourseAddController(appView, theModel, cat);
						remCourse = new CourseRemoveController(appView, theModel, cat);
						
					}
				catch (NumberFormatException ex) 
				{
					appView.setTheDisplay("Error! You must enter a number!");
				}
			}
		}
	}
}