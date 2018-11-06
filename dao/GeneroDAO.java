/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uade.tpbd2.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import org.bson.Document;

/**
 *
 * @author iguglielmone
 */
@Model
public class GeneroDAO {
    private Integer id;
    private String nombre;
    private MongoDatabase base;
    private MongoCollection coleccion;

    public GeneroDAO(Integer id, MongoDatabase base) {
        this.id = id;
        this.base = base;
        this.coleccion = base.getCollection("genres");
        FindIterable<Document> fi = coleccion.find(Filters.eq("id", this.id.toString()));      
        MongoCursor<Document> cursor = fi.iterator();
        Document doc = cursor.next();
        List list = new ArrayList(doc.values());
        this.nombre=(String)list.get(1);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    } 
}
