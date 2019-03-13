package az.smr.restpayerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.smr.restpayerservice.entity.JuridicalPayer;
import az.smr.restpayerservice.exception.NotFoundException;
import az.smr.restpayerservice.repository.JuridicalPayerRepository;

@Service
@Transactional
public class JuridicalPayerService {

	@Autowired
	JuridicalPayerRepository repository;
	
	public JuridicalPayer save(JuridicalPayer j) {
		return repository.save(j);
	}
	
	public JuridicalPayer getByVoen(String voen) {
		return repository.findByVoen(voen);
	}
	
	public JuridicalPayer getByParse(String voen) throws Exception {
		List<String> list=new ArrayList<String>();
		
		Document d=Jsoup.connect("https://www.e-taxes.gov.az/ebyn/payerOrVoenChecker.jsp?tip=L&voenOrName=V&voen="+voen+"&name=&submit=++Yoxla+++").get();
		Elements paragraphs=d.getElementsByTag("td");
		
		for(Element paragraph :paragraphs) {			
			list.add(paragraph.text());
		}
		
		if (list.size()==34) { 
			
			return new JuridicalPayer((list.get(31)), list.get(32)); 
		}else if(list.size()==36) {

			return new JuridicalPayer(list.get(32), list.get(33)); 
		}else {
			
			throw new NotFoundException(); 
		}
				

	}
}
