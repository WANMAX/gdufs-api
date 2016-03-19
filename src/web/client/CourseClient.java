/**
 * 
 */
package web.client;

import java.util.ArrayList;

import org.ksoap2.serialization.SoapObject;

import entity.Course;
import entity.Serializable;
import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class CourseClient {
	public static ArrayList<Course>[] getCourse(String cookie, String studentNumber, String year, String term) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_course");
		request.addProperty("cookie", cookie);
		request.addProperty("student_number", studentNumber);
		request.addProperty("year", year);
		request.addProperty("term", term);
		ArrayList<Course>[] list = new ArrayList[7];
		for(int x=0;x<7;x++){
			list[x]=new ArrayList<Course>();
		}
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		for (int i = 0; i < 7; i++) {
			SoapObject so = (SoapObject) result.getProperty(i);
			for (int j = 0; j < so.getPropertyCount(); j++) {
				list[i].add(Serializable.setFromSoap((SoapObject)so.getProperty(j), new Course()));
			}
		}
		return list;
	}
	public static void main(String[] args) throws Exception {
		String cookie = LoginClient.login_jw("20131003502", "13421573145");
		System.out.println(cookie);
		int count = 0;
		for (ArrayList<Course> cs : getCourse(cookie, "20131003502", "2015-2016", "1")) {
			count += 1;
			System.out.println(count);
			for (Course c : cs) {
				System.out.println(c);
			}
		}
	}
}
