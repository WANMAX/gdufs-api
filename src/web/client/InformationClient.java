/**
 * 
 */
package web.client;

import org.ksoap2.serialization.SoapObject;

import entity.Information;
import entity.Serializable;
import exception.LoginFailedException;
import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class InformationClient {
	public static Information getInformation(String cookie) throws UnfinishedException {
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_information");
		request.addProperty("cookie", cookie);
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		return Serializable.setFromSoap(result, new Information());
	}
	public static void main(String[] args) throws UnfinishedException, LoginFailedException {
		Information info = getInformation(LoginClient.login("20131003502", "13421573145"));
		System.out.println(info);
	}
}
