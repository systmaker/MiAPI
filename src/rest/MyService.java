package rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.PersonaDTO;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/servicio")

public class MyService {
	
	@GET
	@Path("/dolar")
	public String dolar(){
		return "0.836";
		}
	
	@GET
	@Path("/real")
	public String real(){
		return "0.28353";
	}
	
	@GET
	@Path("/euro")
	public String euro(){
		return "0.2370";
	}
	
	
	
	@GET
	@Path("/saludar")
	
	public String saludar(){
		return "Hola soy un servicio REST";
	}
	
	@GET
	@Path("/saludar/{parametro}")
	
	
	public String saludar(@PathParam("parametro") String parametro){
		return "Hola "+parametro+" soy un servicio REST!";
	}
	
	@GET
	@Path("/sumar/{param1}/{param2}")
	@Produces(MediaType.TEXT_PLAIN)
	
	public int sumar(@PathParam("param1")int param1, @PathParam("param2") int param2){
		return param1 + param2;
	}
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	
	
	public String registrarPersona(PersonaDTO persona){
		
		return "Los datos son "+ persona.getNombre()+" "+persona.getApellido()+" "+persona.getTelefono();
	}
	
	
	@GET
	@Path("/listar/{CantidadPersonas}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<PersonaDTO> listar(@PathParam("CantidadPersonas") int cantidadPersonas){
		List<PersonaDTO>listaPersonas= new ArrayList<>();
		for(int i=0; i <=cantidadPersonas;i++){
			PersonaDTO personaDTO = new PersonaDTO();
			personaDTO.setNombre("nombre "+i);
			personaDTO.setApellido("apellido "+i);
			listaPersonas.add(personaDTO);
		}
		return listaPersonas;
	}
	
	

}
