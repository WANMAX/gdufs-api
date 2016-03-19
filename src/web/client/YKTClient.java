package web.client;

import java.util.ArrayList;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import entity.Account;
import entity.Serializable;
import entity.YKTInformation;
import exception.UnfinishedException;

public class YKTClient {
	public static YKTInformation getYKTInformation(String cookie) throws UnfinishedException {
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_ykt_information");
		request.addProperty("cookie", cookie);
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		return Serializable.setFromSoap(result, new YKTInformation());
	}
	public static ArrayList<Account> getTodayAccount(String cookie) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_today_account");
		request.addProperty("cookie", cookie);
		ArrayList<Account> list = new ArrayList<Account>();
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		for (int i = 0; i < result.getPropertyCount(); i++) {
			list.add(Serializable.setFromSoap((SoapObject) result.getProperty(i), new Account()));
		}
		return list;
	}
	public static ArrayList<Account> getHistoryAccount(String cookie, String startDay, String endDay) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_history_account");
		request.addProperty("cookie", cookie);
		request.addProperty("start_day", startDay);
		request.addProperty("end_day", endDay);
		ArrayList<Account> list = new ArrayList<Account>();
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		for (int i = 0; i < result.getPropertyCount(); i++) {
			list.add(Serializable.setFromSoap((SoapObject) result.getProperty(i), new Account()));
		}
		return list;
	}
	public static Boolean recharge(String cookie, int money, String password) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "recharge");
		request.addProperty("cookie", cookie);
		request.addProperty("money", money);
		request.addProperty("password", password);
		SoapPrimitive result = (SoapPrimitive) WebClient.baseCall(request);
		return Boolean.parseBoolean(String.valueOf(result));
	}
	public static byte[] getPasswordImage(String cookie) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "get_password_image");
		request.addProperty("cookie", cookie);
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		byte[] bs = new byte[result.getPropertyCount()];
		for (int i = 0; i < result.getPropertyCount(); i++) {
			bs[i]=(byte)Integer.parseInt(String.valueOf(result.getProperty(i)));
		}
		return bs;
	}
	public static Boolean modifyPassword(String cookie, String oldPassword, String newPassword) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "modify_password");
		request.addProperty("cookie", cookie);
		request.addProperty("old_password", oldPassword);
		request.addProperty("new_password", newPassword);
		SoapPrimitive result = (SoapPrimitive) WebClient.baseCall(request);
		return Boolean.parseBoolean(String.valueOf(result));
	}
	public static Boolean reportLoss(String cookie, String password) throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "report_loss");
		request.addProperty("cookie", cookie);
		request.addProperty("password", password);
		SoapPrimitive result = (SoapPrimitive) WebClient.baseCall(request);
		return Boolean.parseBoolean(String.valueOf(result));
	}
}
