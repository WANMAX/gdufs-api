/**
 * 
 */
package entity;

/**
 * @author wan
 *
 */
public class Weather extends Serializable {
	private String week;
	private String date;
	private String weather;
    private String highestTemperature;
    private String lowestTemperature;
    private String wind;
	@Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		if(name.equals("week"))
			week = value.toString();
		else if(name.equals("date"))
			date = value.toString();
		else if(name.equals("weather"))
			weather = value.toString();
		else if(name.equals("highest_temperature")){
			String temp = value.toString();
			if(temp.equals("anyType{}"))
				temp = "";
			highestTemperature = temp;
		}
		else if(name.equals("lowest_temperature")){
			String temp = value.toString();
			if(temp.equals("anyType{}"))
				temp = "";
			lowestTemperature = temp;
		}
		else if(name.equals("wind"))
			wind = value.toString();
	}
	@Override
	public String toString() {
		return "Weather [week=" + week + ", date=" + date + ", weather=" + weather + ", highestTemperature="
				+ highestTemperature + ", lowestTemperature=" + lowestTemperature + ", wind=" + wind + "]";
	}
	public String getWeek() {
		return week;
	}
	public String getDate() {
		return date;
	}
	public String getWeather() {
		return weather;
	}
	public String getHighestTemperature() {
		return highestTemperature;
	}
	public String getLowestTemperature() {
		return lowestTemperature;
	}
	public String getWind() {
		return wind;
	}
}
