package az.smr.restpayerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import az.smr.restpayerservice.entity.JuridicalPayer;
import az.smr.restpayerservice.entity.PersonPayer;
import az.smr.restpayerservice.model.CheckModel;
import az.smr.restpayerservice.model.JuridicalPayerModel;
import az.smr.restpayerservice.model.PersonPayerModel;

@Service
public class OtherService {

	@Autowired
	RestTemplate rs;
	
	public boolean check(String voen) { 
		CheckModel object=rs.getForObject("https://www.e-taxes.gov.az/isvatpayer/{voen}", CheckModel.class, voen);
		if (object.RESULT==3) {
			return false;
		}
		return true;
	}
	
	public JuridicalPayerModel parseJuridical(JuridicalPayer j) {
		return new JuridicalPayerModel(j.getVoen(), j.getName());
	}
	
	public PersonPayerModel parsePerson(PersonPayer j) {
		return new PersonPayerModel(j.getVoen(), j.getName(), j.getSurname(), j.getFname());
	}
}
