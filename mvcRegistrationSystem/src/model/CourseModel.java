package model;
import java.util.ArrayList;


public class CourseModel 
{
	private String courseName;
	private int courseNumber;
	private ArrayList <CourseModel> prereqList;
	private ArrayList <OfferingModel> offeringList;
	
	public CourseModel(String courseName, int courseNumber)
	{
		setCourseName(courseName);
		setCourseNumber(courseNumber);
		prereqList = new ArrayList<CourseModel>();
		offeringList = new ArrayList<OfferingModel>();
		
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public int getCourseNumber() 
	{
		return courseNumber;
	}
	
	public void setCourseNumber(int courseNumber) 
	{
		this.courseNumber = courseNumber;
	}

	public ArrayList <CourseModel> getPrereqList() 
	{
		return prereqList;
	}

	public void setPrereqList(ArrayList <CourseModel> preReq) 
	{
		this.prereqList = preReq;
	}

	public ArrayList <OfferingModel> getOfferingList() 
	{
		return offeringList;
	}

	public void setOfferingList(ArrayList <OfferingModel> offeringList)
	{
		this.offeringList = offeringList;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		s += "\n" + courseName + " " + courseNumber + "\n";
		return s;
	}
	
	public void addPrerequisite(CourseModel prereq)
	{
		prereqList.add(prereq);
	}
	
	public void addOffering(OfferingModel section)
	{
		offeringList.add(section);
		
	}
	

}


