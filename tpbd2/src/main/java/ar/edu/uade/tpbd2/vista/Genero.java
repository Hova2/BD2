/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.uade.tpbd2.vista;

import java.io.Serializable;

import javax.enterprise.inject.Model;

import ar.edu.uade.tpbd2.controlador.Controlador;

/**
 *
 * @author iguglielmone
 */

@Model
public class Genero implements Serializable{
    
    private Integer id;
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        ;
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void buscarGenero() {
    	Controlador cont = new Controlador();
    	this.nombre = cont.getGeneroNombre(this.id);
    }
}
