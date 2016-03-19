/**
 * 
 */
package entity;

/**
 * @author wan
 *
 */
public class Account extends Serializable {
	private String time;
    private String transactionType;
    private String subSystemName;
    private String electronicAccount;
    private float tradingVolume;
    private float balance;
    private String state;

	@Override
	protected void setProperty(String name, Object value) {
		 if (value.toString().equals("anyType{}"))
			 return;
		if(name.equals("time"))
			time = value.toString();
		else if(name.equals("transaction_type"))
			transactionType = value.toString();
		else if(name.equals("sub_system_name"))
			subSystemName = value.toString();
		else if(name.equals("electronic_account"))
			electronicAccount = value.toString();
		else if(name.equals("trading_volume"))
			tradingVolume = Float.parseFloat(value.toString());
		else if(name.equals("balance"))
			balance = Float.parseFloat(value.toString());
		else if(name.equals("state"))
			state = value.toString();
	}

	@Override
	public String toString() {
		return "Account [time=" + time + ", transactionType=" + transactionType + ", subSystemName=" + subSystemName
				+ ", electronicAccount=" + electronicAccount + ", tradingVolume=" + tradingVolume + ", balance="
				+ balance + ", state=" + state + "]";
	}

	public String getTime() {
		return time;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getSubSystemName() {
		return subSystemName;
	}

	public String getElectronicAccount() {
		return electronicAccount;
	}

	public float getTradingVolume() {
		return tradingVolume;
	}

	public float getBalance() {
		return balance;
	}

	public String getState() {
		return state;
	}

}
