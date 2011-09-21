package edu.ecpi.IS510.GradeBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*import com.jgoodies.forms.factories.DefaultComponentFactory;*/
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class ManageGradeBook {

	protected JFrame frmIsGradebookApplication;
	
	//Add Person Fields
	protected JTextField textBoxFirstName;
	protected JTextField textBoxLastName;
	protected JTextField textBoxAddress;
	protected JTextField textBoxPhone;
	protected final ButtonGroup personType = new ButtonGroup();
	protected JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
	protected JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Teacher");
	protected JTextField textBoxEmail;
	
	//Add Course Fields
	private int[] creditValues = new int[4];
	protected JTextField textBoxCourseName;
	protected JTextField textBoxCourseNumber;

	/**
	 * The class creates the window of the application, places
	 * the fields and labels in the correct places, builds the 
	 * tabs and attaches the correct button listeners
	 * 
	 * @param firstNameField JTextField accepts the first name of the user
	 * @param lastNameField JTextField accepts the last name of the user
	 * @param addressField JTextField accepts the address of the user
	 * @param phoneField JTextField accepts the phone number of the user
	 * @param emailField JTextField accepts the email address of the user
	 * @param rdbtnNewRadioButton JRadioButton choose Student type of Person
	 * @param rdbtnNewRadioButton_1 JRadioButton choose Teacher type of Person
	 * @param personType JTextField accepts the first name of the user
	 * @param courseNameField JTextField accepts the course name
	 * @param courseNumberField JTextField accepts the course number
	 * 
	 * Notes:
	 * This is a test
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageGradeBook window = new ManageGradeBook();
					window.frmIsGradebookApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}/*
	
	

	/**
	 * Create the application.
	 */
	public ManageGradeBook() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frmIsGradebookApplication = new JFrame();
		frmIsGradebookApplication.setTitle("IS510 GradeBook Application");
		frmIsGradebookApplication.setBounds(100, 100, 798, 600);
		frmIsGradebookApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIsGradebookApplication.getContentPane().setLayout(null);
		
		//Simple label for the application
		JLabel lblWelcomeToThe = new JLabel("IS510 GradeBook Application");
		lblWelcomeToThe.setBounds(20, 23, 254, 14);
		frmIsGradebookApplication.getContentPane().add(lblWelcomeToThe);
		
		//Creates tabbed panel
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 46, 752, 505);
		frmIsGradebookApplication.getContentPane().add(tabbedPane);
		
		
		//Add 'People' pane
		JPanel panelPeople = new JPanel();
		panelPeople.setToolTipText("You must select \"Student\" or \"Teacher\"");
		tabbedPane.addTab("People", null, panelPeople, null);
		panelPeople.setLayout(null);
		
		JLabel lblThisSectionIs = new JLabel("Add a new person");
		lblThisSectionIs.setBounds(10, 11, 205, 14);
		panelPeople.add(lblThisSectionIs);
		
		
		//****************************   BEGIN PERSON FIELDS *************** /
		textBoxFirstName = new JTextField("Enter Firstname");
		textBoxFirstName.setBounds(124, 36, 205, 20);
		panelPeople.add(textBoxFirstName);
		textBoxFirstName.setColumns(10);
		
		JLabel labelFirstName = new JLabel("First name");
		labelFirstName.setBounds(10, 36, 104, 14);
		panelPeople.add(labelFirstName);

		
		textBoxLastName = new JTextField("Enter Lastname");
		textBoxLastName.setBounds(124, 64, 205, 20);
		panelPeople.add(textBoxLastName);
		textBoxLastName.setColumns(10);
		
		JLabel labelLastName = new JLabel("Last name");
		labelLastName.setBounds(10, 64, 104, 14);
		panelPeople.add(labelLastName);
		
		textBoxAddress = new JTextField();
		textBoxAddress.setColumns(10);
		textBoxAddress.setBounds(124, 89, 205, 20);
		panelPeople.add(textBoxAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 89, 104, 14);
		panelPeople.add(lblAddress);
		
		textBoxPhone = new JTextField();
		textBoxPhone.setColumns(10);
		textBoxPhone.setBounds(124, 114, 205, 20);
		panelPeople.add(textBoxPhone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 113, 104, 14);
		panelPeople.add(lblPhone);
		
		rdbtnNewRadioButton.setActionCommand("Student");		
		personType.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(335, 202, 250, 23);
		panelPeople.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1.setActionCommand("Teacher");
		personType.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(335, 177, 250, 23);
		panelPeople.add(rdbtnNewRadioButton_1);
		
		textBoxEmail = new JTextField();
		textBoxEmail.setColumns(10);
		textBoxEmail.setBounds(124, 142, 205, 20);
		panelPeople.add(textBoxEmail);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(10, 141, 104, 14);
		panelPeople.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add Person");
		btnNewButton.setBounds(335, 234, 122, 23);
		panelPeople.add(btnNewButton);
		
		//Add the action listener to the Add Person button and pass in the ACTUAL fields themselves to grant access to the data
		//that will be entered into them
		btnNewButton.addActionListener(new PersonListener(textBoxFirstName, textBoxLastName, textBoxAddress, textBoxPhone, textBoxEmail, personType));

		//****************************   END PERSON FIELDS *************** /
		
		

		//****************************   BEGIN COURSE FIELDS *************** /
		//Add 'Courses' pane
		JPanel panelCourses = new JPanel();
		tabbedPane.addTab("Courses", null, panelCourses, null);
		panelCourses.setLayout(null);
		
		JLabel labelAddCourse = new JLabel("Add a new course");
		labelAddCourse.setBounds(10, 11, 139, 14);
		panelCourses.add(labelAddCourse);
		
		JLabel labelAddCourseName = new JLabel("Course name");
		labelAddCourseName.setBounds(10, 36, 150, 14);
		panelCourses.add(labelAddCourseName);
		
		textBoxCourseName = new JTextField();
		textBoxCourseName.setBounds(110, 36, 241, 20);
		panelCourses.add(textBoxCourseName);
		textBoxCourseName.setColumns(10);

		
		JLabel labelAddCourseNumber = new JLabel("Course Number");
		labelAddCourseNumber.setBounds(10, 61, 150, 14);
		panelCourses.add(labelAddCourseNumber);
		
		textBoxCourseNumber = new JTextField();
		textBoxCourseNumber.setBounds(110, 64, 241, 20);
		panelCourses.add(textBoxCourseNumber);
		textBoxCourseNumber.setColumns(10);
		
		//Create dropdown list of credits
		JComboBox comboBoxCredits = new JComboBox();
		comboBoxCredits.setModel(new DefaultComboBoxModel());
		comboBoxCredits.setBounds(350, 35, 60, 22);
		comboBoxCredits.addItem(1);
		comboBoxCredits.addItem(2);
		comboBoxCredits.addItem(3);
		comboBoxCredits.addItem(4);
		panelCourses.add(comboBoxCredits);
		
		JButton btnNewButton_1 = new JButton("Add Course");
		panelCourses.add(btnNewButton_1);
		btnNewButton_1.setBounds(361, 63, 126, 23);
		//TODO Add an update action to re-populate combo lists below in course tab
		
		//Add 'Add Course' action listener
		btnNewButton_1.addActionListener(new CourseListener(textBoxCourseName, textBoxCourseNumber, comboBoxCredits));	
		
		JLabel labelAddStudentCourse = new JLabel("Add Student to Course");
		labelAddStudentCourse.setBounds(10, 168, 139, 14);
		panelCourses.add(labelAddStudentCourse);
		
		JLabel lblSelectCourseAddStudent = new JLabel("Select Course");
		lblSelectCourseAddStudent.setBounds(10, 193, 150, 14);
		panelCourses.add(lblSelectCourseAddStudent);
		
		JLabel lblSelectAddStudent = new JLabel("Course Number");
		lblSelectAddStudent.setBounds(10, 218, 150, 14);
		panelCourses.add(lblSelectAddStudent);
		
		JButton buttonAddStudentCourse = new JButton("Add Student to Course");
		buttonAddStudentCourse.setBounds(361, 405, 200, 23);
		panelCourses.add(buttonAddStudentCourse);
		
		JComboBox comboBoxSelectCourseAddStudent = new JComboBox();
		comboBoxSelectCourseAddStudent.setBounds(110, 190, 241, 20);
		panelCourses.add(comboBoxSelectCourseAddStudent);
		
		JComboBox comboBoxSelectAddStudent = new JComboBox();
		comboBoxSelectAddStudent.setBounds(110, 221, 241, 20);
		panelCourses.add(comboBoxSelectAddStudent);
		
		JList listBoxSelectMultiStudents = new JList();
		listBoxSelectMultiStudents.setBounds(110, 255, 241, 173);
		panelCourses.add(listBoxSelectMultiStudents);
		
		JLabel lableSelectMultipleStudents = new JLabel("Select Student(s)");
		lableSelectMultipleStudents.setBounds(10, 256, 90, 14);
		panelCourses.add(lableSelectMultipleStudents);
		
		JLabel lblNewLabel_1 = new JLabel("Use Ctrl + Click to add multiple students");
		lblNewLabel_1.setBounds(110, 439, 241, 14);
		panelCourses.add(lblNewLabel_1);
		
		JLabel labelTeacherCourse = new JLabel("Add a teacher to a course");
		labelTeacherCourse.setHorizontalAlignment(SwingConstants.LEFT);
		labelTeacherCourse.setBounds(10, 107, 125, 44);
		panelCourses.add(labelTeacherCourse);
		
		JLabel labelCourseNameToTeacher = new JLabel("Course name");
		labelCourseNameToTeacher.setBounds(158, 107, 150, 14);
		panelCourses.add(labelCourseNameToTeacher);
		
		JButton btnAddTeacher = new JButton("Add Teacher -> Course");
		btnAddTeacher.setBounds(574, 107, 150, 44);
		panelCourses.add(btnAddTeacher);
		
		JComboBox comboBoxCourseToTeacher = new JComboBox();
		comboBoxCourseToTeacher.setBounds(158, 129, 193, 20);
		panelCourses.add(comboBoxCourseToTeacher);
		
		JComboBox comboBoxTeacherToCourse = new JComboBox();
		comboBoxTeacherToCourse.setBounds(368, 129, 193, 20);
		panelCourses.add(comboBoxTeacherToCourse);
		
		JLabel labelTeacherNameToCourse = new JLabel("Teacher name");
		labelTeacherNameToCourse.setBounds(368, 107, 150, 14);
		panelCourses.add(labelTeacherNameToCourse);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 94, 697, 2);
		panelCourses.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 155, 697, 2);
		panelCourses.add(separator_1);
		//****************************   END COURSE FIELDS *************** /
		
		//Add 'Assignments' pane
		JPanel panelAssignments = new JPanel();
		tabbedPane.addTab("Assignments", null, panelAssignments, null);
		panelAssignments.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel());
		comboBox.setBounds(10, 35, 231, 20);
		panelAssignments.add(comboBox);
		
		Student currentStudent = new Student();
		String fullName = "";
		for(int i = 0; i < GradeBook.students.size(); i++){
			currentStudent = GradeBook.students.get(i);
			fullName = currentStudent.getFirstName() + " " + currentStudent.getLastName();
			comboBox.addItem(fullName);
		}
		
		/*
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Student1", "Student2", "Student3", "Student4", "Student5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(31, 66, 210, 98);
		panel_2.add(list);
		
		JButton btnApplyStudentsTo = new JButton("Add students to class");
		btnApplyStudentsTo.setBounds(559, 423, 178, 23);
		panel_2.add(btnApplyStudentsTo);
		
		JLabel lblUseCtrlclickTo = new JLabel("Use Ctrl+click to add multiple students");
		lblUseCtrlclickTo.setBounds(31, 175, 260, 14);
		panel_2.add(lblUseCtrlclickTo);*/
	}
}


