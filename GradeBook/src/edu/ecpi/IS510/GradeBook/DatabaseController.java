package edu.ecpi.IS510.GradeBook;

import java.sql.SQLException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * The Database controller class makes the program portable. By adding the ability to pass in a connection source, the program is not tied to one specific database.
 * 
 * <b>DAO or data access objects are created for each Class that is to be persisted in a database. The DAO has the built in ability to store and retrieve data regardless or DBMS.</b></ul>
 *@param connectionSource allows the user to pass the connection information to the specific database they want to user. </ul>
 *@param studentDao is a dao created to abstract and encapsulate all access to the data sources for the Student class.
 *@param assignmentDao is a dao created to abstract and encapsulate all access to the data sources for the Assignment class.
 *@param courseDao is a dao created to abstract and encapsulate all access to the data sources for the Course class.
 *@param employeeDao is a dao created to abstract and encapsulate all access to the data sources for the Employee class.
 *@param personDao is a dao created to abstract and encapsulate all access to the data sources for the Person class.
 *@param teacherDao is a dao created to abstract and encapsulate all access to the data sources for the Teacher class.
 *
 *@author Joe Thompson
 */
public class DatabaseController {
    protected ConnectionSource connectionSource;
    public Dao<Student, String> studentDao;
    public Dao<Assignment, String> assignmentDao;
    public Dao<Course, String> courseDao;
    public Dao<Employee, String> employeeDao;
    public Dao<Person, String> personDao;
    public Dao<Teacher, String> teacherDao;
    
    /**
     * Constructor method for establishing a new database connection it takes information such as database type, database name, user name, password. 
     * 		Calls the Java Data Base Connection API to perform database transactions using built in driver for different DBMS types.</ul>
     * If the connection <b>is not</b> established it will throw a SQL exception that the programmer can map to an error message.</ul>
     * If the connection <b>is</b> successful it will create the DAO's and Tables.
     */
    
    public DatabaseController(ConnectionSource connectionSource) throws SQLException{
    	this.connectionSource = new JdbcConnectionSource();
    	this.connectionSource = connectionSource;
    	
    	createDAOS();
    	createTables(); 
    }
    
    protected void createTables() throws SQLException {
    	//Create tables if they don't exist.
    	//TableUtils.dropTable(connectionSource, Student.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Student.class);
        //TableUtils.dropTable(connectionSource, Assignment.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Assignment.class);
        //TableUtils.dropTable(connectionSource, Course.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Course.class);
        //TableUtils.dropTable(connectionSource, Employee.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Employee.class);
        //TableUtils.dropTable(connectionSource, Person.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Person.class);
        //TableUtils.dropTable(connectionSource, Submission.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Submission.class);
        //TableUtils.dropTable(connectionSource, Teacher.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Teacher.class); 		
	}

	protected void createDAOS() throws SQLException{
    	//Create DAO's.
        studentDao = DaoManager.createDao(connectionSource, Student.class);        
        assignmentDao = DaoManager.createDao(connectionSource, Assignment.class);        
        courseDao = DaoManager.createDao(connectionSource, Course.class);
        employeeDao = DaoManager.createDao(connectionSource, Employee.class);
        personDao = DaoManager.createDao(connectionSource, Person.class);
        teacherDao = DaoManager.createDao(connectionSource, Teacher.class);
    }
}
