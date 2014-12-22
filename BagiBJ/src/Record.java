
public class Record	{

	String name;
	String lastName;
	String address;
	String phoneNumber;
	
	public Record(String name, String address, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString()	{
		return name + " " + address + " " + phoneNumber;
	}

}