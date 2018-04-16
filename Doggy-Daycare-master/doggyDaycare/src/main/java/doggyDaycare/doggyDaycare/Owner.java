package doggyDaycare.doggyDaycare;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {

	private int ownerId;
	private String firstName;
	private String lastName;
	private String phone;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Owner() {
		super();
	}

	public Owner(String firstName, String lastName, String phone, String street, String city, String state,
			String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getOwnerId() {
		return ownerId;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
}