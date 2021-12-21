package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class CatalogueSearchController 
{
	CatalogueModel theModel;
	AppView appView;
	CourseModel searchedCourse;
	
	public CatalogueSearchController(AppView appView, CatalogueModel theModel )
	{
		this.appView = appView;
		this.theModel = theModel;
		appView.addActionListener(appView.getCourseSearchButton(), new CatalogueSearchListener());
	}
	class CatalogueSearchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == appView.getCourseSearchButton())
			{	
				try 
				{
					String courseName = appView.getCourseDept().toUpperCase();
					int courseNumber = appView.getCourseNumber();
					searchedCourse = theModel.searchCat(courseName, courseNumber);
					if (searchedCourse == null)
						appView.setTheDisplay("\n" + "The entered course does not exist." + "\n");
					else
					{
						appView.setTheDisplay(searchedCourse.toString()+ "\n" + "Available sections: " + searchedCourse.getOfferingList() + "\n"
							+ "Required prerequisites: " + searchedCourse.getPrereqList() );
					}
				}catch (NumberFormatException ex)
				{
					appView.setTheDisplay("Error! You must enter a number!");
				}
			}
				
		}
	}

}
