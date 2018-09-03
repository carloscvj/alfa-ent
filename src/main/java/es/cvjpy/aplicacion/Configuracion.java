/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.aplicacion;

import es.cvjpy.cobol.EntornoCobol;
import java.io.Serializable;
import java.util.Properties;

/**
 *
 * @author carlos
 */
public final class Configuracion implements Serializable {

    private String base;
    private EntornoCobol entornoCobol;
    private Boolean mostrarInicial;
    private Properties prop;

    public Configuracion(String base) {
        this.base = base;
    }

    public void fromProperties(Properties prop) {
        entornoCobol = new EntornoCobol(base);
        entornoCobol.fromProperties(prop);
        mostrarInicial = Boolean.parseBoolean(prop.getProperty("aplicacion.mostrarinicial", "true"));
        this.prop = prop;
    }

    public Properties toProperties() {
        Properties suprop = getEntornoCobol().toProperties(prop);
        suprop.setProperty("aplicacion.mostrarinicial", "" + getMostrarInicial());
        return suprop;
    }

    public String getBase() {
        return base; //Este si es null es mejor que de el error. Es fundamental hacer el setBase en todas la aplicaciones.
    }

    public void setBase(String base) {
        this.base = base;
    }

    public EntornoCobol getEntornoCobol() {
        if (entornoCobol == null) {
            entornoCobol = new EntornoCobol(base);
            if (prop == null) {
                prop = new Properties();
            }
            entornoCobol.fromProperties(prop);
        }
        return entornoCobol;
    }

    public VersionAlfa getVersionAlfa() {
        return VersionAlfa.get(base);
    }

    public Boolean getMostrarInicial() {
        return mostrarInicial;
    }

    public void setMostrarInicial(Boolean mostrarInicial) {
        this.mostrarInicial = mostrarInicial;
    }

}
