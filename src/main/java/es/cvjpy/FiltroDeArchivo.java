/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class FiltroDeArchivo implements FileFilter, Serializable {

    private String[] sufijos;
    private boolean carpetas;
    private String descripcion;

    public FiltroDeArchivo() {
    }

    @Override
    public boolean accept(File dir) {
        if (dir.isDirectory()) {
            return (carpetas);
        }
        String name = dir.getAbsolutePath();
        if (getSufijos() != null) {
            int i;
            for (i = 0; i < getSufijos().length; i++) {
                String c_final = "." + getSufijos()[i];
                if (name.endsWith(c_final.toLowerCase())) {
                    return (true);
                }
                if (name.endsWith(c_final.toUpperCase())) {
                    return (true);
                }
            }
        }
        return false;
    }

    public String[] getSufijos() {
        return sufijos;
    }

    public void setSufijos(String[] sufijos) {
        this.sufijos = sufijos;
    }

    public boolean isCarpetas() {
        return carpetas;
    }

    public void setCarpetas(boolean carpetas) {
        this.carpetas = carpetas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
