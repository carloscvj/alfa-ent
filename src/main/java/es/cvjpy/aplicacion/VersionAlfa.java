/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.aplicacion;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 *
 * @author carlos
 */
public class VersionAlfa implements Serializable {

    public static void say(String args) {
        System.out.println(ResourceBundle.getBundle("versiones").getString(args));
    }

    public static VersionAlfa get(String base) {
        VersionAlfa ret = new VersionAlfa();
        ret.setAplicacion(ResourceBundle.getBundle("versiones").getString(base + ".aplicacion"));
        ret.setVersion(ResourceBundle.getBundle("versiones").getString(base + ".version"));
        ret.setActualizacion(ResourceBundle.getBundle("versiones").getString(base + ".actualizacion"));
        ret.setCarpeta(ResourceBundle.getBundle("versiones").getString(base + ".carpeta"));

        ret.setPuertoCob(ResourceBundle.getBundle("versiones").getString(base + ".puertocob"));
        ret.setPuertoSys(ResourceBundle.getBundle("versiones").getString(base + ".puertosys"));

        return ret;

    }
    private String aplicacion;
    private String version;
    private String actualizacion;
    private String carpeta;
    private String puertoCob = "0";
    private String puertoSys = "0";

    public VersionAlfa() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.aplicacion != null ? this.aplicacion.hashCode() : 0);
        hash = 29 * hash + (this.version != null ? this.version.hashCode() : 0);
        hash = 29 * hash + (this.actualizacion != null ? this.actualizacion.hashCode() : 0);
        hash = 29 * hash + (this.carpeta != null ? this.carpeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VersionAlfa other = (VersionAlfa) obj;
        if ((this.aplicacion == null) ? (other.aplicacion != null) : !this.aplicacion.equals(other.aplicacion)) {
            return false;
        }
        if ((this.version == null) ? (other.version != null) : !this.version.equals(other.version)) {
            return false;
        }
        if ((this.actualizacion == null) ? (other.actualizacion != null) : !this.actualizacion.equals(other.actualizacion)) {
            return false;
        }
        if ((this.carpeta == null) ? (other.carpeta != null) : !this.carpeta.equals(other.carpeta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VersionAlfa{" + "aplicacion=" + aplicacion + ", version=" + version + ", actualizacion=" + actualizacion + ", carpeta=" + carpeta + ", puertoCob=" + puertoCob + ", puertoSys=" + puertoSys + '}';
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(String actualizacion) {
        this.actualizacion = actualizacion;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public String getPuertoCob() {
        return puertoCob;
    }

    public void setPuertoCob(String puertoCob) {
        this.puertoCob = puertoCob;
    }

    public String getPuertoSys() {
        return puertoSys;
    }

    public void setPuertoSys(String puertoSys) {
        this.puertoSys = puertoSys;
    }
}
