package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class Objeto {

	private City city = new City();
	
	
	//GETTERS Y SETTERS
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
