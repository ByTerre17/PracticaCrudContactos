/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Contactos;
import modelo.ContactosCRUD;

/**
 * REST Web Service
 *
 * @author manue
 */
@Path("rest")
public class RestContactos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestContactos
     */
    public RestContactos() {
    }

    /**
     * Retrieves representation of an instance of controlador.RestContactos
     * @return an instance of java.lang.String
     */
   @GET
   @Path("/contacto/{id}")
   @Produces(MediaType.APPLICATION_JSON)
    public Response getContactoJson(@PathParam("id") int id  ) {
        Contactos miContacto = ContactosCRUD.getContacto(id);
        String nombre = miContacto.getNombre();
        String direccion = miContacto.getDireccion();
        int numero = miContacto.getNumero();
        
        String contacto = "{\"nombre\":\""+nombre+"\",\"direccion\":\""+direccion+"\",\"numero\":\""+numero+"\"}";
       
     Response.ResponseBuilder res = Response.ok(contacto);   
    return res.build();
    }
    
    @GET
   @Path("/contacto/")
   @Produces(MediaType.APPLICATION_JSON)
    public List<Contactos> getContactos() {
         List<Contactos> listaContactos = ContactosCRUD.getContactos();
    return listaContactos;
    }
    
    @POST
    @Path("/contacto/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contactos setProducto(Contactos cont){
        ContactosCRUD.insertarContacto(cont);
        return cont;
    }
    
    @DELETE
    @Path("/contacto/{id}")
    public String borraContacto(@PathParam("id") int id  ){
        ContactosCRUD.destroyContacto(id);
        return "Contacto eliminado";
    }

    /**
     * PUT method for updating or creating an instance of RestContactos
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
