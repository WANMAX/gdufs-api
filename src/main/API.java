/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import entity.Account;
import entity.CETScore;
import entity.Course;
import entity.Information;
import entity.News;
import entity.Score;
import entity.Weather;
import entity.YKTInformation;
import exception.LoginFailedException;
import exception.NotLoggedException;
import exception.UnfinishedException;
import exception.YKTActionFailedException;
import web.client.AnnouncementClient;
import web.client.CETScoreClient;
import web.client.CourseClient;
import web.client.InformationClient;
import web.client.LoginClient;
import web.client.NewsClient;
import web.client.ScoreClient;
import web.client.WeatherClient;
import web.client.YKTClient;

/**
 * @author wan
 * 
 */
public class API {
	private final static int timeInterval = 43200000;
	private Lock lock = new ReentrantLock();

	private String cookie;
	private String cookie_jw;
	private String usernameBackup, passwordBackup;
	private long loginTime;
	private Information information;
	
	private static class InstanceContainer {private static API instance = new API();}
	private API() {};
	public static API getInstance() {
		return InstanceContainer.instance;
	}

	private boolean isLogged = false;
	public boolean isLogged() {
		lock.lock();
		lock.unlock();
		return isLogged;
	}
	public void Login(String username, String password) throws LoginFailedException, UnfinishedException {
		lock.lock();
		try {
			usernameBackup = username;
			passwordBackup = password;
			cookie = LoginClient.login(username, password);
			cookie_jw = LoginClient.login_jw(username, password);
			loginTime = System.currentTimeMillis();
			isLogged = true;
		} finally {
			lock.unlock();
		}
	}
	public void logoff() {
		lock.lock();
		isLogged = false;
		cookie = null;
		cookie_jw = null;
		information = null;
		lock.unlock();
	}
	private void delay() throws NotLoggedException, UnfinishedException {
		lock.lock();
		try {
			if (isLogged == false)
				throw new NotLoggedException();
			else if (new Date().after(new Date(loginTime
					+ timeInterval))) {
				cookie = LoginClient.login(usernameBackup, passwordBackup);
				cookie_jw = LoginClient.login_jw(usernameBackup, passwordBackup);
			}
		} catch(LoginFailedException e){
			isLogged = false;
			cookie = null;
			cookie_jw = null;
			information = null;
			throw new NotLoggedException();
		} finally {
			lock.unlock();
		}
	}
	public void clear() {
		information = null;
	}

	public String getStudentNumber() throws NotLoggedException {
		if(!isLogged)
			throw new NotLoggedException();
		else
			return usernameBackup;
	}
	public Information getInformation() throws NotLoggedException, UnfinishedException {
		delay();
		if(information != null)
			return information;
		return information = InformationClient.getInformation(cookie);
	}
	public ArrayList<CETScore> getCETScore() throws NotLoggedException, UnfinishedException {
		delay();
		return CETScoreClient.getCETScore(cookie_jw, usernameBackup);
	}
	public ArrayList<Course>[] getCourse(String year, String term) throws NotLoggedException, UnfinishedException {
		delay();
		return CourseClient.getCourse(cookie_jw, usernameBackup, year, term);
	}
	public ArrayList<Score> getScore(String year, String term) throws NotLoggedException, UnfinishedException {
		delay();
		return ScoreClient.getScore(cookie_jw, usernameBackup, year, term);
	}
	public ArrayList<News> getNewsFirstPage() throws UnfinishedException {
		return NewsClient.getNewsFirstPage();
	}
	public ArrayList<News> getNewsNextPage() throws UnfinishedException {
		return NewsClient.getNewsNextPage();
	}
	public ArrayList<News> getAnnouncementFirstPage() throws UnfinishedException {
		return AnnouncementClient.getAnnouncementFirstPage();
	}
	public ArrayList<News> getAnnouncementNextPage() throws UnfinishedException {
		return AnnouncementClient.getAnnouncementNextPage();
	}
	public ArrayList<Weather> getWeather() throws UnfinishedException{
		return WeatherClient.getWeather();
	}
	public YKTInformation getYKTInformation() throws NotLoggedException, UnfinishedException {
		delay();
		return YKTClient.getYKTInformation(cookie);
	}
	public ArrayList<Account> getTodayAccount() throws NotLoggedException, UnfinishedException {
		delay();
		return YKTClient.getTodayAccount(cookie);
	}
	public ArrayList<Account> getHistoryAccount(String startDay, String endDay) throws NotLoggedException, UnfinishedException {
		delay();
		return YKTClient.getHistoryAccount(cookie, startDay, endDay);
	}
	public void recharge(int money, String password) throws NotLoggedException, YKTActionFailedException, UnfinishedException{
		delay();
		if(!YKTClient.recharge(cookie, money, password))
			throw new YKTActionFailedException("recharge failed");
	}
	public byte[] getPasswordImage() throws NotLoggedException, LoginFailedException, UnfinishedException{
		delay();
		return YKTClient.getPasswordImage(cookie);
	}
	public void modifyPassword(String oldPassword, String newPassword) throws NotLoggedException, YKTActionFailedException, UnfinishedException{
		delay();
		if(!YKTClient.modifyPassword(cookie, oldPassword, newPassword))
			throw new YKTActionFailedException("modyfy password failed");
	}
	public void reportLoss(String Password) throws NotLoggedException, YKTActionFailedException, UnfinishedException{
		delay();
		if(!YKTClient.reportLoss(cookie, Password))
			throw new YKTActionFailedException("report loss failed");
	}
	public static void main(String[] args) throws UnfinishedException {
		for(Weather w:API.getInstance().getWeather())
			System.out.println(w.toString());
	}
}
