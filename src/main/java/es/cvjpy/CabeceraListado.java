/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author CarlosVJ
 */
public class CabeceraListado implements Serializable {

    private String titulo;
    private Date fechaEmision;

    public CabeceraListado() {
    }

    public String getTitulo() {
        if (titulo == null) {
            titulo = "";
        }
        return titulo.trim();
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaEmision() {
        if (fechaEmision == null) {
            fechaEmision = new Date();
        }
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
