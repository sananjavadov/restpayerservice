package az.smr.restpayerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import az.smr.restpayerservice.entity.JuridicalPayer;

@Repository
public interface JuridicalPayerRepository extends CrudRepository<JuridicalPayer, Long> {
	
	public JuridicalPayer findByVoen(String voen);
	
}
