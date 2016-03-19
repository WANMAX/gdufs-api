/**
 * 
 */
package web.client;

import java.util.ArrayList;

import org.ksoap2.serialization.SoapObject;

import entity.Serializable;
import entity.Weather;
import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class WeatherClient {
	public static ArrayList<Weather> getWeather() throws UnfinishedException {
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_weather");
		ArrayList<Weather> list = new ArrayList<Weather>();
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		for (int i = 0; i < result.getPropertyCount(); i++) {
			list.add(Serializable.setFromSoap((SoapObject) result.getProperty(i), new Weather()));
		}
		return list;
	}
}
