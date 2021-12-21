package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class CourseAddController 
{
	AppView appView;
	StudentModel theModel;
	CatalogueModel cat;
	public CourseAddController(AppView appView, StudentModel theModel, CatalogueModel cat)
	{
		this.appView = appView;
		this.theModel = theModel;
		this.cat = cat;
		appView.addActionListener(appView.getCourseRegistrationButton(), new CourseAddListener());
	}
	class CourseAddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == appView.getCourseRegistrationButton())
			{
				try 
				{
					String courseName = appView.getCourseDept().toUpperCase();
					int courseNumber = appView.getCourseNumber();
					int secNumber = appView.getSectionNumber();
					String result = theModel.registerForCourse(cat, courseName, courseNumber, secNumber);
					appView.setTheDisplay(result);
				}catch (NumberFormatException ex)
				{
					appView.setTheDisplay("Error! You must enter a number!");
				}
			}
		}
	}
}
