import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManagerTest_Student {
	private CourseDBManager db = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		db = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		db = null;
	}

	@Test
	public void testAddToDB() {
		try {
			db.add("POLI203",56728,3,"Remote","William Primosch");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	public void testShowAll() {
		db.add("CMSC141",45608,1,"Distance-Learning","Ping.We Tsai");
		db.add("SOCY100",56728,3,"HU120","Emerald Jones");
		db.add("POLI203",98287,4,"SC361","Valerie Pierce");
		db.add("MATH182",83467,3,"SW215","Jack Kent");
		ArrayList<String> list = db.showAll();
		
  		assertEquals(list.get(0),"\nCourse:SOCY100 CRN:56728 Credits:3 Instructor:Emerald Jones Room:HU120");
  		assertEquals(list.get(1),"\nCourse:CMSC141 CRN:45608 Credits:1 Instructor:Ping.We Tsai Room:Distance-Learning");
		assertEquals(list.get(2),"\nCourse:POLI203 CRN:98287 Credits:4 Instructor:Valerie Pierce Room:SC361");
		assertEquals(list.get(3),"\nCourse:MATH182 CRN:83467 Credits:3 Instructor:Jack Kent Room:SW215");
	}

	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("MATH182 83467 3 SW215 Jack Kent");
			inFile.print("POLI203 98287 4 SC361 Valerie Pierce");
			
			inFile.close();
			db.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	
	@Test
	public void testGet() {
		CourseDBElement cde=new CourseDBElement("POLI203",98287,4,"SC361","Valerie Pierce");
		CourseDBElement cde1=new CourseDBElement("CMSC141",45608,1,"Distance-Learning","Ping.We Tsai");
		db.add("POLI203",98287,4,"SC361","Valerie Pierce");
		db.add("CMSC141",45608,1,"Distance-Learning","Ping.We Tsai");
		assertEquals(0,db.get(98287).compareTo(cde));
		assertEquals(0,db.get(45608).compareTo(cde1));	
	}
}

