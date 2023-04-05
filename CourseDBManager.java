import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	CourseDBStructure cds = new CourseDBStructure(20);

	@Override
	public void add(String id, int crn, int credit, String roomNum, String instructor){
		CourseDBElement cde = new CourseDBElement(id,crn,credit,roomNum,instructor);
		cds.add(cde);
	}
	
	@Override
	public CourseDBElement get(int crn){
		try {
			return cds.get(crn);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException{
		Scanner in = new Scanner(input);
		int credit, crn;
		CourseDBElement cde;
		String courses;
		String[] array;
		while (in.hasNextLine()) {
			courses = in.nextLine();
			array = courses.split(" ",5);
			crn = Integer.parseInt(array[1]);
			credit = Integer.parseInt(array[2]);
			cde = new CourseDBElement(array[0],crn,credit,array[3],array[4]);
			cds.add(cde);
		}
	}

	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}	
}