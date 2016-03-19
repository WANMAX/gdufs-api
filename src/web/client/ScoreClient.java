/**
 * 
 */
package web.client;

import java.util.ArrayList;

import org.ksoap2.serialization.SoapObject;

import entity.Score;
import entity.Serializable;
import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class ScoreClient {
	public static ArrayList<Score> getScore(String cookie, String studentNumber, String year, String term) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_score");
		request.addProperty("cookie", cookie);
		request.addProperty("student_number", studentNumber);
		request.addProperty("year", year);
		request.addProperty("term", term);
		ArrayList<Score> list = new ArrayList<Score>();
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		for (int i = 0; i < result.getPropertyCount(); i++) {
			list.add(Serializable.setFromSoap((SoapObject)result.getProperty(i), new Score()));
		}
		return list;
	}
}
