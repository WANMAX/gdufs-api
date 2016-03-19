/**
 * 
 */
package entity;

/**
 * @author wan
 *
 */
public class News extends Serializable {
	private String date;
    private String title;
    private String url;
	@Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		if(name.equals("date"))
			date = value.toString();
		else if(name.equals("title"))
			title = value.toString();
		else if(name.equals("url"))
			url = value.toString();
	}
	@Override
	public String toString() {
		return "News [date=" + date + ", title=" + title + ", url=" + url + "]";
	}
	public String getDate() {
		return date;
	}
	public String getTitle() {
		return title;
	}
	public String getUrl() {
		return url;
	}
}
