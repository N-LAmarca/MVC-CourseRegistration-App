package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AppView extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JLabel name = new JLabel("Please enter your full name");
	private JTextField studentName = new JTextField(10);
	private JLabel number = new JLabel ("Please enter your student ID number");
	private JTextField studentNumber = new JTextField(10);
	private JTextArea results = new JTextArea(10,1);
	
	private JLabel deptCode = new JLabel("Please enter the course department, i.e. ENSF: ");
	private JTextField courseDept = new JTextField(10);
	private JLabel courseCode = new JLabel ("Please enter the course number, i.e. 607: ");
	private JTextField courseNumber = new JTextField(10);
	private JLabel courseSection = new JLabel ("Please enter the section number, i.e. 1: ");
	private JTextField sectionNumber = new JTextField(10);
	
	private JButton courseSearch = new JButton("Search Courses");
	private JButton courseRegistration = new JButton("Add Course");
	private JButton courseRemoval = new JButton("Remove Course");
	private JButton catalogueView = new JButton("View Available Courses");
	private JButton enrolledView = new JButton("View Enrolled Courses");
	private JButton signIn = new JButton("Sign-in");
	private JButton quit = new JButton("Quit");
	
	
	public AppView()
	{

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setSize(600,600);
		
		JPanel studentInfo = new JPanel();
		studentInfo.setLayout(new GridLayout(3,1));
		studentInfo.add(name);
		studentInfo.add(studentName);
		studentInfo.add(number);
		studentInfo.add(studentNumber);
		studentInfo.add(signIn);
		
		JScrollPane scrollPane = new JScrollPane(results);
		results.setLineWrap(true);
		results.setWrapStyleWord(true);
		
	
		
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(6,1));
		
		menu.add(deptCode);
		menu.add(courseDept);
		menu.add(courseCode);
		menu.add(courseNumber);
		menu.add(courseSection);
		menu.add(sectionNumber);
		menu.add(courseSearch);
		menu.add(courseRegistration);
		menu.add(courseRemoval);
		menu.add(catalogueView);
		menu.add(enrolledView);
		menu.add(quit);
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North", studentInfo);
		contentPane.add("Center", scrollPane);
		contentPane.add("South", menu);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public void run()
	{
		setVisible(true);
	}
	
	public JButton getCourseSearchButton()
	{
		return courseSearch;
	}
	
	public JButton getCourseRegistrationButton()
	{
		return courseRegistration;
	}
	
	public JButton getCourseRemovalButton()
	{
		return courseRemoval;
	}
	
	public JButton getCatalogueViewButton()
	{
		return catalogueView;
	}
	
	public JButton getEnrolledViewButton()
	{
		return enrolledView;
	}
	
	public JButton getQuitButton()
	{
		return quit;
	}
	
	public JButton getSignInButton()
	{
		return signIn;
	}
	
	public String getStudentName()
	{
		String sName = studentName.getText();
		return sName;
	}
	
	public int getStudentNumber()
	{
		
		int sNumber = Integer.parseInt(studentNumber.getText());
		return sNumber;
	}

	public String getCourseDept()
	{
		String deptName = courseDept.getText();
		return deptName;

	}
	
	public int getCourseNumber()
	{
		
		int cNumber = Integer.parseInt(courseNumber.getText());
		return cNumber;
	}
	
	public int getSectionNumber()
	{
		
		int secNumber = Integer.parseInt(sectionNumber.getText());
		return secNumber;
	}
	
	public void addActionListener(JButton button, ActionListener listener)
	{
		button.addActionListener(listener);
	}
	
	
	public void setTheDisplay(String text)
	{
		results.setText(text);
	}
}
