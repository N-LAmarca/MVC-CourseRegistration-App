package controller;

import model.*;
import view.*;

public class CatalogueController 
{
	CatalogueModel theModel;
	
	AppView appView;
	
	CatalogueViewController cvControl;
	CatalogueSearchController csControl;
	
	
	public CatalogueController(AppView appView)
	{
		this.appView = appView;
		theModel = new CatalogueModel();
		cvControl = new CatalogueViewController(appView, theModel);
		csControl = new CatalogueSearchController(appView, theModel);
	}
	
	public CatalogueModel getCatalogueModel()
	{
		return theModel;
	}
}