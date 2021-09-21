package es.hubspot.propiedades.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//https://api.hubapi.com/contacts/v1/contact/?hapikey=afe6b7c4-d592-447c-973f-a2c65eb9e906   CREAR
//https://api.hubapi.com/contacts/v1/contact/vid/1001/profile?hapikey=afe6b7c4-d592-447c-973f-a2c65eb9e906   VER POR ID
//https://api.hubapi.com/contacts/v1/contact/vid/1001?hapikey=afe6b7c4-d592-447c-973f-a2c65eb9e906

@FeignClient(value="UsuarioClient",url="https://api.hubapi.com/contacts/v1/contact/?hapikey=afe6b7c4-d592-447c-973f-a2c65eb9e906")

public interface UsuarioClient {
	@RequestMapping(method = RequestMethod.POST, value = "", consumes = "application/json")
    String crearUsuario(String propiedades);

	@RequestMapping(method = RequestMethod.GET, value = "")
	String obtenerPorId();
	
	@RequestMapping(method = RequestMethod.DELETE, value = "")
	String deleteArchivo(String propiedades);
	
}


