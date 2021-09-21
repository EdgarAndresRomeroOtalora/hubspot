package es.hubspot.propiedades.model;

import java.util.List;

import lombok.Data;

@Data
public class Propiedades {
	private List<Propiedad> properties;

	public Propiedades(List<Propiedad> properties) {
		super();
		this.properties = properties;
	}

	public List<Propiedad> getProperties() {
		return properties;
	}

	public void setProperties(List<Propiedad> properties) {
		this.properties = properties;
	}
	
	
}
