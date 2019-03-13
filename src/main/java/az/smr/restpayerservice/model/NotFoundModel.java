package az.smr.restpayerservice.model;

public class NotFoundModel {

	private String response="fail";
	
	private String message="Vöen mövcud deyil";

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public NotFoundModel() {
		
	}

	public NotFoundModel(String message) {
		this.message = message;
	}
	
	
	
}
