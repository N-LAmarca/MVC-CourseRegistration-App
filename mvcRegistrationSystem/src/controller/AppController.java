package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class AppController
{
	
	AppView appView; 
	
	CatalogueController catalogueController;
	StudentController studentController;
	
	
	
	public AppController()
	{
		appView = new AppView();
		appView.run();
		catalogueController = new CatalogueController(appView);
		studentController = new StudentController( appView, catalogueController.getCatalogueModel());
		appView.addActionListener(appView.getQuitButton(), new QuitListener());
	}
	class QuitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == appView.getQuitButton())
			{
				appView.setVisible(false);
				appView.dispose();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		AppController theController = new AppController();
	}

}
