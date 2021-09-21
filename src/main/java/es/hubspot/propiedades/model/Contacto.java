package es.hubspot.propiedades.model;

import com.google.common.base.Strings;

import es.hubspot.propiedades.model.util.HubSpotHelper;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Contacto {
	private Map<String, String> properties = new HashMap<>();

    public Contacto() {
    }

    public Contacto(String email, String firstname, String lastname) {
        this.properties.put("email", email);
        this.properties.put("firstname", firstname);
        this.properties.put("lastname", lastname);
    }

    public Contacto(long id, String email, String firstname, String lastname, Map<String, String> properties) {
        this.properties.put("vid", Long.toString(id));
        this.properties.put("email", email);
        this.properties.put("firstname", firstname);
        this.properties.put("lastname", lastname);
        this.properties.putAll(properties);
    }

    public long getId() {
        return !Strings.isNullOrEmpty(this.properties.get("vid")) ? Long.parseLong(this.properties.get("vid")) : 0;
    }

    public Contacto setId(long id) {
        this.properties.put("vid", Long.toString(id));
        return this;
    }

    public String getEmail() {
        return this.properties.get("email");
    }

    public Contacto setEmail(String email) {
        this.properties.put("email", email);
        return this;
    }

    public String getFirstname() {
        return this.properties.get("firstname");
    }

    public Contacto setFirstname(String firstname) {
        this.properties.put("firstname", firstname);
        return this;
    }

    public String getLastname() {
        return this.properties.get("lastname");
    }

    public Contacto setLastname(String lastname) {
        this.properties.put("lastname", lastname);
        return this;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public Contacto addProperties(Map<String, String> properties) {
        properties.forEach((k, v) -> this.setProperty(k, v));
        return this;
    }

    public Contacto setProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

    public Contacto setProperty(String property, String value) {
        if(value != null && !value.equals("null")){
            this.properties.put(property, value);
        }

        return this;
    }

    public String getProperty(String property) {
        return this.properties.get(property);
    }

    public String toJsonString() {
        return toJson().toString();
    }

    public JSONObject toJson() {

        Map<String, String> properties = new HashMap<>(getProperties());
        properties.remove("vid");

        return HubSpotHelper.mapToJson(properties);
    }
}
