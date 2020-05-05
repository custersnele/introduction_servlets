package be.pxl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Brewers")
@NamedQuery(name = "findByCity", query = "select b from Brewer as b where b.city = :city")
public class Brewer {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String address;
	private String zipCode;
	private String city;
	private int turnover;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	@Override
	public String toString() {
		return "Brewer [id=" + id + ", name=" + name + ", address=" + address + ", zipCode=" + zipCode + ", city="
				+ city + ", turnover=" + turnover + "]";
	}

}
