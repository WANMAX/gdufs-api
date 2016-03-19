/**
 * 
 */
package entity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author wan
 *
 */
public class Information extends Serializable {
    private String name;
    private String photoUrl;
    private byte[] photo = null;
    private String identity;
    private String academy;
    
	@Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		if(name.equals("name"))
			this.name = value.toString();
		else if(name.equals("photo_url"))
			photoUrl = value.toString();
		else if(name.equals("identity"))
			identity = value.toString();
		else if(name.equals("academy"))
			academy = value.toString();
	}

	@Override
	public String toString() {
		return "Information [name=" + name + ", photoUrl=" + photoUrl + ", identity=" + identity + ", academy="
				+ academy + "]";
	}

	public String getName() {
		return name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}
	public byte[] getPhoto() throws MalformedURLException, IOException {
		if(photo != null)
			return photo;
        InputStream in = null;
        BufferedInputStream input = null;
        try{
        	ArrayList<Byte> temp = new ArrayList<Byte>();
            in = new URL(photoUrl).openConnection().getInputStream();
            input = new BufferedInputStream(in);
            byte[] bs = new byte[1024];
            int len=0;
            while((len=input.read(bs))!=-1){
            	for(int i = 0;i < len;i++)
            		temp.add(bs[i]);
            }
            photo = new byte[temp.size()];
            for(int i = 0;i < temp.size();i++)
            	photo[i] = temp.get(i);
        }
        finally{
            if(input!=null)input.close();
            if(in!=null)in.close();
        }
		return photo;
	}

	public String getIdentity() {
		return identity;
	}

	public String getAcademy() {
		return academy;
	}
}
