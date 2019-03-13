package az.smr.restpayerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.smr.restpayerservice.entity.JuridicalPayer;
import az.smr.restpayerservice.exception.NotFoundException;
import az.smr.restpayerservice.service.JuridicalPayerService;
import az.smr.restpayerservice.service.OtherService;

@RestController
public class JuridicalPayerController {

	@Autowired
	OtherService otherService;
	
	@Autowired
	JuridicalPayerService payerService;
	
	@RequestMapping("/j/{voen}")
	ResponseEntity<Object> getJuridicalPayer(@PathVariable("voen") String voen,JuridicalPayer j) throws Exception {
		if (otherService.check(voen)) { 
			j=payerService.getByVoen(voen);
			if (j==null) { 
				j=payerService.getByParse((voen));
				return new ResponseEntity<Object>(otherService.parseJuridical(payerService.save(j)),HttpStatus.OK);
			}
			return new ResponseEntity<Object>(otherService.parseJuridical(j),HttpStatus.OK);
		}
		throw new NotFoundException();
	}
	
	
}
