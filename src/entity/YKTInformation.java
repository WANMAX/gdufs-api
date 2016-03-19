/**
 * 
 */
package entity;

/**
 * @author wan
 *
 */
public class YKTInformation extends Serializable {
	public static final int NORMAL = 0;
	public static final int FREEZE = 1;
	
	private String id;
	private int state;
	private float balance;
	private float transitionBalance;
	@Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		if(name.equals("id"))
			id = value.toString();
		if(name.equals("state"))
			state = Integer.parseInt(value.toString());
		else if(name.equals("balance"))
			balance = Float.parseFloat(value.toString());
		else if(name.equals("transition_balance"))
			transitionBalance = Float.parseFloat(value.toString());
	}
	public int getStateCode() {
		return state;
	}
	public String getStateName(){
		String temp;
		switch(state){
		case NORMAL:
			temp = "正常";
			break;
		case FREEZE:
			temp = "冻结";
			break;
		default:
			temp = "出错";
		}
		return temp;
	}
	public String getID(){
		return id;
	}
	public float getBalance() {
		return balance;
	}
	public float getTransitionBalance() {
		return transitionBalance;
	}
	@Override
	public String toString() {
		return "YKTInformation [id=" + id +", state=" + getStateName() + ", balance=" + balance + ", transitionBalance" + transitionBalance + "]";
	}
}
