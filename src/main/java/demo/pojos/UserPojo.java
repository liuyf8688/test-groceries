package demo.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import demo.liuyf.jackson.annotation.MongoJsonIgnore;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {

	private String firstName;
	private String lastName;
	@JsonIgnore
	private int age;
	@MongoJsonIgnore(value = false)
	@JsonIgnore
	private boolean male = true;
	
	@MongoJsonIgnore
	public String getAbc() {
		return firstName + lastName;
	}
	
	private AddressPojo address;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@JsonIgnore
	public AddressPojo getAddress() {
		return address;
	}

	@JsonProperty
	public void setAddress(AddressPojo address) {
		this.address = address;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}
	
}
