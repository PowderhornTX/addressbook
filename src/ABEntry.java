
public class ABEntry {

	private String fName, lName, phone, email;

	public ABEntry(String fName, String lName, String phone, String email) {
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return this.fName + ' ' + this.lName + "\nPhone: " + this.phone + "\nEmail: " + this.email;
	}
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
