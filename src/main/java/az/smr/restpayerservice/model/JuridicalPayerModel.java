package az.smr.restpayerservice.model;

public class JuridicalPayerModel {

	private String response="ok";
	
	private String voen;
	
	private String name;

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

	public JuridicalPayerModel(String voen, String name) {
		this.voen = voen;
		this.name = name;
	}
	
	
}
