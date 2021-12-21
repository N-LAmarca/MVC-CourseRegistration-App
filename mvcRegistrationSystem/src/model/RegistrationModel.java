package model;



public class RegistrationModel
{
	private StudentModel theStudent;
	private OfferingModel theOffering;
	private char grade;
	
	public RegistrationModel()
	{	
	}
	
	public RegistrationModel(StudentModel theStudent, OfferingModel theOffering)
	{
		this.setTheStudent(theStudent);
		this.setTheOffering(theOffering);
	
	}

	public void register (StudentModel theStudent, OfferingModel theOffering) {
	setTheStudent (theStudent);
	setTheOffering (theOffering);
	addRegistration ();
	}
	
	private void addRegistration() 
	{		
		getTheStudent().addRegistration(this);
		getTheOffering().addRegistration(this);
		
	}

	public StudentModel getTheStudent() 
	{
		return theStudent;
	}

	public void setTheStudent(StudentModel theStudent) 
	{
		this.theStudent = theStudent;
	}

	public OfferingModel getTheOffering() 
	{
		return theOffering;
	}

	public void setTheOffering(OfferingModel theOffering) 
	{
		this.theOffering = theOffering;
	}

	public char getGrade()
	{
		return grade;
	}

	public void setGrade(char grade) 
	{
		this.grade = grade;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		s += "Student: " +this.getTheStudent() + ", Course: " + this.getTheOffering().getTheCourse() + 
		", Section: " + this.getTheOffering().getSectionNum() + "\n\n";	
		return s;
	}

}
