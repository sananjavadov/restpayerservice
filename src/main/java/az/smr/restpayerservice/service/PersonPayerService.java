package az.smr.restpayerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.smr.restpayerservice.entity.PersonPayer;
import az.smr.restpayerservice.exception.NotFoundException;
import az.smr.restpayerservice.repository.PersonPayerRepository;

@Service
@Transactional
public class PersonPayerService {

	@Autowired
	PersonPayerRepository repository;
	
	private Scanner scanner;
	
	public PersonPayer save(PersonPayer p) {
		return repository.save(p);
	}
	
	public PersonPayer getByVoen(String voen) {
		return repository.findByVoen(voen);
	}
	
	private PersonPayer StringParse(String voen,String fullname) throws Exception {
		scanner = new Scanner(fullname);
		List<String> list=new ArrayList<String>();
				
		while (scanner.hasNext()) {
			list.add(scanner.next());		
		}
		
		if (list.size()==2) {
			return new PersonPayer(voen, list.get(1), list.get(0), null);
		}else if (list.size()>2) {
			return new PersonPayer(voen, list.get(1), list.get(0), list.get(2));
		}else {
			throw new Exception("Bilinmyən xəta");
		}
		
	}
	
	public PersonPayer getByParse(String voen) throws Exception {
		List<String> list=new ArrayList<String>();
		
		Document d=Jsoup.connect("https://www.e-taxes.gov.az/ebyn/payerOrVoenChecker.jsp?tip=P&voenOrName=V&voen="+voen+"&name=&submit=++Yoxla+++").post();
		Elements paragraphs=d.getElementsByTag("td");
		
		for(Element paragraph:paragraphs) {
			list.add(paragraph.text());
		}
		
		if(list.size()==34) {
			System.out.println(list.get(32));
			return StringParse(voen, list.get(32));
		}else if (list.size()==36) {
			System.out.println(list.get(33));
			return StringParse(voen, list.get(33));
		}else {
			throw new NotFoundException();
		}
	}
}
