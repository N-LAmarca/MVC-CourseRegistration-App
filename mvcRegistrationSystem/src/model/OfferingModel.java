package model;

import java.util.ArrayList;


public class OfferingModel 
{
	private int sectionNum;
	private int sectionCap; 
	private int studentCount;
	private CourseModel theCourse;
	private ArrayList<RegistrationModel> studentList;
	
	public OfferingModel(int sectionNum, int sectionCap)
	{
		setSectionNum(sectionNum);
		setSectionCap(sectionCap);
		setStudentList(new ArrayList<RegistrationModel>());
		studentCount = 0;
	}
	public String addRegistration(RegistrationModel reg)
	{
		String message = "";
		// Check that the offering capacity has not already been reached
		if(studentCount <= this.sectionCap)		
		{
			getStudentList().add(reg);
			studentCount ++;
			// Course offerings require 8 students minimum to run, so notify user if there are currently less than 8 students enrolled
			if (studentCount < 8)
			{
				message =  "\n" + "Please note that this offering is not guarunteed until a minimum of 8 students are registered in it." + 
									"\n" + " The current number of students registered is: " + studentCount + "/8" + "\n";
			}
			return message;
		}
		else if (studentCount == this.sectionCap)
		{
			message = "\n" + "The course offering is already at its maximum capacity of " + this.sectionCap +". You cannot register in this section";
		}
		return message;
	}
	
	public void removeRegistration(RegistrationModel reg)
	{
		studentList.remove(reg);
		studentCount--;
	}

	public int getSectionNum()
	{
		return sectionNum;
	}

	public void setSectionNum(int sectionNum)
	{
		this.sectionNum = sectionNum;
	}

	public int getSectionCap() 
	{
		return sectionCap;
	}

	public void setSectionCap(int sectionCap)
	{
		this.sectionCap = sectionCap;
	}
	
	public ArrayList<RegistrationModel> getStudentList()
	{
		return studentList;
	}

	public void setStudentList(ArrayList<RegistrationModel> studentList) 
	{
		this.studentList = studentList;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		s += "Section Number: " + this.sectionNum + ", Section capacity: " + this.sectionCap + "\n" +
		"Seats filled: " + this.studentList.size() + "/" + this.sectionCap + "\n\n";	
		return s;
	}

	public CourseModel getTheCourse()
	{
		return theCourse;
	}

	public void setTheCourse(CourseModel theCourse) 
	{
		this.theCourse = theCourse;
	}
}

