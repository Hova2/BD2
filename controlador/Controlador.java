/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uade.tpbd2.controlador;

/**
 *
 * @author iguglielmone
 */

import ar.edu.uade.tpbd2.conector.ConectorMongoDb;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Controlador implements Serializable{
    
    private ConectorMongoDb conectorMongoDB;
    private MongoDatabase base;

    public Controlador() {
        this.conectorMongoDB=ConectorMongoDb.getInstancia();
        this.base=conectorMongoDB.getCliente().getDatabase("peliculas");
    }
    
    public MongoDatabase getBase(){
        return base;
    }    
}
