/**
 * 
 */
package entity;

/**
 * @author wan
 *
 */
public class Score extends Serializable {
    private String courseId;
    private String courseName;
    private String type1;
    private String type2;
    private String credit;
    private String gradePoint;
    private String normalPerformance;
    private String npAccountFor;
    private String finalExamScore;
    private String fesAccountFor;
    private String score;
    
	@Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		if(name.equals("course_id"))
			courseId = value.toString();
		if(name.equals("course_name"))
			courseName = value.toString();
		else if(name.equals("type1"))
			type1 = value.toString();
		else if(name.equals("type2"))
			type2 = value.toString();
		else if(name.equals("credit"))
			credit = value.toString();
		else if(name.equals("grade_point"))
			gradePoint = value.toString();
		else if(name.equals("normal_performance"))
			normalPerformance = value.toString();
		else if(name.equals("np_account_for"))
			npAccountFor = value.toString();
		else if(name.equals("final_exam_score"))
			finalExamScore = value.toString();
		else if(name.equals("fes_account_for"))
			fesAccountFor = value.toString();
		else if(name.equals("score"))
			score = value.toString();
	}

	@Override
	public String toString() {
		return "Score [courseId=" + courseId + ", courseName=" + courseName + ", type1=" + type1 + ", type2=" + type2
				+ ", credit=" + credit + ", gradePoint=" + gradePoint + ", normalPerformance=" + normalPerformance
				+ ", npAccountFor=" + npAccountFor + ", finalExamScore=" + finalExamScore + ", fesAccountFor="
				+ fesAccountFor + ", score=" + score + "]";
	}

	public String getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	public String getCredit() {
		return credit;
	}

	public String getGradePoint() {
		return gradePoint;
	}

	public String getNormalPerformance() {
		return normalPerformance;
	}

	public String getNpAccountFor() {
		return npAccountFor;
	}

	public String getFinalExamScore() {
		return finalExamScore;
	}

	public String getFesAccountFor() {
		return fesAccountFor;
	}

	public String getScore() {
		return score;
	}
}
