package studentDB;

import java.sql.*;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DBDemo
{
  // The JDBC Connector Class.
  private static final String dbClassName = "com.mysql.jdbc.Driver";
  static Statement stmt;
  static Connection con;



  private static final String CONNECTION ="jdbc:mysql://127.0.0.1/students";

/*
  public static void main(String[] args) throws  ClassNotFoundException,SQLException 
                            
  {
	  
	  getConnection();
	  addTableUI();
   

    }
  
  */
  
  public static void closeConnection() throws SQLException{
	
  }
  
  public static void createStudents(){
	  Connection con=getConnection();
	  String sql_create="create table Students ( s_name INT , s_id int PRIMARY KEY, m1 int, m2 int, m3 int, total int )";
	  
	  try{
		  stmt=con.createStatement();
		  stmt.executeUpdate(sql_create);
		  stmt.close();
		  con.close();
	  }
	  catch(SQLException e){
		  e.printStackTrace();
	  }
	  
	  JOptionPane.showMessageDialog(null, "Student table created successfully");
	  
  }
  
  public static void addTableUI(){
	  JFrame frame1 = new JFrame();
		EntryList panel=new EntryList();
		frame1.getContentPane().add(panel);
		frame1.pack();
		frame1.setVisible(true);
  }
  
  
  
  public static Connection getConnection()  {
	  System.out.println(dbClassName);
	    // Class.forName(xxx) loads the jdbc classes and
	    // creates a drivermanager class factory
	  
	  try{
	    Class.forName(dbClassName);
	  }
	  
	  catch(ClassNotFoundException e){
		  e.printStackTrace();
	  }
	    
	    

	    // Properties for user and password. Here the user and password are both 'paulr'
	    Properties p = new Properties();
	    p.put("user","akshaya");
	    p.put("password","don");

	    try{
	    // Now try to connect
	    con = DriverManager.getConnection(CONNECTION,p);
	    }
	    
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
	    System.out.println("It works !");
	    return con;
	   // Statement statement=c.createStatement();
	    
	  
  }
}