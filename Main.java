/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Onika11
 */
package javafxswingapplication1;
import java.util.List;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

  

public class Main extends Application {
	   static final String USER = "root";
	   static final String PASS = "Augie_562";
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/procyed";
	   
	Stage primaryStage = new Stage();
	//buttons for interaction
	@FXML
	private Button Login;
	@FXML
	private Button showMessaging;
	@FXML
	private Button showProfile;
	@FXML
	private Button showSearchForJob;
	@FXML
	private Button showRecruiterHome;
	@FXML
	private Button showRegistration;
	@FXML
	private Button showStudentHome;
	@FXML
	private Button showTeacherHome;
	@FXML
	private Button showPostJob;
	@FXML
	private Button postJob;
	@FXML
	private Button showTest;
	@FXML
	private Button showAssignTest;
	@FXML
	private Button showLesson;
	@FXML
	private Button showSearchForStudent;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	static Connection conn = null;

	public static void main(String[] args) {
		//launch(args);
		run();
                 
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(550, 300));
      frame.getContentPane().setBackground(Color.BLUE);
      frame.pack();
      frame.setVisible(true);
     }
	
	   static final String user = "root";
	   static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB__URL = "jdbc:mysql://144.75.130.41:3306/procyed";
	   
	   public static void run() {
		   Statement stmt = null;
		   try{
			  conn = DriverManager.getConnection(DB_URL,USER,PASS);

			  System.out.println("Certifications\tWillem Sciandra");
		      queryForUser("'Willem Sciandra'", "procyed.certifications");
		      System.out.println("\n\nJobs\tWillem Sciandra");
		      queryForUser("'Willem Sciandra'", "procyed.jobs");
//	
		      System.out.println("\n\n\nCertifications\tOnika Hammond \n________________________");
		      queryForUser("'Onika Hammond'", "procyed.certifications");
		      System.out.println("\n\nJobs\tOnika Hammond");
		      queryForUser("'Onika Hammond'", "procyed.jobs");
//		      
		      System.out.println("\n\n\nCertifications\tTim Bedford \n________________________");
		      queryForUser("'Tim Bedford'", "procyed.certifications");
		      System.out.println("\n\nJobs\tTim Bedford");
		      queryForUser("'Onika Hammond'", "procyed.jobs");
		      
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){}
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	
	public static String queryForUser(String id, String topic){//, Connection conn) {
		  Statement stmt = null;
	      try {
		      stmt = conn.createStatement();
		      String sql = "SELECT level FROM student WHERE Name = " + id;
		      ResultSet rs = stmt.executeQuery(sql);
		      rs.next();
		      int level = (rs.getInt("level"));
		      stmt.close();
			  stmt = conn.createStatement();
			  sql = "SELECT * FROM " + topic + " WHERE level = " + level;
			  rs = stmt.executeQuery(sql);
			      

			  while(rs.next()) {
				  System.out.println();
				  for(int x = 0; x < 5; x++)
					  try {
						  	System.out.print(rs.getString(x) + "\t");
					  }catch(Exception e) {}
			  }

	      }
		catch(Exception e) {
			e.printStackTrace();
		}

		return "";
		
	}
	
	public static List<String> neededCoursesByJob(String username, String jobID){
		
//				userskills = sql.query(username).parseSkills()
//				jobSkills = sql.query(usebID).parseSkills()
//				for(String skill : jobSkills) {
//					if(skill not in userSkills) {
//						missingSkills.add(skill)						
//					}
//				}
//				return sql.query(missingSkills)
			return null;
	}
	
	public static List<String> getMessages(String username){
		
//		messages = sql.queryMessages(username);
//		return messages;
		return null;
	}
	
	
	
	public void start(Stage stage) throws Exception {
		//primaryStage = stage;
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		//grid.setPadding(new Insets(25, 25, 25, 25));
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		primaryStage.show();
		showLogin();		
	}

	private Parent replaceSceneContent(String fxml) throws Exception {
		Parent page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
		this.primaryStage.setScene(new Scene(page));
		this.primaryStage.show();
		return page;
	}
	
	@FXML
	public boolean login() throws Exception{
		if(username.getText().equals("student")) {
			
				showStudentHome();
				return true;
			
		}
		else if(username.getText().equals("teacher")) {
			//if(username.getText().equals(password.getText())) {
				showTeacherHome();
				return true;
			//}
		}
		else if(username.getText().equals("recruiter")) {
			//if(username.getText().equals(password.getText())) {
				showRecruiterHome();
				return true;
			//}
		}
		
		return false;
	}
	
	@FXML
	public void showLesson() throws Exception {System.out.println("Lesson");replaceSceneContent("Lesson.fxml");}
	@FXML
	public void showLogin() throws Exception {
		this.primaryStage.getScene().getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		replaceSceneContent("Login.fxml");}
	@FXML
	public void showMessaging() throws Exception {replaceSceneContent("Messaging.fxml");}
	@FXML
	public void showProfile() throws Exception {replaceSceneContent("Profile.fxml");}
	@FXML
	public void showRecruiterHome() throws Exception {replaceSceneContent("RecruiterHome.fxml");}
	@FXML
	public void showRegistration() throws Exception {replaceSceneContent("Registration.fxml");}
	@FXML
	public void showStudentHome() throws Exception {replaceSceneContent("StudentHome.fxml");}
	@FXML
	public void showTeacherHome() throws Exception {replaceSceneContent("TeacherHome.fxml");}
	@FXML
	public void showTest() throws Exception {replaceSceneContent("Test.fxml");}
	@FXML
	public void showPostJob() throws Exception {replaceSceneContent("PostJob.fxml");}
	@FXML
	public void showAssignTest() throws Exception {replaceSceneContent("AssignTest.fxml");}
	@FXML
	public void showSearchForStudent() throws Exception {replaceSceneContent("SearchForStudent.fxml");}
	@FXML
	public void showSearchForJob() throws Exception {replaceSceneContent("SearchForJob.fxml");}
}
