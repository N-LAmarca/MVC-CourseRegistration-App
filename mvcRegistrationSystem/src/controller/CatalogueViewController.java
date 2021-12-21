package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;


public class CatalogueViewController 
{
	CatalogueModel theModel;
	AppView appView;
	
	public CatalogueViewController(AppView appView, CatalogueModel theModel )
	{
		this.appView = appView;
		this.theModel = theModel;
		appView.addActionListener(appView.getCatalogueViewButton(), new CatalogueViewListener());
	}
	class CatalogueViewListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == appView.getCatalogueViewButton())
			{	
				appView.setTheDisplay(theModel.listCourses());
			}
		}
	}
}
