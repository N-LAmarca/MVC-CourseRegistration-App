package model;

import java.util.ArrayList;




public class StudentModel {

	private String studentName;
	private int studentNumber; 
	private ArrayList <RegistrationModel> registrationList;
	private ArrayList <CourseModel> takenCourses;
	private int registrationCount;
	
	public StudentModel(String name, int number) 
	{
		this.setStudentName(name);
		this.setStudentNumber(number);
		setRegistrationList(new ArrayList<RegistrationModel>());
		setTakenCourses(new ArrayList<CourseModel>());
		this.registrationCount = 0;
		this.getTakenCourses().add(new CourseModel("ENSF", 592));
		this.getTakenCourses().add(new CourseModel("ENSF", 593));
		this.getTakenCourses().add(new CourseModel("ENSF", 594));
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public String registerForCourse(CatalogueModel cat, String courseName, int courseNumber, int secNumber)
	{
		// Confirm course is available in the catalog
		CourseModel myCourse = cat.searchCat(courseName, courseNumber);
		if (myCourse == null)
		{
			return "Invalid course entry. Unable to register.";
			
		}
		for (CourseModel c: takenCourses)
		{
			if(myCourse.equals(c))
			{
				return "You have already taken this course. You may note re-take it." + "\n";
				
			}
		}
		// Check to see if Student has already enrolled in the maximum number of courses(six)
		if (registrationList.size() == 6)
		{
			return "\n" + "You are already enrolled in the maximum of 6 courses. Please remove a course before trying to add another.";
			
		}
		
		// if the course exists, then we can look at the section 
		OfferingModel theOffering = myCourse.getOfferingList().get(secNumber-1); 
		RegistrationModel reg = new RegistrationModel(this, theOffering);
		reg.getTheOffering().setTheCourse(myCourse);
		
		// Prerequisite check
		int prereqMet =0;
		int prereqRequired = myCourse.getPrereqList().size();
		if (myCourse.getPrereqList().size() > 0)
		{
			if (takenCourses.size() == 0)
			{
				return "\n" + "Missing prerequisite, cannot enroll in course." + "\n";
				
			}
			else 
			{
				for (CourseModel prereq : myCourse.getPrereqList())
				{ 
					for (CourseModel c: takenCourses)
					{
						if (c.getCourseName().equals(prereq.getCourseName()) && c.getCourseNumber() == (prereq.getCourseNumber()))
						{
							prereqMet ++;
							break;
						}
					}
				}
				if (prereqMet != prereqRequired)
				{
					return "\n" + "Missing prerequisite, can not enroll in course." + "\n";
					
				}
			}
		}
		// If student has met all the above requirements, allow them to enroll in the course offering
		String offeringMessage =theOffering.addRegistration(reg);
		addRegistration(reg);
		takenCourses.add(myCourse);
		return offeringMessage + '\n' + 
				"You have successfully been enrolled in " + courseName + " " + courseNumber + " section " + secNumber +"." + "\n";
		
	}

	public void addRegistration(RegistrationModel reg)
	{
			getRegistrationList().add(reg);
			registrationCount++;
	}
	
	public String unRegisterForCourse(CatalogueModel cat, String courseName, int courseNumber)
	{
		// Match course with available course in the catalog to ensure it is valid
		CourseModel myCourse = cat.searchCat(courseName, courseNumber);
		if (myCourse == null)
		{
			return("Invalid course entry." + "\n");
			
		}
		// Check that the student is currently registered in the course that they would like to remove 
		RegistrationModel rem = new RegistrationModel();
		
		for (RegistrationModel r: registrationList)
		{
			if (r.getTheOffering().getTheCourse().equals(myCourse))
			{
				rem = r;
				r.getTheOffering().removeRegistration(rem);
				removeRegistration(rem);
				takenCourses.remove(myCourse);
				// Notify the user that they have been removed from the given course registration 
				return("\n" + "You have been removed from your registered offering of the following course: " + myCourse + "\n");
				// Remove the course from the list of courses the student has taken/currently enrolled in
				
			}
		}
		return("\n" + "Error. You are not enrolled in the entered course, therefore it cannot be removed." + "\n");
	}
	
	public void removeRegistration(RegistrationModel reg)
	{
			registrationList.remove(reg);
			registrationCount--;
	}
	
	@Override
	public String toString()
	{
		return studentName;
	}

	public ArrayList <RegistrationModel> getRegistrationList()
	{
		return registrationList;
	}

	public void setRegistrationList(ArrayList <RegistrationModel> registrationList)
	{
		this.registrationList = registrationList;
	}

	public ArrayList <CourseModel> getTakenCourses() 
	{
		return takenCourses;
	}

	public void setTakenCourses(ArrayList<CourseModel> arrayList) 
	{
		this.takenCourses = arrayList;
	}
	
	public String listTakenCourses()
	{
		String temp = "";
		for(CourseModel c: takenCourses)
			temp += c;
		return temp;
	}
	
	public String listRegisteredCourses()
	{
		if (registrationCount > 0)
		{
			String temp = "";
			for(RegistrationModel r: registrationList)
			temp += r.getTheOffering().getTheCourse();
			return temp;
		}
		else
			return "You are not registered in any courses at this time.";
	}
}

