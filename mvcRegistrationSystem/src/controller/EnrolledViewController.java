package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class EnrolledViewController 
{	
	StudentModel theModel;
	AppView appView;
	
	public EnrolledViewController(AppView appView, StudentModel theModel)
	{
		this.appView = appView;
		this.theModel = theModel;
		appView.addActionListener(appView.getEnrolledViewButton(), new EnrolledSearchListener());
	}
	class EnrolledSearchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == appView.getEnrolledViewButton())
			{
				String enrolledCourses = theModel.listRegisteredCourses();
				appView.setTheDisplay(enrolledCourses);
			}
		}
	}
}
