package tum.seba.mobilityservices.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ServicePoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String name;
	@NotBlank
	private String streetName;
	@Positive
	private int streetNumber;
	@NotBlank
	private String city;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties({"servicePoints"})
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "startLocation", cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties({"customer","vehicle","invoice","startLocation","endLocation"})
	private List<Rental> rentalsStart;
	
	@OneToMany(mappedBy = "endLocation", cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties({"customer","vehicle","invoice","startLocation","endLocation"})
	private List<Rental> rentalsEnd;
	
	@OneToMany(mappedBy = "currentLocation", cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties({"rentals","currentLocation"})
	private List<Vehicle> vehicles;
	
	public ServicePoint() {}
	
	public ServicePoint(String name, String streetName, int streetNumber, String city) {
		this.name = name;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Rental> getRentalsStart() {
		return rentalsStart;
	}

	public void setRentalsStart(List<Rental> rentalsStart) {
		this.rentalsStart = rentalsStart;
	}

	public List<Rental> getRentalsEnd() {
		return rentalsEnd;
	}

	public void setRentalsEnd(List<Rental> rentalsEnd) {
		this.rentalsEnd = rentalsEnd;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "ServicePoint [id=" + id + ", name=" + name + ", streetName=" + streetName + ", streetNumber="
				+ streetNumber + ", city=" + city + "]";
	}

}
