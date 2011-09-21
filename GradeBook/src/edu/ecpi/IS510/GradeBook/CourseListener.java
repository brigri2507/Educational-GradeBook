package edu.ecpi.IS510.GradeBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


/*
 * This class listens for a button to be pressed and
 * accepts 2 parameters in it's constructor which it,
 * in turn, passes to the 'actionPerformed' method for parsing,
 * validation (not done yet), and posting to the database
 */

class CourseListener implements ActionListener {
	String courseName, courseNumber;
	long personId;
	CourseListener(JTextField courseNameField, JTextField courseNumberField) {
	  this.courseName = courseNameField.getText();
	  this.courseNumber = courseNumberField.getText();
  }

  public void actionPerformed(ActionEvent e) {
	  	//DO STUFF HERE
  }
}