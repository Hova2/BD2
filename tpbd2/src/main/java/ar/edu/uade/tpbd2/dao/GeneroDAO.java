/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uade.tpbd2.dao;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

import java.util.ArrayList;
import java.util.Collection;
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
    private MongoCollection<Document> coleccion;

    public GeneroDAO(Integer id, MongoDatabase base) {
        this.id = id;
        this.base = base;
        this.coleccion = this.base.getCollection("genres");
        //FindIterable<Document> fi = this.coleccion.find(Filters.eq("id", this.id.toString()));      
        FindIterable<Document> fi = this.coleccion.find().projection(Projections.include("genres"));
        MongoCursor<Document> cursor = fi.iterator();
        Document doc = cursor.next();
        List<Object> list = new ArrayList<>(doc.values());
        this.nombre=Integer.toString(list.size());
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    } 
}
