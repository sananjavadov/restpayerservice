package az.smr.restpayerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="person")
@Table(name="person_payer")
public class PersonPayer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private long id;
	
	@Column(name="person_voen",unique=true,nullable=false)
	private String voen;
	
	@Column(name="person_name")
	private String name;
	
	@Column(name="person_surname")
	private String surname;
	
	@Column(name="person_fathername")
	private String fname;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	

	public PersonPayer() {
		
	}

	public PersonPayer(String voen, String name, String surname, String fname) {
		this.voen = voen;
		this.name = name;
		this.surname = surname;
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "PersonPayer [id=" + id + ", voen=" + voen + ", name=" + name + ", surname=" + surname + ", fname="
				+ fname + "]";
	}
	
}