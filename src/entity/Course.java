/**
 * 
 */
package entity;

/**
 * @author wan
 *
 */
public class Course extends Serializable {
    private String courseName;
	private String teacherName;
	private String place;
	private int startTime;
	private int numb = 1;
	
	private String memorandum = "";
	private String teacherPhone;
	private String teacherEmail;
	public Course(){}
	public Course(int startTime){this.startTime = startTime;}
	public Course(String courseName, String teacherName, String place, int startTime, int numb, String memorandum,
			String teacherPhone, String teacherEmail) {
		super();
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.place = place;
		this.startTime = startTime;
		this.numb = numb;
		this.memorandum = memorandum;
		this.teacherPhone = teacherPhone;
		this.teacherEmail = teacherEmail;
	}
	
	 @Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		 if(name.equals("course_name"))
			 courseName = value.toString();
		else if(name.equals("teacher_name"))
			teacherName = value.toString();
		else if(name.equals("place"))
			place = value.toString();
		else if(name.equals("start_time"))
			startTime = Integer.parseInt(value.toString());
		else if(name.equals("numb"))
			numb = Integer.parseInt(value.toString());
	}

	public String getCourseName() {
		return courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getPlace() {
		return place;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getNumb() {
		return numb;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", teacherName=" + teacherName + ", place=" + place + ", startTime="
				+ startTime + ", numb=" + numb + "]";
	}

	public String getMemorandum() {
		return memorandum;
	}

	public void setMemorandum(String memorandum) {
		this.memorandum = memorandum;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}
}
