/**
 * 
 */
package entity;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

/**
 * @author wan
 *
 */
abstract public class  Serializable{
	public static <T extends Serializable> T setFromSoap(SoapObject so, T wo){
		PropertyInfo temp = new PropertyInfo();
		for(int i = 0;i<so.getPropertyCount();i++){
			so.getPropertyInfo(i, temp);
			wo.setProperty(temp.getName(), so.getProperty(i));
		}
		return wo;
	}
	abstract protected void setProperty(String name, Object value);
}
