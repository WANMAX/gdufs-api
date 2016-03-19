/**
 * 
 */
package entity;

/**
 * @author wan
 *
 */
public class CETScore extends Serializable{
	private String year;
	private String term;
	private String examinationName;
	private String examineeNumber;
	private String date;
	private String score;
	private String listeningScore;
	private String readingScore;
	private String writingScore;
	private String comprehensiveScore;
	
	@Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		if(name.equals("year"))
			year = value.toString();
		else if(name.equals("term"))
			term = value.toString();
		else if(name.equals("examination_name"))
			examinationName = value.toString();
		else if(name.equals("examinee_number"))
			examineeNumber = value.toString();
		else if(name.equals("date"))
			date = value.toString();
		else if(name.equals("score"))
			score = value.toString();
		else if(name.equals("listening_score"))
			listeningScore = value.toString();
		else if(name.equals("reading_score"))
			readingScore = value.toString();
		else if(name.equals("writing_score"))
			writingScore = value.toString();
		else if(name.equals("comprehensive_score"))
			comprehensiveScore = value.toString();
	}

	public String getYear() {
		return year;
	}

	public String getTerm() {
		return term;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public String getExamineeNumber() {
		return examineeNumber;
	}

	public String getDate() {
		return date;
	}

	public String getScore() {
		return score;
	}

	public String getListeningScore() {
		return listeningScore;
	}

	public String getReadingScore() {
		return readingScore;
	}

	public String getWritingScore() {
		return writingScore;
	}

	public String getComprehensiveScore() {
		return comprehensiveScore;
	}

	@Override
	public String toString() {
		return "CETScore [year=" + year + ", term=" + term + ", examinationName=" + examinationName
				+ ", examineeNumber=" + examineeNumber + ", date=" + date + ", score=" + score + ", listeningScore="
				+ listeningScore + ", readingScore=" + readingScore + ", writingScore=" + writingScore
				+ ", comprehensiveScore=" + comprehensiveScore + "]";
	}
}
