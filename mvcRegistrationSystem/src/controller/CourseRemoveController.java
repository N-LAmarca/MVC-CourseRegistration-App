package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.CourseAddController.CourseAddListener;
import model.CatalogueModel;
import model.StudentModel;
import view.AppView;

public class CourseRemoveController
{
	AppView appView;
	StudentModel theModel;
	CatalogueModel cat;
	public CourseRemoveController(AppView appView, StudentModel theModel, CatalogueModel cat)
	{
		this.appView = appView;
		this.theModel = theModel;
		this.cat = cat;
		appView.addActionListener(appView.getCourseRemovalButton(), new CourseRemovalListener());
	}
	class CourseRemovalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == appView.getCourseRemovalButton())
			{
				try 
				{
					String courseName = appView.getCourseDept().toUpperCase();
					int courseNumber = appView.getCourseNumber();
					String result = theModel.unRegisterForCourse(cat, courseName, courseNumber);
					appView.setTheDisplay(result);
				}catch (NumberFormatException ex)
				{
					appView.setTheDisplay("Error! You must enter a number!");
				}
			}
		}
	}
}
