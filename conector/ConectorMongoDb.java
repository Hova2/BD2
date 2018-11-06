/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uade.tpbd2.conector;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author iguglielmone
 */
public class ConectorMongoDb {
    
    private MongoClientURI uRI;
    private MongoClient cliente;
    private static ConectorMongoDb INSTANCIA=null;

    private ConectorMongoDb() {
        this.uRI = new MongoClientURI("mongodb://localhost:27017");
        this.cliente = new MongoClient(this.uRI);    
    }
    
    private static void crearInstancia() {
        if (INSTANCIA == null) {
            // Solo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized(ConectorMongoDb.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCIA == null) { 
                    INSTANCIA = new ConectorMongoDb();
                }
            }
        }
    }
    
    public static ConectorMongoDb getInstancia(){
        crearInstancia();
        return INSTANCIA;
    }
    
    public MongoClient getCliente(){
        return this.cliente;
    }
}
