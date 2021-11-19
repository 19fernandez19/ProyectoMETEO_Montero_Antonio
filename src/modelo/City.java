package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class City {
	
	//VARIABLES
	private Forecast forecast = new Forecast();
	private String cityName = null;
	
	
	//GETTERS Y SETTERS
	public Forecast getForecast() {
		return forecast;
	}
	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
