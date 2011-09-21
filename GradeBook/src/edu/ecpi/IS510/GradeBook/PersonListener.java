package edu.ecpi.IS510.GradeBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

class PersonListener implements ActionListener {
	JTextField firstName, lastName, address, email, phone, id;
	ButtonGroup personType;
	long personId;
	PersonListener(JTextField firstNameField, JTextField lastNameField, JTextField addressField, JTextField phoneField, JTextField emailField, ButtonGroup personType) {
	  this.firstName = firstNameField;
	  this.lastName = lastNameField;
	  this.address = addressField;
	  this.email = emailField;
	  this.phone = phoneField;
	  this.personType = personType;
  }

  /*
   * (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   * This funciton receives the data from the form when the "Add Person" button is clicked
   * and adds the person to the database
   */
  public void actionPerformed(ActionEvent e) {
	  String selectedButton = personType.getSelection().getActionCommand(); 
	  System.out.println(personType.getSelection().getActionCommand());
	  if(e.getActionCommand().equals("Add Person")){
		  if(selectedButton == "Student"){
			  Student newStudent = new Student();
			  newStudent.setFirstName(this.firstName.getText());
			  newStudent.setLastName(this.lastName.getText());
			  newStudent.setAddress(this.address.getText());
			  newStudent.setEmail(this.email.getText());
			  newStudent.setPhone(this.phone.getText());
			  try {
				GradeBook.dbController.studentDao.createOrUpdate(newStudent);
				GradeBook.updateStudents();
		        System.out.println(GradeBook.students);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
		  else{
			  Teacher newTeacher = new Teacher();
			  newTeacher.setFirstName(this.firstName.getText());
			  newTeacher.setLastName(this.lastName.getText());
			  newTeacher.setAddress(this.address.getText());
			  newTeacher.setEmail(this.email.getText());
			  newTeacher.setPhone(this.phone.getText());
			  try {
				GradeBook.dbController.teacherDao.createOrUpdate(newTeacher);
				//GradeBook.updateStudents();
		        System.out.println("Teacher Added");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
	  }
  }
}