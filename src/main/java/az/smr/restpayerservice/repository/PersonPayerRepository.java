package az.smr.restpayerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import az.smr.restpayerservice.entity.PersonPayer;

@Repository
public interface PersonPayerRepository extends CrudRepository<PersonPayer, Long> {

	public PersonPayer findByVoen(String voen);

}
