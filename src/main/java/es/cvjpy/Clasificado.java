/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class Clasificado implements Serializable {

    private String id;
    private String descripcion;
    private String cobolKey;

    public Clasificado() {
        this.id = "obj.id";
        this.descripcion = "Identificador";
    }
    public Clasificado(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Clasificado(String id, String descripcion, String cobolKey) {
        this.id = id;
        this.descripcion = descripcion;
        this.cobolKey=cobolKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }

    public String getCobolKey() {
        return cobolKey;
    }

    public void setCobolKey(String cobolKey) {
        this.cobolKey = cobolKey;
    }
}
