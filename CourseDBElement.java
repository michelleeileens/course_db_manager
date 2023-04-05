public class CourseDBElement implements Comparable {

	protected String id;
	protected int crn;
	protected int credit;
	protected String roomNum;
	protected String instructor;
	
	public CourseDBElement() {
		this(null, 00000, 0, null, null);
	}

	public CourseDBElement(String id, int crn, int credit, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credit = credit;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	public int getCRN() {
		return crn;
	}
	
	@Override
	public int compareTo(CourseDBElement element) {
		if(element.crn == crn)
			return 0;
		else if(element.crn < crn)
			return -1;
		return 1;
	}
	
	public int hashCode() {
		String crn1 = Integer.toString(crn);
		return crn1.hashCode();
	}
	
	public String getID() {
		return id;
	}
	
	public String getRoomNum() {
		return roomNum;
	}

	public String toString() {
		return "Course:" + id + " CRN:" + crn + " Credits:" + credit + " Instructor:" 
				+ instructor + " Room:" + roomNum;
	}

}