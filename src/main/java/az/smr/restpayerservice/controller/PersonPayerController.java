package az.smr.restpayerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.smr.restpayerservice.entity.PersonPayer;
import az.smr.restpayerservice.exception.NotFoundException;
import az.smr.restpayerservice.service.OtherService;
import az.smr.restpayerservice.service.PersonPayerService;

@RestController
public class PersonPayerController {
	
	@Autowired
	PersonPayerService payerService;
	
	@Autowired
	OtherService otherService;

	@RequestMapping("/p/{voen}")
	ResponseEntity<Object> getPersonPayer(@PathVariable("voen") String voen, PersonPayer p) throws Exception {
		if(otherService.check(voen)) {
			p=payerService.getByVoen(voen);
			if (p==null) {
				p=payerService.getByParse(voen);
				return new ResponseEntity<Object>(otherService.parsePerson(payerService.save(p)),HttpStatus.OK);
			}
			return new ResponseEntity<Object>(otherService.parsePerson(p),HttpStatus.OK);
		}
		throw new NotFoundException();
	}
	
}
