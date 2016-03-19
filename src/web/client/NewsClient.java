/**
 * 
 */
package web.client;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.ksoap2.serialization.SoapObject;

import entity.News;
import entity.Serializable;
import exception.UnfinishedException;

/**
 * @author wan
 *
 */
public class NewsClient {
	private static int currentPage = 0;
	
	private static ArrayList<News> getNews() throws UnfinishedException{
		SoapObject request = new SoapObject(WebClient.NAMESPACE, "crawl_news");
		request.addProperty("page", currentPage);
		ArrayList<News> list = new ArrayList<News>();
		SoapObject result = (SoapObject) WebClient.baseCall(request);
		for (int i = 0; i < result.getPropertyCount(); i++) {
			list.add(Serializable.setFromSoap((SoapObject) result.getProperty(i), new News()));
		}
		return list;
	}
	
	private static Lock lock = new ReentrantLock();
	public static ArrayList<News> getNewsFirstPage() throws UnfinishedException{
		lock.lock();
		currentPage = 1;
		ArrayList<News> temp = null;
		try{
			temp = getNews();
			return temp;
		} finally{
			lock.unlock();
		}
	}
	public static ArrayList<News> getNewsNextPage() throws UnfinishedException{
		lock.lock();
		currentPage += 1;
		ArrayList<News> temp = null;
		try{
			temp = getNews();
			return temp;
		} finally{
			lock.unlock();
		}
	}
}
