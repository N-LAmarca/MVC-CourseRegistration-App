package model;

import java.util.ArrayList;


public class CatalogueModel 
{
	private ArrayList <CourseModel> courseList;
	
	public CatalogueModel()
	{
		courseList = loadFromDB();
	}
	
	public ArrayList <CourseModel> getCourseList() 
	{
		return courseList;
	}

	public void setCourseList(ArrayList <CourseModel> courseList) 
	{
		this.courseList = courseList;
	}
	
	public String listCourses () 
	{
		String temp = "";
		for(CourseModel c: courseList)
			temp += c;
		return temp;
	}
	
	@Override
	public String toString()
	{
		String temp = "";
		for(CourseModel c: courseList)
			temp += c;
		return temp;
	}
	
	public void listOfferings()
	{
		for (CourseModel c: courseList)
		{
			System.out.println(c.getOfferingList());

		}
	}
	
	
	public CourseModel searchCat (String courseName, int courseNumber)
	{
		// Search catalog for the user-entered course
		for (CourseModel c: courseList)
		{
			if (c.getCourseName().equals(courseName) && 
					c.getCourseNumber() == courseNumber)
			{
				return c;
			}
		}
		return null;
	}

	
	private static ArrayList<CourseModel> loadFromDB() // dummy helper function
	{
		//IRL courses added from the DB or a file/disk. For now, imagine all is coming from a DB.
		
		ArrayList<CourseModel> imaginaryDB = new ArrayList<CourseModel>();
		
		// Add the available courses
		imaginaryDB.add(new CourseModel("ENSF", 607));
		imaginaryDB.add(new CourseModel("ENSF", 608));
		imaginaryDB.add(new CourseModel("ENSF", 609));
		imaginaryDB.add(new CourseModel("ENSF", 610));
		imaginaryDB.add(new CourseModel("ENSF", 611));
		imaginaryDB.add(new CourseModel("ENSF", 612));
		imaginaryDB.add(new CourseModel("ENSF", 614));
		imaginaryDB.add(new CourseModel("ENGG", 683));
		
		
		// Generate list of prerequisite courses
		for (CourseModel c: imaginaryDB)
		{
			c.addPrerequisite(new CourseModel("ENSF", 592));
			c.addPrerequisite(new CourseModel("ENSF", 593));
			c.addPrerequisite(new CourseModel("ENSF", 594));
	
		}

		// Generate list of course sections with capacities of 80 students 
		for (CourseModel c: imaginaryDB)
		{
			c.addOffering(new OfferingModel(1,80));
			c.addOffering(new OfferingModel(2,80));
			c.addOffering(new OfferingModel(3,80));
		}
		
		return imaginaryDB;
	}
}
