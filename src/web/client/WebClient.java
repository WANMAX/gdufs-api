/**
 * 
 */
package web.client;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalDate;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class WebClient {
	public static final String NAMESPACE = "gdufs.service";
	public static final String WSDLURL = "http://4304e92d.nat123.net:24110/?wsdl";
	//public static final String WSDLURL = "http://127.0.0.1:8000/?wsdl";
	
	public static Object baseCall(SoapObject request) throws UnfinishedException {
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = false;
		new MarshalDate().register(envelope);
		envelope.bodyOut = request;
		HttpTransportSE ht = new HttpTransportSE(
				WSDLURL);
		try {
			ht.call(null, envelope);
		} catch (Exception e){
			if (e.getMessage().equals("HTTP request failed, HTTP status: 500"));
				throw new UnfinishedException();
		}
		return ((SoapObject)envelope.bodyIn).getProperty(0);
	}
}
