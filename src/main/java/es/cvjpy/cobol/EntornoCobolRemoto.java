/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.cobol;

import es.cvjpy.aplicacion.VersionAlfa;
import java.util.Properties;

/**
 *
 * @author CarlosVJ
 */
public class EntornoCobolRemoto implements java.io.Serializable {

    private final String base;
    private String host;
    private int puertoCob;
    private int puertoSys;

    public EntornoCobolRemoto(String base) {
        this.base = base;
    }

    public String getHost() {
        if (host == null) {
            host = "localhost";
        }
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPuertoCob() {
        if (puertoCob == 0) {
            puertoCob = Integer.parseInt(getVersionAlfa().getPuertoCob());
        }
        return puertoCob;
    }

    public void setPuertoCob(int puertoCob) {
        this.puertoCob = puertoCob;
    }

    public int getPuertoSys() {
        if (puertoSys == 0) {
            puertoSys = Integer.parseInt(getVersionAlfa().getPuertoSys());
        }
        return puertoSys;
    }

    public void setPuertoSys(int puertoSys) {
        this.puertoSys = puertoSys;
    }

    public int getTimeout() {
        return 0;
    }

    public void fromProperties(Properties prop) {
        host = prop.getProperty("cobolservidor.host", this.getHost());
        puertoCob = Integer.parseInt(prop.getProperty("cobolservidor.puertocob", "" + this.getPuertoCob()));
        puertoSys = Integer.parseInt(prop.getProperty("cobolservidor.puertosys", "" + this.getPuertoSys()));
    }

    public Properties toProperties(Properties prop) {
        prop.setProperty("cobolservidor.host", this.getHost());
        prop.setProperty("cobolservidor.puertocob", "" + this.getPuertoCob());
        prop.setProperty("cobolservidor.puertosys", "" + this.getPuertoSys());
        prop.setProperty("cobolservidor.timeout", "" + this.getTimeout());
        return prop;
    }

    public VersionAlfa getVersionAlfa() {
        return VersionAlfa.get(base);
    }

}
