import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	protected int sizeOfHash = 0;
	protected int elementSize = 0;
	protected LinkedList[] hashTable;
	
	public CourseDBStructure(int size) {
		sizeOfHash = size;
		hashTable = new LinkedList[sizeOfHash];
	}
	
	public CourseDBStructure(String testing,int size) {
		sizeOfHash = size;
		hashTable = new LinkedList[sizeOfHash];
	}
	
	@Override
	public void add(CourseDBElement element) {
		int code;
		code = Math.abs(element.hashCode())% sizeOfHash;
		LinkedList<CourseDBElement> thisList = hashTable[code];
		if(thisList == null)
			hashTable[code] = new LinkedList<CourseDBElement>();
		hashTable[code].add(element);
		elementSize++;
	}
	
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String crn1 = Integer.toString(crn);
		int code = Math.abs(crn1.hashCode()) % sizeOfHash;
		if(hashTable[code] == null) 
			throw new IOException();
		else
			return (CourseDBElement) hashTable[code].get(0);
	}
	
	@Override
	public int getTableSize() {
		return sizeOfHash;
	}
	
	public ArrayList<String> showAll() {
		ArrayList<String> al = new ArrayList<String>();
		for(int i = 0; i < sizeOfHash; i++) {
			while(hashTable[i] != null) {
				for(int j = 0; j < hashTable[i].size(); j++) {
					CourseDBElement element = (CourseDBElement) hashTable[i].get(j);
					al.add("\n"+element.toString());
				}
				break;
			}
		}
		return al;
	}
}
