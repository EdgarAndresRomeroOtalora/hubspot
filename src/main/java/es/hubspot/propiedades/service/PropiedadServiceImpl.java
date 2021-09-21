package es.hubspot.propiedades.service;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;


import es.hubspot.propiedades.client.UsuarioClient;
import es.hubspot.propiedades.model.Contacto;

@Service
public class PropiedadServiceImpl {

	
	@Autowired
	private UsuarioClient usuarioClient;
	

	
	/*public String crearUsuario(Propiedad nuevoUsuario) {
		List<Propiedad> propiedades = new ArrayList<>();
		propiedades.add(nuevoUsuario);
		propiedades.add(nuevoUsuario);
		Gson gson = new Gson();
		
		Propiedades propertiesToPost = new Propiedades(propiedades);
		String json = gson.toJson(propertiesToPost);
		System.out.println("Imprimiendo"+json);
		return usuarioClient.createUser(json);
	}*/
	
	public String getAllUser() {		
		return usuarioClient.obtenerPorId();
	}
	
	public String create(Contacto HSContact)  {
        if (Strings.isNullOrEmpty(HSContact.getEmail())) {
            System.out.println("User email must be provided");
        }
        //System.out.println(HSContact.toJsonString());
        //System.out.println("ID= "+ HSContact.getId());
        
         return usuarioClient.crearUsuario(HSContact.toJsonString());
    }
	
	/*public String delete(){
        /*if (HSContact.getId() == 0) {
        	System.out.println("User email must be provided");
        }  
        
        return usuarioClient.deleteArchivo();
    }*/

	
	

}
