package edu.ecpi.IS510.GradeBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

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