/**
 * 
 */
package web.client;

import java.util.ArrayList;

import org.ksoap2.serialization.SoapObject;

import entity.CETScore;
import entity.Serializable;
import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class CETScoreClient {
	public static ArrayList<CETScore> getCETScore(String cookie, String studentNumber) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_CET_score");
		request.addProperty("cookie", cookie);
		request.addProperty("student_number", studentNumber);
		ArrayList<CETScore> list = new ArrayList<CETScore>();
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		for (int i = 0; i < result.getPropertyCount(); i++) {
			list.add(Serializable.setFromSoap((SoapObject) result.getProperty(i), new CETScore()));
		}
		return list;
	}
}
