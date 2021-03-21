/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.*;
import java.util.List;


public class ContactosCRUD {
     public static List<Contactos> getContactos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_practicaAgenda_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM contactos";
        Query q = manager.createNativeQuery(sql,Contactos.class); //método para consultas en SQL
        List<Contactos> contactosBD =  q.getResultList();

        return contactosBD;        
        }    
     
        
       
       public static int actualizaContacto(Contactos miContacto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_practicaAgenda_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Contactos c SET c.nombre = :nombre, c.direccion = :direccion, c.numero = :numero WHERE c.id = :id";
        Query q = manager.createQuery(sql,Contactos.class);
        q.setParameter("id", miContacto.getId());
        q.setParameter("nombre", miContacto.getNombre());
        q.setParameter("direccion", miContacto.getDireccion());
        q.setParameter("numero", miContacto.getNumero());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return filasAfectadas;      
    }
       
        public static void insertarContacto(Contactos contacto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_practicaAgenda_war_1PU");
        EntityManager manager = factory.createEntityManager();
         manager.getTransaction().begin();
        manager.merge(contacto);
        manager.getTransaction().commit();
        }
        
        public static int destroyContacto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_practicaAgenda_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Contactos c WHERE c.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;  
    }
        
      public static Contactos getContacto(int id) {  
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_practicaAgenda_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT c FROM Contactos c WHERE c.id=" + id;
        Query q = manager.createQuery(sql,Contactos.class); //método para consultas en SQL
        Contactos miContacto =  ( Contactos ) q.getSingleResult(); //para un único registro
        manager.close();
        return  miContacto;
        } 


}
