package az.smr.restpayerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="juridical")
@Table(name="juridical_payer")
public class JuridicalPayer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="juridical_id")
	private long id;
	
	@Column(name="juridical_voen", unique=true, nullable=false)
	private String voen;
	
	@Column(name="juridical_name")
	private String name;

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

	public JuridicalPayer(String voen, String name) {
		this.voen = voen;
		this.name = name;
	}

	public JuridicalPayer() {

	}

	@Override
	public String toString() {
		return "JuridicalPayer [id=" + id + ", voen=" + voen + ", name=" + name + "]";
	}
	
}
