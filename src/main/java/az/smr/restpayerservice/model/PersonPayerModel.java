package az.smr.restpayerservice.model;

public class PersonPayerModel {

	private String response="ok";
	
	private String voen;
	
	private String name;
	
	private String surname;
	
	private String fname;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getVoen() {
		return voen;
	}

	public void setVoen(String voen) {
		this.voen = voen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public PersonPayerModel(String voen, String name, String surname, String fname) {
		this.voen = voen;
		this.name = name;
		this.surname = surname;
		this.fname = fname;
	}
	
	
	
	
}
