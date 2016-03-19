/**
 * 
 */
package web.client;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import exception.LoginFailedException;
import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class LoginClient {
	public static String login(String username, String password) throws LoginFailedException, UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "login");
		request.addProperty("username", username);
		request.addProperty("password", password);
		try{
			SoapPrimitive result = (SoapPrimitive)WebClient.baseCall(request);
			return String.valueOf(result);
		} catch(UnfinishedException ex) {
			throw new UnfinishedException();
		} catch(Exception ex){
			throw new LoginFailedException();
		}
	}
	public static String login_jw(String username, String password) throws LoginFailedException, UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "login_jw");
		request.addProperty("username", username);
		request.addProperty("password", password);
		try{
			SoapPrimitive result = (SoapPrimitive)WebClient.baseCall(request);
			return String.valueOf(result);
		} catch(UnfinishedException ex) {
			throw new UnfinishedException();
		} catch(Exception ex){
			ex.printStackTrace();
			throw new LoginFailedException();
		}
	}
}
