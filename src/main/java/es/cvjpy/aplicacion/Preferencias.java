/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.aplicacion;

import java.io.Serializable;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author CarlosVJ
 */
public class Preferencias implements Serializable {

    private AspectoSwing aspectoSwing;
    private String idioma;
    private String carpetaSeguridad;
    private String nombreFileEntorno;
    private Properties prop;

    public Preferencias() {
    }

    public void fromProperties(Properties prop) {
        getAspectoSwing().fromProperties(prop);
        setIdioma(prop.getProperty("idioma", getIdioma()));
        setCarpetaSeguridad(prop.getProperty("carpetaseguridad", getCarpetaSeguridad()));
        setNombreFileEntorno(prop.getProperty("nombrefileentorno", getNombreFileEntorno()));
        this.prop = prop;
    }

    public Properties toProperties() {
        prop = getAspectoSwing().toProperties(prop);
        prop.setProperty("idioma", getIdioma());
        prop.setProperty("carpetaseguridad", getCarpetaSeguridad());
        prop.setProperty("nombrefileentorno", getNombreFileEntorno());
        return prop;
    }

    public String getIdioma() {
        if (idioma == null) {
            idioma = Locale.getDefault().getLanguage();
        }
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
        Locale.setDefault(new Locale(idioma, Locale.getDefault().getCountry()));
    }

    public boolean isCastellano() {
        boolean ret = false;
        if (getIdioma().equals("es")) {
            ret = true;
        }
        return ret;
    }

    public void setCastellano(boolean castellano) {
        if (castellano) {
            setIdioma("es");
        }
    }

    public boolean isCatalan() {
        boolean ret = false;
        if (getIdioma().equals("ca")) {
            ret = true;
        }
        return ret;
    }

    public void setCatalan(boolean catalan) {
        if (catalan) {
            setIdioma("ca");
        }
    }

    public boolean isVasco() {
        boolean ret = false;
        if (getIdioma().equals("eu")) {
            ret = true;
        }
        return ret;
    }

    public void setVasco(boolean vasco) {
        if (vasco) {
            setIdioma("eu");
        }
    }

    public boolean isGallego() {
        boolean ret = false;
        if (getIdioma().equals("gl")) {
            ret = true;
        }
        return ret;
    }

    public void setGallego(boolean gallego) {
        if (gallego) {
            setIdioma("gl");
        }
    }

    public AspectoSwing getAspectoSwing() {
        if (aspectoSwing == null) {
            aspectoSwing = new AspectoSwing();
        }
        return aspectoSwing;
    }

    public String getCarpetaSeguridad() {
        if (carpetaSeguridad == null) {
            carpetaSeguridad = System.getProperty("user.home") + "/.alfa/users/" + System.getProperty("user.name");
        }
        return carpetaSeguridad.trim();
    }

    public void setCarpetaSeguridad(String carpetaSeguridad) {
        this.carpetaSeguridad = carpetaSeguridad;
    }

    public String getNombreFileEntorno() {
        if (nombreFileEntorno == null) {
            nombreFileEntorno = System.getProperty("user.home") + "/.alfa/users/" + System.getProperty("user.name") + "/terminal.properties";
        }
        return nombreFileEntorno;
    }

    public void setNombreFileEntorno(String nombreFileEntorno) {
        this.nombreFileEntorno = nombreFileEntorno;
    }
}
