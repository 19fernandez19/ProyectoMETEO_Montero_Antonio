package modelo;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public class Forecast {
	
	private ArrayList<ForecastDay> forecastDay = null;

	//GETTERS Y SETTERS
	public ArrayList<ForecastDay> getForecastDay() {
		return forecastDay;
	}

	public void setForecastDay(ArrayList<ForecastDay> forecastDay) {
		this.forecastDay = forecastDay;
	}
}
