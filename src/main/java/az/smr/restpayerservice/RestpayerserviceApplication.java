package az.smr.restpayerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestpayerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestpayerserviceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(getClientHttpRequestFactory());
	            
	}
	
	public ClientHttpRequestFactory getClientHttpRequestFactory() {
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(100*1000); 
	    clientHttpRequestFactory.setReadTimeout(100*1000);
	    return clientHttpRequestFactory;
	}
	
}
